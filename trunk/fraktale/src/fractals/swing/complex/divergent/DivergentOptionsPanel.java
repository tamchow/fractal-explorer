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
package fractals.swing.complex.divergent;

import fractals.ExecutionControl;
import fractals.Fraktale;

import fractals.complex.Formula;

import fractals.complex.divergent.DivergentFractal;
import fractals.complex.divergent.Julia;

import fractals.palette.FractalPalette;
import fractals.palette.Palettes;

import fractals.swing.complex.ComplexOptionsPanel;
import fractals.swing.complex.FractalPaletteRenderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class DivergentOptionsPanel extends ComplexOptionsPanel {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    /**  */
    private static final long serialVersionUID = -3801498416393507812L;

    //~ Instance fields ----------------------------------------------------------------------------------------------

    private JComboBox divergentFractalComboBox = new JComboBox(Fraktale.divergentFractals);
//    private JComboBox complexFormulaComboBox = new JComboBox(
//            ((DivergentFractal)divergentFractalComboBox.getSelectedItem()).getFormulas().toArray());
    private JList startingPointsList = new JList(pointsListModel);
    private JComboBox paletteComboBox = new JComboBox(Palettes.getPalettesDivergent());

    //~ Constructors -------------------------------------------------------------------------------------------------

    /**
     * Creates a new DivergentOptionsPanel object.
     */
    public DivergentOptionsPanel(ExecutionControl executionControl) {
        super(executionControl);
        
        startingPointsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        startingPointsList.addMouseListener(
            new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        repaint_actionPerformed(true);
                    }
                }
            });

        titledBorderPointsList = new TitledBorder(BorderFactory.createEtchedBorder(), "Starting point");
        titledBorderPointsList.setTitleJustification(TitledBorder.CENTER);
        titledBorderPointsList.setTitleColor(new Color(0, 0, 128));
        pointListScrollPane.setBorder(titledBorderPointsList);
        pointListScrollPane.getViewport().add(startingPointsList, null);

        setupFormulasForSelectedFractal((DivergentFractal) divergentFractalComboBox.getSelectedItem());
        
        divergentFractalComboBox.setMinimumSize(new Dimension(150, 24));
        divergentFractalComboBox.setPreferredSize(new Dimension(160, 24));
        divergentFractalComboBox.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    DivergentFractal f = (DivergentFractal)divergentFractalComboBox.getSelectedItem();
                    setupFormulasForSelectedFractal(f);
                    pointsListModel.clear();

                    if (f instanceof Julia) {
                        pointListScrollPane.setEnabled(true);
                    } else {
                        pointListScrollPane.setEnabled(false);
                    }
                }
            });

        this.add(
            divergentFractalComboBox,
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
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param b DOCUMENT ME!
     */
    private void repaint_actionPerformed(boolean b) {
        // TODO Auto-generated method stub
    }
    
    public DivergentFractal getFractal(){
    	return (DivergentFractal) divergentFractalComboBox.getSelectedItem();
    }
    
    private void setupFormulasForSelectedFractal(DivergentFractal f){
    	formulaComboBox.removeAllItems();

        ArrayList<Formula> formulas = f.getFormulas();

        for (int i = 0; i < formulas.size(); i++) {
            formulaComboBox.addItem(formulas.get(i));
        }
        formulaComboBox.repaint();
    }
}
