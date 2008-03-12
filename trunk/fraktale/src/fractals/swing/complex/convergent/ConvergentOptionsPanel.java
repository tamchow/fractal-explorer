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
package fractals.swing.complex.convergent;

import fractals.ExecutionControl;
import fractals.Fraktale;

import fractals.complex.Formula;
import fractals.complex.convergent.ConvergentFractal;

import fractals.palette.FractalPalette;
import fractals.palette.Palettes;

import fractals.swing.complex.ComplexOptionsPanel;
import fractals.swing.complex.FractalPaletteRenderer;

import org.jscience.mathematics.numbers.Complex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
 */
public class ConvergentOptionsPanel extends ComplexOptionsPanel {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    /**  */
    private static final long serialVersionUID = -233797060308181872L;

    //~ Instance fields ----------------------------------------------------------------------------------------------

    private JComboBox convergentFractalComboBox = new JComboBox(Fraktale.convergentFractals);

    /** DOCUMENT ME! */
    protected JList rootsList = new JList(pointsListModel);
    private JComboBox paletteComboBox = new JComboBox(Palettes.getPalettesConvergent());

    //~ Constructors -------------------------------------------------------------------------------------------------

    /**
     * Creates a new ConvergentOptionsPanel object.
     */
    public ConvergentOptionsPanel(ExecutionControl executionControl) {
        super(executionControl);
        titledBorderPointsList = new TitledBorder(BorderFactory.createEtchedBorder(), "Function roots");
        titledBorderPointsList.setTitleJustification(TitledBorder.CENTER);
        titledBorderPointsList.setTitleColor(new Color(0, 0, 128));
        rootsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rootsList.setEnabled(false);
        pointListScrollPane.setBorder(titledBorderPointsList);
        pointListScrollPane.getViewport().add(rootsList, null);

        setupFormulasForSelectedFractal((ConvergentFractal) convergentFractalComboBox.getSelectedItem());
        
        convergentFractalComboBox.setMinimumSize(new Dimension(150, 24));
        convergentFractalComboBox.setPreferredSize(new Dimension(160, 24));
        convergentFractalComboBox.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	ConvergentFractal f = (ConvergentFractal)convergentFractalComboBox.getSelectedItem();
                	setupFormulasForSelectedFractal(f);
                    
                    pointsListModel.clear();

                    Complex[] roots = f.gerRoots();

                    for (int i = 0; i < roots.length; i++) {
                        pointsListModel.addElement(roots[i]);
                    }
                }
            });

        this.add(
            convergentFractalComboBox,
            new GridBagConstraints(
                0, 1, 2, 1, 0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                    3, 3, 0, 3), 0, 0));
   
        paletteComboBox.setRenderer(new FractalPaletteRenderer());
        paletteComboBox.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    palette = (FractalPalette)paletteComboBox.getSelectedItem();
                }
            });

        palettePanel.add(
            paletteComboBox,
            new GridBagConstraints(
                1, 0, 1, 1, 0.25, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0,
                0));
        
        palette = (FractalPalette) paletteComboBox.getSelectedItem();
    }
    
    public ConvergentFractal getFractal(){
    	return (ConvergentFractal)convergentFractalComboBox.getSelectedItem();
    }
    
    private void setupFormulasForSelectedFractal(ConvergentFractal f){
        formulaComboBox.removeAllItems();

        ArrayList<Formula> formulas = f.getFormulas();

        for (int i = 0; i < formulas.size(); i++) {
            formulaComboBox.addItem(formulas.get(i));
        }
        formulaComboBox.repaint();
    }
}
