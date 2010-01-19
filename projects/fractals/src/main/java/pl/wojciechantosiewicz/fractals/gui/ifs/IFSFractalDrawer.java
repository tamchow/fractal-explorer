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
package pl.wojciechantosiewicz.fractals.gui.ifs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import pl.wojciechantosiewicz.fractals.ExecutionControl;
import pl.wojciechantosiewicz.fractals.ifs.AffineTransform;
import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;
import pl.wojciechantosiewicz.image.CoordinateTransform;
import pl.wojciechantosiewicz.image.CoordinateTransform3D;
import pl.wojciechantosiewicz.image.ImageUtil;
import pl.wojciechantosiewicz.image.ScreenPoint;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
 */
/**
 * @author wa
 *
 */
public class IFSFractalDrawer extends JPanel {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    private static final long serialVersionUID = 3263803240174975718L;

    //~ Instance fields ----------------------------------------------------------------------------------------------

    private Thread thread;
    //private FraktalApplet applet;
    private Random r = new Random();
    private BufferedImage bi = new BufferedImage(5, 5, BufferedImage.TYPE_INT_RGB);
    private boolean running = false;
    private float x;
    private float y;
    private float xp;
    private CoordinateTransform ct = new CoordinateTransform3D(getWidth() - 1, getHeight() - 1, -1.0, 1.0, -1.0, 1.0);
    private ExecutionControl executionControl = ExecutionControl.getInstance();
    
    //~ Constructors -------------------------------------------------------------------------------------------------

