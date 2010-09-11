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
package pl.wojciechantosiewicz.fractals.gui.complex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.ExecutionControl;
import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;
import pl.wojciechantosiewicz.fractals.palette.FractalPalette;
import pl.wojciechantosiewicz.fractals.palette.Palettes;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public abstract class ComplexCommonOptionsPanel extends JPanel {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------

	private final String componentInfo = "ComplexOptionsPanel";

	/**  */
	private static final long serialVersionUID = 8567525929681590084L;

	// ~ Instance fields ----------------------------------------------------------------------------------------------

	/** DOCUMENT ME! */
	protected GridBagLayout gridBagLayout = new GridBagLayout();

	/** DOCUMENT ME! */
	protected JLabel fractalLabel = new JLabel();

	/** DOCUMENT ME! */
	protected JButton repaintButton = new JButton();

	/** DOCUMENT ME! */
	protected JLabel formulaLabel = new JLabel();

	/** DOCUMENT ME! */
	protected DefaultListModel pointsListModel = new DefaultListModel();

	/** DOCUMENT ME! */
	protected JScrollPane pointListScrollPane = new JScrollPane();

	/** DOCUMENT ME! */
	protected TitledBorder titledBorderPointsList;

	/** DOCUMENT ME! */
	protected TitledBorder paletteTitledBorder;

	/** DOCUMENT ME! */
	protected JPanel palettePanel = new JPanel();

	/** DOCUMENT ME! */
	protected GridBagLayout gridBagLayout3 = new GridBagLayout();

	/** DOCUMENT ME! */
	protected JButton aspectRatioButton = new JButton();

	/** DOCUMENT ME! */
	protected FractalPalette palette;

	protected DefaultComboBoxModel formulaComboBoxModel = new DefaultComboBoxModel();

	protected JComboBox formulaComboBox = new JComboBox(formulaComboBoxModel);

	protected JComboBox paletteComboBox;
	
	protected ExecutionControl executionControl;

	protected JCheckBox previewCheckBox = new JCheckBox();

	protected JButton drawButton = new JButton();

	protected JButton stopButton = new JButton();

	/**
	 * Creates a new ComplexOptionsPanel object.
	 */
	public ComplexCommonOptionsPanel() {
		super();
		this.executionControl = ExecutionControl.getInstance();
		this.setToolTipText(componentInfo);
		this.setBorder(null);
		palette = Palettes.getPalettesConvergent().get(0);
		setLayout(gridBagLayout);

		fractalLabel.setForeground(new Color(0, 0, 128));
		fractalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fractalLabel.setText("Fractal");
		this.add(fractalLabel, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
				2, 5, 3, 5), 0, 0));

		repaintButton.setText("Repaint");
		repaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				repaint_actionPerformed(false);
			}
		});
		repaintButton.setEnabled(false);
		this.add(repaintButton, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
				5, 5, 5, 15), 0, 0));

		formulaLabel.setForeground(new Color(0, 0, 128));
		formulaLabel.setText("Formula");

		this.add(formulaLabel, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
				0, 0, 0, 0), 0, 0));

		formulaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// if (e.getSource() == formulaComboBox) {
				IComplexFormula formula = (IComplexFormula)formulaComboBox.getSelectedItem();

				if(formula == null){
					return;
				}

				setupPointListAndPalettes(formula);
				// }
			}
		});

		this.add(formulaComboBox, new GridBagConstraints(0, 3, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 3, 0, 3), 0, 0));

		pointListScrollPane.setEnabled(false);

		paletteTitledBorder = new TitledBorder(BorderFactory.createEtchedBorder(), "Color palette");

		paletteTitledBorder.setTitleJustification(TitledBorder.CENTER);
		paletteTitledBorder.setTitleColor(new Color(0, 0, 128));

		this.add(pointListScrollPane, new GridBagConstraints(0, 4, 3, 1, 1.0, 0.4, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 3, 0, 3), 0, 0));

		aspectRatioButton.setPreferredSize(new Dimension(100, 25));
		aspectRatioButton.setMinimumSize(new Dimension(80, 25));
		aspectRatioButton.setMaximumSize(new Dimension(120, 25));
		aspectRatioButton.setText("1:1 ratio");
		aspectRatioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				aspectRatioButton_actionPerformed(e);
			}
		});

		aspectRatioButton.setEnabled(false);

		this.add(aspectRatioButton, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 15, 0, 10), 0, 0));
		palettePanel.setLayout(gridBagLayout3);
		palettePanel.setBorder(paletteTitledBorder);
		this.add(palettePanel, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(3, 3, 3, 3), 0, 0));

		previewCheckBox.setText("Preview");

		this.add(previewCheckBox, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(3, 5, 3, 5), 0, 0));

		drawButton.setText("Draw");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				drawButton_actionPerformed();
			}
		});

		this.add(drawButton, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3,
				5, 3, 5), 0, 0));

		stopButton.setText("Stop");
		stopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0){
				stopButton_actionPerformed();
			}
		});

		this.add(stopButton, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3,
				5, 3, 5), 0, 0));
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	public abstract ComplexFractal getFractal();
	
	protected void stopButton_actionPerformed(){
		ExecutionControl.getInstance().stopDrawing();

	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param b
	 *        DOCUMENT ME!
	 */
	private void repaint_actionPerformed(boolean b){
		executionControl.repaintComplex();
	}

	/**
	 * Action performed after click on the aspect ration button
	 * @param e generated event
	 */
	private void aspectRatioButton_actionPerformed(ActionEvent e){
		executionControl.complexFixAspectRatio();
	}

	/**
	 * Currently selected palette of colors
	 * @return selected palette
	 */
	public FractalPalette getPalette(){
		return palette;
	}

	/**
	 * Checks whether preview checkbox is selected
	 * @return <code>true</code> is checkbox is selected, <code>false</code> otherwise 
	 */
	public boolean isPreviewEnabled(){
		return previewCheckBox.isSelected();
	}

	private void drawButton_actionPerformed(){
		executionControl.drawComplex(true);
		repaintButton.setEnabled(true);
		aspectRatioButton.setEnabled(true);

	}

	/**
	 * Returns formula selected in combobox
	 * @return currently selected formula
	 */
	public IComplexFormula getFormula(){
		return (IComplexFormula)formulaComboBox.getSelectedItem();
	}

	protected void setupPointListAndPalettes(IComplexFormula formula){
		pointsListModel.clear();
		Complex[] points = formula.getProperties().getPoints(); 
		if(points == null){
			return;
		}

		for(Complex point : points){
			pointsListModel.addElement(point);
		}
		formula.setConstant(points[0]);
		setupPalettes(formula);
	}

	/**
	 * Setup palettes for newly selected formula
	 * @param formula selected formula
	 */
	protected void setupPalettes(IComplexFormula formula){
		// default implementation does nothing
	}
}
