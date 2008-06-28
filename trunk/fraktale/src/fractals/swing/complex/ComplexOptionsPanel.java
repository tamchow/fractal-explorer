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
package fractals.swing.complex;

import fractals.ExecutionControl;
import fractals.complex.Formula;
import fractals.palette.FractalPalette;
import fractals.palette.Palettes;

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


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class ComplexOptionsPanel extends JPanel {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

	private final String componentInfo = "ComplexOptionsPanel";
	
    /**  */
    private static final long serialVersionUID = 8567525929681590084L;

    //~ Instance fields ----------------------------------------------------------------------------------------------

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
    
    protected DefaultComboBoxModel fractalComboBoxModel = new DefaultComboBoxModel();
    
    protected JComboBox complexFractalComboBox = new JComboBox(fractalComboBoxModel);
    
    protected ExecutionControl executionControl;

    protected JCheckBox previewCheckBox = new JCheckBox();
    
    protected JButton drawButton = new JButton();
    
    protected JButton stopButton = new JButton();
    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new ComplexOptionsPanel object.
     */
    public ComplexOptionsPanel(ExecutionControl executionControl) {
        super();
        this.executionControl = executionControl;
        this.setToolTipText(componentInfo);
        this.setBorder(null);
        palette = Palettes.getPaletteDivergent(0);
        setLayout(gridBagLayout);

        fractalLabel.setForeground(new Color(0, 0, 128));
        fractalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fractalLabel.setText("Fractal");
        this.add(
            fractalLabel,
            new GridBagConstraints(
                0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 5, 3, 5), 0, 0));

        repaintButton.setText("Repaint");
        repaintButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint_actionPerformed(false);
                }
            });
        repaintButton.setEnabled(false);
        this.add(
            repaintButton,
            new GridBagConstraints(
                1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 15), 0, 0));
        
        formulaLabel.setForeground(new Color(0, 0, 128));
        formulaLabel.setText("Formula");

        this.add(
            formulaLabel,
            new GridBagConstraints(
                0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        formulaComboBox.addActionListener(
        		new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if (e.getSource() == formulaComboBox) {
                            Formula formula = (Formula)formulaComboBox.getSelectedItem();

                            if (formula == null) {
                                return;
                            }
                            
                            setupPointList(formula);
                        //}
                    }
                });
        
        this.add(
                formulaComboBox,
                new GridBagConstraints(
                    0, 3, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                        0, 3, 0, 3), 0, 0));
        
        pointListScrollPane.setEnabled(false);

        paletteTitledBorder = new TitledBorder(BorderFactory.createEtchedBorder(), "Color palette");

        paletteTitledBorder.setTitleJustification(TitledBorder.CENTER);
        paletteTitledBorder.setTitleColor(new Color(0, 0, 128));

        this.add(
            pointListScrollPane,
            new GridBagConstraints(
                0, 4, 3, 1, 1.0, 0.4, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 3), 0, 0));
        
        aspectRatioButton.setPreferredSize(new Dimension(100, 25));
        aspectRatioButton.setMinimumSize(new Dimension(80, 25));
        aspectRatioButton.setMaximumSize(new Dimension(120, 25));
        aspectRatioButton.setText("1:1 ratio");
        aspectRatioButton.addActionListener(
        	new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			aspectRatioButton_actionPerformed(e);
        		}
        	});
        
        aspectRatioButton.setEnabled(false);
        
        this.add(
            aspectRatioButton,
            new GridBagConstraints(
                0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 15, 0, 10), 0,
                0));
        palettePanel.setLayout(gridBagLayout3);
        palettePanel.setBorder(paletteTitledBorder);
        this.add(
                palettePanel,
                new GridBagConstraints(
                    0, 5, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                        3, 3, 3, 3), 0, 0));
        
        previewCheckBox.setText("Preview");
        
        this.add(previewCheckBox,
        		new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3, 5, 3, 5), 0, 0));
        
        drawButton.setText("Draw");
        drawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawButton_actionPerformed();
			}
        });
        
        this.add(drawButton,
        		new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3, 5, 3, 5), 0, 0));
        
        stopButton.setText("Stop");
        stopButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				stopButton_actionPerformed();
			}
        });
        
        this.add(stopButton,
        		new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3, 5, 3, 5), 0, 0));
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    protected void stopButton_actionPerformed() {
    	ExecutionControl.getInstance().stopDrawing();
	
}

	/**
     * DOCUMENT ME!
     *
     * @param b DOCUMENT ME!
     */
    private void repaint_actionPerformed(boolean b) {
        executionControl.repaintComplex();
    }
    
    private void aspectRatioButton_actionPerformed(ActionEvent e) {
    	executionControl.complexFixAspectRatio();		
	}

	/**
	 * @return the palette
	 */
	public FractalPalette getPalette() {
		return palette;
	}
	
	public boolean isPreviewEnabled(){
		return previewCheckBox.isSelected();
	}
    
	private void drawButton_actionPerformed() {
		executionControl.drawComplex(true);
		repaintButton.setEnabled(true);
		aspectRatioButton.setEnabled(true);
		
	}
	
	public Formula getFormula(){
		return (Formula) formulaComboBox.getSelectedItem();
	}
	
	protected void setupPointList(Formula formula){
		pointsListModel.clear();

        if (formula.getPoints() == null) {
            return;
        }

        for (int i = 0; i < formula.getPoints().length; i++) {
            pointsListModel.addElement(formula.getPoints()[i]);
        }
        formula.setConstans(formula.getPoints()[0]);
	}
}
