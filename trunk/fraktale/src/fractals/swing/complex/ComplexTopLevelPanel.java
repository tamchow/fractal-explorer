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
import fractals.complex.ComplexFractal;
import fractals.complex.Formula;
import fractals.palette.FractalPalette;
import fractals.swing.complex.convergent.ConvergentOptionsPanel;
import fractals.swing.complex.divergent.DivergentOptionsPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
 */
public class ComplexTopLevelPanel extends JPanel {
    //~ Static fields/initializers -----------------------------------------------------------------------------------
private final String componentInfo = "ComplexTopLevelPanel";
    /**  */
    private static final long serialVersionUID = -5994742954662939120L;

    //~ Instance fields ----------------------------------------------------------------------------------------------
    private ExecutionControl executionControl = ExecutionControl.getInstance();
    private ComplexFractalDrawer complexFractalDrawer;
    private JTabbedPane complexFractalTypeTabbedPane = new JTabbedPane();
    private DivergentOptionsPanel divergentOptionsPanel = new DivergentOptionsPanel(executionControl);
    private ConvergentOptionsPanel convergentOptionsPanel = new ConvergentOptionsPanel(executionControl);
    //~ Constructors -------------------------------------------------------------------------------------------------

    /**
     * Creates a new ComplexTopLevelPanel object.
     *
     * @param applet DOCUMENT ME!
     */
    public ComplexTopLevelPanel() {
        super();
        
        this.setToolTipText(componentInfo);
        complexFractalDrawer = new ComplexFractalDrawer();
        this.setLayout(new GridBagLayout());

        complexFractalTypeTabbedPane.addTab("Divrgent", divergentOptionsPanel);
        complexFractalTypeTabbedPane.addTab("Convergent", convergentOptionsPanel);

        this.add(
            complexFractalDrawer,
            new GridBagConstraints(
                0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                0));
        this.add(
            complexFractalTypeTabbedPane,
            new GridBagConstraints(
                1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.VERTICAL,
                new Insets(0, 3, 0, 3), 0, 0));
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * @return the complexFractalDrawer
	 */
	public ComplexFractalDrawer getComplexFractalDrawer() {
		return complexFractalDrawer;
	}
	
	public ComplexFractal getComplexFractal(){
		if(complexFractalTypeTabbedPane.getSelectedIndex()==0){// divergent
			return divergentOptionsPanel.getFractal();
		}else if(complexFractalTypeTabbedPane.getSelectedIndex()==1){ // convergent
			return convergentOptionsPanel.getFractal();
		}
		else{
			return null;
		}
	}
	
	public FractalPalette getPalette(){
		if(complexFractalTypeTabbedPane.getSelectedIndex()==0){// divergent
			return divergentOptionsPanel.getPalette();
		}else if(complexFractalTypeTabbedPane.getSelectedIndex()==1){ // convergent
			return convergentOptionsPanel.getPalette();
		}
		else{
			return null;
		}
	}

	public boolean isFractalSet() {
		return complexFractalDrawer.isFractalSet();
	}
	
	public boolean isPreviewEnabled(){
		if(complexFractalTypeTabbedPane.getSelectedIndex()==0){// divergent
			return divergentOptionsPanel.isPreviewEnabled();
		}else if(complexFractalTypeTabbedPane.getSelectedIndex()==1){ // convergent
			return convergentOptionsPanel.isPreviewEnabled();
		}else{
			return true;
		}
	}

	public Formula getFormula() {
		if(complexFractalTypeTabbedPane.getSelectedIndex()==0){// divergent
			return divergentOptionsPanel.getFormula();
		}else if(complexFractalTypeTabbedPane.getSelectedIndex()==1){ // convergent
			return convergentOptionsPanel.getFormula();
		}else{
			return null;
		}
	}
}