    public IFSFractalDrawer(){
    	super();
    	this.addComponentListener(
                new ComponentAdapter() {
                    public void componentResized(ComponentEvent e) {
                        ct.setScreenDimensions(
                            IFSFractalDrawer.this.getWidth() - 1, IFSFractalDrawer.this.getHeight() - 1);
                        bi = new BufferedImage(
                                IFSFractalDrawer.this.getWidth(), IFSFractalDrawer.this.getHeight(),
                                BufferedImage.TYPE_INT_RGB);
                    }
                });
    }
    

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param fractal DOCUMENT ME!
     * @param lP DOCUMENT ME!
     */
    private void recurrentDraw(IFSFractal fractal, int lP) {
        int j = 0;
        int p;
        this.clearPanel();

        x = 0;
        y = 0;
        AffineTransform[] transformations = fractal.getTransformations();
        while (j++ < 100) {
            p = Math.abs(r.nextInt()) % fractal.getTransformCount();
            xp = transformations[p].transformX(x, y);
            y = transformations[p].transformY(x, y);
            x = xp;
        }

        thread = new RecurrentDrawThread(fractal, lP);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param fractal DOCUMENT ME!
     * @param lP DOCUMENT ME!
     */
    private void normalDraw(IFSFractal fractal, int lP) {
        int j = 0;
        int p = 0;
        this.clearPanel();
        
        x = 0;
        y = 0;

        AffineTransform[] transformations = fractal.getTransformations();
        while (j++ < 100) { //zbliz sie do atraktora
            p = Math.abs(r.nextInt()) % fractal.getTransformCount();
            xp = transformations[p].transformX(x, y);
            y = transformations[p].transformY(x, y);
            x = xp;
        }

        thread = new NormalDrawThread(fractal, lP);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param fractals DOCUMENT ME!
     * @param lP DOCUMENT ME!
     * @param frames DOCUMENT ME!
     */
    public void animate(IFSFractal[] fractals, int lP, int frames) {
        this.clearPanel();
        running = false;

        x = 0;
        y = 0;

        AffineTransform[] transformations = fractals[0].getTransformations();
        
        r.setSeed(System.currentTimeMillis());
        
        for(int j=0; j < 100; j++) { //zbliz sie do atraktora
            int p = r.nextInt(fractals[0].getTransformCount());
            xp = transformations[p].transformX(x, y);
            y = transformations[p].transformY(x, y);
            x = xp;
        }

        thread = new NormalAnimateThread(fractals, lP, frames);
    }


    //******************************************************************************
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


    //******************************************************************************
    /**
     * DOCUMENT ME!
     */
    public void clearPanel() {
        if (running) {
            stopDrawing();
        }

        bi.createGraphics().clearRect(0, 0, bi.getWidth(), bi.getHeight());
        //this.getGraphics().clearRect(0,0,getWidth(),getHeight());
        repaint();
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, this);
    }

    //~ Inner Classes ------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @version $Revision: 000 $
     */
    private class RecurrentDrawThread extends Thread {
        //~ Instance fields ------------------------------------------------------------------------------------------

        private IFSFractal fractal;
        private final int MAX_REC_LEVEL = 128;
        private int numberOfPoints;
        private int counter;

        //~ Constructors ---------------------------------------------------------------------------------------------

        /**
         * Creates a new RecurrentDrawThread object.
         *
         * @param fractal DOCUMENT ME!
         * @param lP DOCUMENT ME!
         */
        RecurrentDrawThread(IFSFractal fractal, int numberOfPoints) {
            this.fractal = fractal;
            this.numberOfPoints = numberOfPoints;
            running = true;
            this.start();
        }

        //~ Methods --------------------------------------------------------------------------------------------------

        /**
         * DOCUMENT ME!
         */
        public void run() {
            counter = 0;

            while (running && recurentFraktal(0, x, y)) {
                
            	executionControl.setProgress(counter);
            	
                IFSFractalDrawer.this.repaint();

//                try {
//                    sleep(20);
//                } catch (InterruptedException ex) {
//                }
            }
            IFSFractalDrawer.this.repaint();
            running = false;
        }


        //******************************************************************************
        /**
         * DOCUMENT ME!
         *
         * @param recLevel DOCUMENT ME!
         * @param x DOCUMENT ME!
         * @param y DOCUMENT ME!
         *
         * @return DOCUMENT ME!
         */
        private boolean recurentFraktal(int recLevel, float x, float y) {
            float nx;
            float ny;

            if (running == false) {
                return false;
            }

            if (recLevel >= MAX_REC_LEVEL) {
                return false;
            }

            if (counter > numberOfPoints) {
                return false;
            }

            for (int k = 0; k < fractal.getTransformCount(); k++) {
                nx = fractal.getTransformations()[k].transformX(x, y);
                ny = fractal.getTransformations()[k].transformY(x, y);
                counter++;


                try {
                	ScreenPoint p = ct.userToScreen(nx, ny);
                	bi.setRGB(p.x, p.y, ImageUtil.validRGB((int)(255 - (255 * nx)), (int)(255 * ny), 100));
                 } catch (ArrayIndexOutOfBoundsException fioehj) {
                 }
                    
                 if(counter % 1000 == 0){
//                    	 applet.setProgress(counter);
                   	executionControl.setProgress(counter);
                   	repaint();
                 }


                if (recurentFraktal(recLevel + 1, nx, ny) == true) {
                    return true;
                }
            }

            return false;
        } //recurentFraktal
    } //Rekurencja
      //##############################################################################

    /**
     * DOCUMENT ME!
     *
     * @version $Revision: 000 $
     */
    private class NormalDrawThread extends Thread {
        //~ Instance fields ------------------------------------------------------------------------------------------

        private IFSFractal fractal;
        private int numberOfPoints;
        private int counter;

        //~ Constructors ---------------------------------------------------------------------------------------------

        /**
         * Creates a new NormalDrawThread object.
         *
         * @param fractal DOCUMENT ME!
         * @param lP DOCUMENT ME!
         */
        NormalDrawThread(IFSFractal fractal, int lP) {
            this.fractal = fractal;
            numberOfPoints = lP;
            running = true;
            this.start();
        }

        //~ Methods --------------------------------------------------------------------------------------------------

        /**
         * DOCUMENT ME!
         */
        public void run() {
            int p;
            counter = 0;

            while ((counter++ < numberOfPoints) && running) {
                if (this == Thread.currentThread()) {
                    p = Math.abs(r.nextInt()) % fractal.getTransformCount();
                    xp = fractal.getTransformations()[p].transformX(x, y);
                    y = fractal.getTransformations()[p].transformY(x, y);
                    x = xp;

                    synchronized (this) {
                        try {
                            ScreenPoint point = ct.userToScreen(x, y);
                            bi.setRGB(point.x, point.y, ImageUtil.validRGB((int)(127 * x - 127*y), (int)(255 - 255*y),(int)(255 - 127*x + 127*y)));
                            /*bi.setRGB(
                                point.x, point.y, ImageUtil.validRGB((int)(255 - (255 * x)), (int)(255 * y), 100));*/
                        } catch (ArrayIndexOutOfBoundsException ivno) {
                        }

//                      applet.setProgress(counter);
                    	executionControl.setProgress(counter);
                        

                        if ((counter & 100) == 0) {
                            repaint();
                        }
                    }
                }
            }
        }
    }

    //##############################################################################
    /**
     * DOCUMENT ME!
     *
     * @version $Revision: 000 $
     */
    private class NormalAnimateThread extends Thread {
        //~ Instance fields ------------------------------------------------------------------------------------------

        private int numberOfPoints;
        private int counter;

        /** DOCUMENT ME! */
        int numberOfFrames;

        /** DOCUMENT ME! */
        float[][] increments;

        /** DOCUMENT ME! */
        AffineTransform[] transformations;

        /** DOCUMENT ME! */
        IFSFractal[] fractals;

        /** DOCUMENT ME! */
        IFSFractal actual;

        /** DOCUMENT ME! */
        int nextIndex = 1;

        //~ Constructors ---------------------------------------------------------------------------------------------

        /**
         * Creates a new ZwyklaAnimacja object.
         *
         * @param fractals DOCUMENT ME!
         * @param lP DOCUMENT ME!
         * @param frames DOCUMENT ME!
         */
        NormalAnimateThread(IFSFractal[] fractals, int lP, int frames) {
            numberOfPoints = lP;
            actual = fractals[0];
            this.fractals = fractals;
            numberOfFrames = frames;
            transformations = new AffineTransform[actual.getTransformCount()];

            for (int j = 0; j < actual.getTransformCount(); j++) {
                transformations[j] = new AffineTransform(actual.getTransformations()[j]);
            }

            increments = new float[actual.getTransformCount()][6];

            try {
                generateIncrements(actual, fractals[nextIndex], numberOfFrames);
            } catch (IllegalArgumentException gh) {
                return;
            }

            running = true;
            this.start();
        }

        //~ Methods --------------------------------------------------------------------------------------------------

        /**
         * DOCUMENT ME!
         *
         * @param startFractal DOCUMENT ME!
         * @param endFractal DOCUMENT ME!
         * @param steps DOCUMENT ME!
         *
         * @throws IllegalArgumentException DOCUMENT ME!
         */
        private void generateIncrements(IFSFractal startFractal, IFSFractal endFractal, int steps)
            throws IllegalArgumentException {
            if (startFractal.getTransformCount() != endFractal.getTransformCount()) {
                throw new IllegalArgumentException(
                    "Fractals have different number of transformations. " + startFractal + " : "
                    + startFractal.getTransformCount() + ", " + endFractal + " : "
                    + endFractal.getTransformCount());
            }
            AffineTransform[] startTransformations = startFractal.getTransformations();
            AffineTransform[] endTransformations = endFractal.getTransformations();
            for (int j = 0; j < startFractal.getTransformCount(); j++) {
                increments[j][0] = (float)((endTransformations[j].getA() - startTransformations[j].getA()) / (float)steps);
                increments[j][1] = (float)((endTransformations[j].getB() - startTransformations[j].getB()) / (float)steps);
                increments[j][2] = (float)((endTransformations[j].getC() - startTransformations[j].getC()) / (float)steps);
                increments[j][3] = (float)((endTransformations[j].getD() - startTransformations[j].getD()) / (float)steps);
                increments[j][4] = (float)((endTransformations[j].getE() - startTransformations[j].getE()) / (float)steps);
                increments[j][5] = (float)((endTransformations[j].getF() - startTransformations[j].getF()) / (float)steps);
            }
        }


        //******************************************************************************
        /**
         * DOCUMENT ME!
         */
        public void run() {
            int p;
            int color;
            int frameNumber = 0;

            while (running) {
                bi.createGraphics().clearRect(0, 0, bi.getWidth(), bi.getHeight());

                for (counter = 0; (counter++ < numberOfPoints) && (running == true); counter++) {
                    if (this == Thread.currentThread()) {
                        p = r.nextInt(transformations.length);
                        xp = transformations[p].transformX(x, y);
                        y = transformations[p].transformY(x, y);
                        x = xp;

                        synchronized (this) {
                            try {
                                ScreenPoint point = ct.userToScreen(x, y);

                                //bi.setRGB(point.x,point.y,ImageUtil.validRGB((int)(255-255*x),(int)(255*y),100));
                                switch (p) {
                                    case 0:
                                        color = Color.red.getRGB();

                                        break;

                                    case 1:
                                        color = Color.green.getRGB();

                                        break;

                                    case 2:
                                        color = Color.blue.getRGB();

                                        break;

                                    case 3:
                                        color = Color.cyan.getRGB();

                                        break;

                                    case 4:
                                        color = Color.magenta.getRGB();

                                        break;

                                    case 5:
                                        color = Color.yellow.getRGB();

                                        break;

                                    default:
                                        color = Color.white.getRGB();

                                        break;
                                }

                                bi.setRGB(point.x, point.y, color);
                            } catch (ArrayIndexOutOfBoundsException ivno) {
                            }
                        } //synchronized
                    } //if(Thread
                } //for

                repaint();

                try {
                    sleep(50);
                } catch (InterruptedException fh) {
                    running = false;
                }

                if (frameNumber++ == numberOfFrames) {
                    actual = fractals[nextIndex];

                    nextIndex++;
                    
                    if (nextIndex == fractals.length) {
                        running = false;

                        break;
                    }

                    for (int j = 0; j < actual.getTransformCount(); j++) {
                    	transformations[j].setCoefficients(actual.getTransformations()[j]);
                    }

                    generateIncrements(actual, fractals[nextIndex], numberOfFrames);
                    frameNumber = 0;

                    try {
                        sleep(1500);
                    } catch (InterruptedException fh) {
                        running = false;
                    }
                }

                if (frameNumber >= 0) {
                    for (int j = 0; j < increments.length; j++) {
                    	AffineTransform at = transformations[j];
                        at.setA(at.getA() + increments[j][0]);
                        at.setB(at.getB() + increments[j][1]);
                        at.setC(at.getC() + increments[j][2]);
                        at.setD(at.getD() + increments[j][3]);
                        at.setE(at.getE() + increments[j][4]);
                        at.setF(at.getF() + increments[j][5]);
                    }
                }
            } //while
        } //run
    } //ZwyklaAnimacja

    
	public void drawFractal(IFSFractal fractal, boolean method, int numberOfPoints) {
		if(method){
			normalDraw(fractal, numberOfPoints);
		}else{
			recurrentDraw(fractal, numberOfPoints);
		}
		
	}
}
