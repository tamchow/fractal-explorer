/**
 * 
 */
package fractals;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import fractals.complex.ComplexFractal;
import fractals.ifs.IFSFractal;
import fractals.swing.complex.ComplexFractalDrawer;
import fractals.swing.complex.ComplexTopLevelPanel;
import fractals.swing.ifs.IFSFractalDrawer;
import fractals.swing.ifs.IFSTopLevelPanel;

/**
 * @author wa
 * 
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
	
	public static ExecutionControl getInstance(){
		return INSTANCE;
	}

	public void drawComplex(boolean discardZoom) {
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		ComplexFractal fractal = complexTopLevelPanel.getComplexFractal();
		progressBar.setValue(0);
		progressBar.setMaximum(drawer.getWidth() * drawer.getHeight());
		
		fractal.setPalette(complexTopLevelPanel.getPalette());
		drawer.drawFractal(fractal, discardZoom);
	}

	public void drawIterated() {
		IFSFractalDrawer drawer = ifsTopLevelPanel.getIFSFractalDrawer();
		IFSFractal fractal = ifsTopLevelPanel.getIFSFractal();
		boolean iteratedMethod = ifsTopLevelPanel.getMethod();
		int numberOfPoints;
		try {
			numberOfPoints = ifsTopLevelPanel.getNumberOfPoints();
			progressBar.setValue(0);
			progressBar.setMaximum(numberOfPoints);
		} catch (NumberFormatException nfe) {
			return;
		}
		drawer.drawFractal(fractal, iteratedMethod, numberOfPoints);
	}

	public void setProgress(final int value) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				progressBar.setValue(value);
			}

		});

	}

	/**
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * @param progressBar
	 *            the progressBar to set
	 */
	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	/**
	 * @param complexTopLevelPanel
	 *            the complexTopLevelPanel to set
	 */
	public void setComplexTopLevelPanel(
			ComplexTopLevelPanel complexTopLevelPanel) {
		this.complexTopLevelPanel = complexTopLevelPanel;
	}

	/**
	 * @param ifsTopLevelPanel
	 *            the ifsTopLevelPanel to set
	 */
	public void setIfsTopLevelPanel(IFSTopLevelPanel ifsTopLevelPanel) {
		this.ifsTopLevelPanel = ifsTopLevelPanel;
	}

	public void setStatusString(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				statusLabel.setText(text);
			}
		});
	}

	/**
	 * @param statusLabel
	 *            the statusLabel to set
	 */
	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}

	public void fixAspectRatio() {
		ComplexFractalDrawer drawer = complexTopLevelPanel.getComplexFractalDrawer();
		if (drawer.isRunning()) {
			return;
		} else {
			drawer.fixAspectRatio();
			drawComplex(false);
		}
		
	}
}
