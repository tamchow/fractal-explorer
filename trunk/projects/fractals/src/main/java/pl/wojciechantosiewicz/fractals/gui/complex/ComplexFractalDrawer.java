/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * $Id$
 */
package pl.wojciechantosiewicz.fractals.gui.complex;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import javax.swing.JPanel;

import pl.wojciechantosiewicz.fractals.ExecutionControl;
import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.image.CoordinateTransform;
import pl.wojciechantosiewicz.image.CoordinateTransform3D;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class ComplexFractalDrawer extends JPanel implements Runnable {
	// ~ Static fields/initializers
	// -----------------------------------------------------------------------------------
	private static final int MARGIN = 5;
	// ~ Instance fields
	// ----------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Rectangle rect = new Rectangle();

	private CoordinateTransform ct = new CoordinateTransform3D(getWidth(),
			getHeight());

	private Thread thread;

	private Point startPoint = new Point(0, 0);

	private Point endPoint = new Point(0, 0);

	private BufferedImage bi;

	private boolean running = false;

	private boolean mouseDragged = false;

	private final ExecutionControl executionControl = ExecutionControl.getInstance();

	private ComplexFractal complexFractal;

	private NumberFormat numberFormat = NumberFormat.getInstance();

	private FontMetrics fontMetrics;

	private boolean previewEnabled = false;
	// ~ Constructors
	// -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new ComplexFractalDrawer object.
	 * 
	 * @param applet
	 *            DOCUMENT ME!
	 */
	public ComplexFractalDrawer() {
		super();
		numberFormat.setMaximumFractionDigits(5);
		numberFormat.setMinimumFractionDigits(5);
		numberFormat.setMaximumIntegerDigits(2);
		numberFormat.setMinimumIntegerDigits(1);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ct.setScreenDimensions(getWidth(), getHeight());
				bi = new BufferedImage(getWidth(), getHeight(),	BufferedImage.TYPE_INT_RGB);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				synchronized (this) {
					startPoint = e.getPoint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				synchronized (this) {
					mouseDragged = false;
					endPoint = e.getPoint();
				}
				
				if(complexFractal != null){
					setRectangle();

					Point2D start = ct.screenToUser(rect.x, rect.y);
					Point2D end = ct.screenToUser(rect.x + rect.width, rect.y + rect.height);
					ct.setUserDimensionX(start.getX(), end.getX());
					ct.setUserDimensionY(end.getY(), start.getY());
				
					repaintFractal(false);
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {

			/**
			 * DOCUMENT ME!
			 * 
			 * @param e
			 *            DOCUMENT ME!
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				if (running) {
					synchronized (this) {
						mouseDragged = false;
					}

					return;
				}

				synchronized (this) {
					mouseDragged = true;
					endPoint = e.getPoint();
					setRectangle();
				}

				repaint();
			}
		});
		fontMetrics = getFontMetrics(this.getFont());
	}

	// ~ Methods
	// ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @param complexFractal
	 *            DOCUMENT ME!
	 * @param clear
	 *            DOCUMENT ME!
	 */
	public void drawFractal(ComplexFractal complexFractal) {
		setFractal(complexFractal, true);
		
		stopDrawing();

		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public void repaintFractal(boolean discardZoom){
		if(discardZoom){
			discardZoom();
		}
		
		previewEnabled = executionControl.isPreviewEnabled();
		
		thread = new Thread(this);
		running = true;
		thread.start();
//		executionControl.getInstance().drawComplex(discardZoom);
	}
	
	public void setFractal(ComplexFractal complexFractal, boolean originalZoom) {
		this.complexFractal = complexFractal;
		if(originalZoom){
			discardZoom();
		}
	}


	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	public void run() {
		int x = 0;
		int y = 0;
		double u;
		double v;
		final int w = getWidth();
		final int h = getHeight();
		final double du = (ct.getMaxX() - ct.getMinX()) / w;
		final double dv = (ct.getMaxY() - ct.getMinY()) / h;

		for (y = 0, v = ct.getMaxY(); y < h; y++, v -= dv) {
			for (x = 0, u = ct.getMinX(); x < w; x++, u += du) {
				if (running == false) {
					repaint();
					return;
				}
				bi.setRGB(x, y, complexFractal.rgbColor(u, v));
			} // for x

			final int value = x + y * w;
			
			executionControl.setProgress(value);
			
			if (previewEnabled) {
				repaint(0, y, w-1, 1);
			}
		} // for y

		repaint();
		running = false;
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	private final void setRectangle() {
		int width = endPoint.x - startPoint.x;
		int height = endPoint.y - startPoint.y;
		int x;
		int y;

		if (width > 0) {
			x = startPoint.x;
		} else {
			x = endPoint.x;
			width = -width;
		}

		if (height > 0) {
			y = startPoint.y;
		} else {
			y = endPoint.y;
			height = -height;
		}

		rect.setBounds(x, y, width, height);
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	public void stopDrawing() {
		running = false;

		try {
			if (thread != null) {
				thread.join(50);
			}
		} catch (InterruptedException ie) {
		}
	}

	// *******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	public void discardZoom() {
		FormulaProperties properties = complexFractal.getFormula().getProperties();
		ct.setUserDimensions(
				properties.getMinRe(),
				properties.getMaxRe(), 
				properties.getMinIm(),
				properties.getMaxIm());
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	public void clearPanel() {
		if (running) {
			stopDrawing();
		}

		bi.createGraphics().clearRect(0, 0, bi.getWidth(), bi.getHeight());
		this.getGraphics().clearRect(0, 0, getWidth(), getHeight());
		repaint();
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 * 
	 * @param g
	 *            DOCUMENT ME!
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bi, 0, 0, this);

		if (mouseDragged) {
			g2.setColor(Color.white);
			g2.draw(rect);

			drawStringInRectangle(startPoint, g2, true);
			drawStringInRectangle(endPoint, g2, false);
			
		}
	}
	
	// **********************************************************************************
	
	private void drawStringInRectangle(Point point, Graphics2D g2, boolean beforePointer){
		StringBuilder sb = new StringBuilder("[ ");
		Point2D userPoint = ct.screenToUser(point.getX(), point.getY());
		sb.append(numberFormat.format(userPoint.getX()));
		sb.append("; ").append(numberFormat.format(userPoint.getY())).append(" ]");

		int rectWidth = fontMetrics.stringWidth(sb.toString()) + 4;
		int rectHeight = fontMetrics.getHeight() + 3;
		int x; // coordinates of the info rectangle
		int y; // coordinates of the info rectangle
		int pointX = (int) Math.round(point.getX());
		int pointY = (int) Math.round(point.getY());

		if(beforePointer){
			if (pointX < MARGIN || (pointX - rectWidth) < MARGIN) {
				x = MARGIN;
			} else if ((pointX + rectWidth) > bi.getWidth()) {
				x = bi.getWidth() - rectWidth - MARGIN;
			} else {
				x = pointX - rectWidth - MARGIN;
			}

			if (pointY < MARGIN || (pointY - rectHeight) < MARGIN) {
				y = MARGIN;
			} else if ((pointY + rectHeight) > bi.getHeight()) {
				y = bi.getHeight() - rectHeight - MARGIN;
			} else {
				y = pointY - rectHeight - MARGIN;
			}
		}else{
			if (pointX < MARGIN || (pointX) < MARGIN) {
				x = MARGIN;
			} else if ((pointX + rectWidth + MARGIN) > bi.getWidth()) {
				x = bi.getWidth() - rectWidth - MARGIN;
			} else {
				x = pointX + MARGIN;
			}

			if (pointY < MARGIN || (pointY) < MARGIN) {
				y = MARGIN;
			} else if ((pointY + rectHeight + MARGIN) > bi.getHeight()) {
				y = bi.getHeight() - rectHeight - MARGIN;
			} else {
				y = pointY + MARGIN;
			}
		}
		
		

		g2.setColor(Color.white);
		
		g2.fillRect(x, y, rectWidth, rectHeight);
		g2.setColor(Color.black);
		g2.drawString(sb.toString(), x + 2, y + fontMetrics.getHeight() - 3);
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public boolean isRunning() {
		return running;
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	public void fixAspectRatio() {
		double xSpan = ct.getMaxX() - ct.getMinX();
		double ySpan = ct.getMaxY() - ct.getMinY();

		if (xSpan > ySpan) { // wide

			double c = (xSpan - ySpan) / 2.0;
			ct.setUserDimensionY(ct.getMinY() - c, ct.getMaxY() + c);
		} else { // tall

			double c = (ySpan - xSpan) / 2.0;
			ct.setUserDimensionX(ct.getMinX() - c, ct.getMaxX() + c);
		}
	}

	/**
	 * @return the complexFractal
	 */
	public boolean isFractalSet() {
		return complexFractal != null;
	}

	/**
	 * @param previewEnabled the previewEnabled to set
	 */
	public void setPreviewEnabled(boolean previewEnabled) {
		this.previewEnabled = previewEnabled;
	}
}
