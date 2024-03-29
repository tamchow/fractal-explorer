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
package pl.wojciechantosiewicz.fractals.gui.complex.convergent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.FractalDB;
import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.convergent.ConvergentFractal;
import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;
import pl.wojciechantosiewicz.fractals.complex.formula.PolynomialFormula;
import pl.wojciechantosiewicz.fractals.gui.complex.ComplexCommonOptionsPanel;
import pl.wojciechantosiewicz.fractals.gui.complex.FractalPaletteRenderer;
import pl.wojciechantosiewicz.fractals.palette.FractalPalette;
import pl.wojciechantosiewicz.fractals.palette.Palettes;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class ConvergentOptionsPanel extends ComplexCommonOptionsPanel {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------

	/**  */
	private static final long serialVersionUID = -233797060308181872L;

	// ~ Instance fields ----------------------------------------------------------------------------------------------

	private JComboBox convergentFractalComboBox = new JComboBox(FractalDB.convergentFractals);

	/** DOCUMENT ME! */
	protected JList rootsList = new JList(pointsListModel);

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new ConvergentOptionsPanel object.
	 * 
	 */
	public ConvergentOptionsPanel() {
		super();
		titledBorderPointsList = new TitledBorder(BorderFactory.createEtchedBorder(), "Function roots");
		titledBorderPointsList.setTitleJustification(TitledBorder.CENTER);
		titledBorderPointsList.setTitleColor(new Color(0, 0, 128));
		rootsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rootsList.setEnabled(false);
		pointListScrollPane.setBorder(titledBorderPointsList);
		pointListScrollPane.getViewport().add(rootsList, null);

		

		convergentFractalComboBox.setMinimumSize(new Dimension(150, 24));
		convergentFractalComboBox.setPreferredSize(new Dimension(160, 24));
		convergentFractalComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ConvergentFractal f = (ConvergentFractal)convergentFractalComboBox.getSelectedItem();
				setupFormulasForSelectedFractal(f);

				pointsListModel.clear();

				Complex[] roots = f.getFormula().getProperties().getPoints();

				for(int i = 0; i < roots.length; i++){
					pointsListModel.addElement(roots[i]);
				}
			}
		});

		this.add(convergentFractalComboBox, new GridBagConstraints(0, 1, 2, 1, 0.5, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(3, 3, 0, 3), 0, 0));

		paletteComboBox = new JComboBox(Palettes.getInstace().getPalettesConvergent().toArray());
		paletteComboBox.setRenderer(new FractalPaletteRenderer());
		paletteComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				palette = (FractalPalette)paletteComboBox.getSelectedItem();
			}
		});

		palettePanel.add(paletteComboBox, new GridBagConstraints(1, 0, 1, 1, 0.25, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 5, 0, 5), 0, 0));

		palette = (FractalPalette)paletteComboBox.getSelectedItem();
		setupFormulasForSelectedFractal((ConvergentFractal)convergentFractalComboBox.getSelectedItem());
	}

	/**
	 * @return
	 */
	@Override
	public ComplexFractal getFractal(){
		return (ComplexFractal)convergentFractalComboBox.getSelectedItem();
	}

	private void setupFormulasForSelectedFractal(ConvergentFractal f){
		formulaComboBox.removeAllItems();

		List<IComplexFormula> formulas = f.getFormulas();

		for(int i = 0; i < formulas.size(); i++){
			formulaComboBox.addItem(formulas.get(i));
		}
		formulaComboBox.repaint();
	}

	/*
	 * (non-Javadoc)
	 * @see fractals.swing.complex.ComplexOptionsPanel#setupPalettes(fractals.complex.Formula)
	 */
	@Override
	protected void setupPalettes(IComplexFormula formula){
		super.setupPalettes(formula);
		// System.out.println("Setting palettes for formula : "+formula);
		paletteComboBox.removeAllItems();

		// System.out.println("Available palettes: "+Arrays.toString(convergentPalettes));
		// System.out.println("Formula order = "+formula.getPolynomialOrder());
		for(FractalPalette convPalette : Palettes.getInstace().getPalettesConvergent()){
			int numberOfSegments = convPalette.getNumberOfSegments();
			// System.out.println("PaletteOrder = "+paletteOrder);
			if(numberOfSegments == ((PolynomialFormula)formula).getOrder()){
				// System.out.println("Palette and formulas order have matched, adding to paletteComboBox");
				paletteComboBox.addItem(convPalette);
			}else{
				// System.out.println("Palette not matched");
			}
		}
	}
}
