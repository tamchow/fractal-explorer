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
package fractals.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fractals.ExecutionControl;
import fractals.swing.complex.ComplexTopLevelPanel;
import fractals.swing.ifs.IFSTopLevelPanel;

/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class FraktalApplet extends JApplet {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    private static final long serialVersionUID = 7617147846823557416L;

    //~ Instance fields ----------------------------------------------------------------------------------------------

    /** DOCUMENT ME! */
    private JPanel topLevelPanel = new JPanel();
    /** DOCUMENT ME! */
    private ExecutionControl executionControl = ExecutionControl.getInstance();
    /** DOCUMENT ME! */
    private JTabbedPane mainTabbedPane = new JTabbedPane();
    /** DOCUMENT ME! */
    private ComplexTopLevelPanel complexTopLevelPanel = new ComplexTopLevelPanel();
    /** DOCUMENT ME! */
    private IFSTopLevelPanel iteratedTopLevelPanel = new IFSTopLevelPanel();
    /** DOCUMENT ME! */
    private JProgressBar progressBar = new JProgressBar();
    /** DOCUMENT ME! */
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    /** DOCUMENT ME! */
    private JPanel statusPanel = new JPanel();
    /** DOCUMENT ME! */
    private JLabel statusLabel = new JLabel();
    /** DOCUMENT ME! */
    private BorderLayout borderLayout1 = new BorderLayout();
    
    /**
     * DOCUMENT ME!
     */
    public void init() {
    	//System.out.println(new File(".").getAbsolutePath());
    	//PropertyConfigurator.configure("../log4j.properties");
        //        palette = Palettes.getPaletteDivergent(0);
        try {
            componentsInit();
            executionControl.setComplexTopLevelPanel(complexTopLevelPanel);
            executionControl.setIfsTopLevelPanel(iteratedTopLevelPanel);
            executionControl.setProgressBar(progressBar);
            executionControl.setStatusLabel(statusLabel);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    private void componentsInit() throws Exception {
        mainTabbedPane.addTab("Complex", complexTopLevelPanel);
        mainTabbedPane.addTab("Iterated", iteratedTopLevelPanel);
        
        topLevelPanel.setLayout(gridBagLayout1);
        topLevelPanel.add(
            mainTabbedPane,
            new GridBagConstraints(
                0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
                0));
 
        this.getContentPane().addComponentListener(
            new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    FraktalApplet.this.topLevelPanelComponentResized();
                }
            });
        topLevelPanel.addComponentListener(
            new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    FraktalApplet.this.topLevelPanelComponentResized();
                }
            });

        progressBar.setForeground(new Color(51, 51, 153));
        progressBar.setMinimum(0);
        progressBar.setStringPainted(true);
        
     
        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        statusPanel.setLayout(borderLayout1);
        statusLabel.setForeground(Color.black);
        statusLabel.setText(" ");
      
        this.getContentPane().add(topLevelPanel, BorderLayout.CENTER);
        
        topLevelPanel.add(
            statusPanel,
            new GridBagConstraints(
                0, 1, 1, 1, 0.8, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(3, 5, 3, 5),
                0, 0));
        
        topLevelPanel.add(
            progressBar,
            new GridBagConstraints(
                1, 1, 1, 1, 0.2, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                    3, 5, 3, 5), 0, 0));
        statusPanel.add(statusLabel, BorderLayout.CENTER);

        repaint();
    }

    //******************************************************************************
    /**
     * DOCUMENT ME!
     */
    public void start() {
        topLevelPanelComponentResized();
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param key DOCUMENT ME!
     * @param def DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getParameter(String key, String def) {
        return ((getParameter(key) != null) ? getParameter(key) : def);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     */
    private final void topLevelPanelComponentResized() {
        int w = 0;
        int h = 0;

        try {
            w = Integer.parseInt(getParameter("WIDTH"));
            h = Integer.parseInt(getParameter("HEIGHT"));
        } catch (NumberFormatException nfe) {
        }

        resize(w, h);
        topLevelPanel.setSize(w, h);
        this.validate();
        repaint();
    }
}
