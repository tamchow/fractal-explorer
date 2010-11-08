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
 */
package pl.wojciechantosiewicz.fractals;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.gui.complex.ComplexFractalDrawer;
import pl.wojciechantosiewicz.fractals.gui.complex.ComplexTopLevelPanel;
import pl.wojciechantosiewicz.fractals.gui.ifs.IFSFractalDrawer;
import pl.wojciechantosiewicz.fractals.gui.ifs.IFSTopLevelPanel;
import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;

/**
 * This class plays the role of mediator object which coordinates actions
 * between various components(GUI).
 * 
 * @author Wojciech Antosiewicz
 */
public class ExecutionControl {
	private ComplexTopLevelPanel complexTopLevelPanel;

	private IFSTopLevelPanel ifsTopLevelPanel;

	private JProgressBar progressBar;

	private JLabel statusLabel;

	private static ExecutionControl INSTANCE = new ExecutionControl();

	private ExecutionControl() {
		super();
	}

	/**
	 * Returns singleton instance of this class
	 * @return an instance of this class
	 */
	public static final ExecutionControl getInstance(){
		return INSTANCE;
	}

	/**
	 * Sets appropriate parameters in drawer object and starts drawing
	 * of complex fractal
	 * 
	 * @param discardZoom flag indicating whether zoom is to be discarded. 
	 * If set to <code>true</code> original zoom (ranges along both axes) is used
	 */
	public void drawComplex(boolean discardZoom){
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		ComplexFractal fractal = complexTopLevelPanel.getComplexFractal();
		resetProgressBar();

		fractal.setPalette(complexTopLevelPanel.getPalette());
		fractal.setFormula(complexTopLevelPanel.getFormula());

		drawer.setFractal(fractal, discardZoom);
		drawer.drawFractal(fractal);
	}

	/**
	 * Sets appropriate parameters in drawer object and starts drawing
	 * of iterated fractal.
	 */
	public void drawIterated(){
		IFSFractalDrawer drawer = ifsTopLevelPanel.getIFSFractalDrawer();
		IFSFractal fractal = ifsTopLevelPanel.getIFSFractal();
		boolean iteratedMethod = ifsTopLevelPanel.getMethod();
		int numberOfPoints;
		try{
			numberOfPoints = ifsTopLevelPanel.getNumberOfPoints();
			resetProgressBar(numberOfPoints);
		}catch(NumberFormatException nfe){
			return;
		}
		drawer.drawFractal(fractal, iteratedMethod, numberOfPoints);
	}

	

	/**
	 * Sets the current value in progress bar
	 * @param value to set
	 */
	public void setProgress(final int value){
		SwingUtilities.invokeLater(new Runnable() {

			public void run(){
				progressBar.setValue(value);
			}

		});
	}

	/**
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar(){
		return progressBar;
	}

	/**
	 * @param progressBar
	 *        the progressBar to set
	 */
	public void setProgressBar(JProgressBar progressBar){
		this.progressBar = progressBar;
	}

	/**
	 * @param complexTopLevelPanel
	 *        the complexTopLevelPanel to set
	 */
	public void setComplexTopLevelPanel(ComplexTopLevelPanel complexTopLevelPanel){
		this.complexTopLevelPanel = complexTopLevelPanel;
	}

	/**
	 * @param ifsTopLevelPanel
	 *        the ifsTopLevelPanel to set
	 */
	public void setIfsTopLevelPanel(IFSTopLevelPanel ifsTopLevelPanel){
		this.ifsTopLevelPanel = ifsTopLevelPanel;
	}

	/**
	 * Sets string to display in status label
	 * @param text to display
	 */
	public void setStatusString(final String text){
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				statusLabel.setText(text);
			}
		});
	}

	/**
	 * Sets label object which is used to display status informations
	 * @param statusLabel
	 *        the statusLabel to set
	 */
	public void setStatusLabel(JLabel statusLabel){
		this.statusLabel = statusLabel;
	}

	/**
	 * Sets the aspect ratio to 1:1 which means that ranges along both
	 * axes are set to the same values which the larger one.
	 */
	public void complexFixAspectRatio(){
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		if(drawer.isRunning()){
			return;
		}
		drawer.fixAspectRatio();
		resetProgressBar();

//		drawer.setPreviewEnabled(complexTopLevelPanel.isPreviewEnabled());
		drawer.repaintFractal(false);
	}

	/**
	 * Repaints complex fractal with the same zoom level.
	 */
	public void repaintComplex(){
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		ComplexFractal fractal = complexTopLevelPanel.getComplexFractal();

		resetProgressBar();

		fractal.setPalette(complexTopLevelPanel.getPalette());
//		drawer.setPreviewEnabled(complexTopLevelPanel.isPreviewEnabled());
		drawer.repaintFractal(false);
	}

	private void resetProgressBar(int numberOfPoints){
		progressBar.setValue(0);
		progressBar.setMaximum(numberOfPoints);
	}
	
	private void resetProgressBar(){
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		progressBar.setValue(0);
		progressBar.setMaximum(drawer.getWidth() * drawer.getHeight());
	}


	/**
	 * Returns setting of preview property (preview checkbox is clicked or not).
	 * @return <code>true</code> if preview checkbox is clicked, <code>false</code> otherwise
	 */
	public boolean isPreviewEnabled(){
		return complexTopLevelPanel.isPreviewEnabled();
	}

	/**
	 * Stops ongoing draw operation for complex fractals
	 */
	public void stopDrawing(){
		complexTopLevelPanel.getComplexFractalDrawer().stopDrawing();
	}

	/**
	 * Stops ongoing draw operation for iterated fractals
	 */
	public void stopIterated(){
		ifsTopLevelPanel.getIFSFractalDrawer().stopDrawing();
	}
}
