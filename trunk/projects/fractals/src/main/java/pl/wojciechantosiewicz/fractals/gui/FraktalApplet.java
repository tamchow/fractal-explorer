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
package pl.wojciechantosiewicz.fractals.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import pl.wojciechantosiewicz.fractals.ExecutionControl;
import pl.wojciechantosiewicz.fractals.gui.complex.ComplexTopLevelPanel;
import pl.wojciechantosiewicz.fractals.gui.ifs.IFSTopLevelPanel;

/**
 * Top level class which puts all gui elements together.
 * Main method allows to start it as stand alone program. 
 * 
 * @author Wojciech Antosiewicz
 */
public class FraktalApplet extends JApplet {
	private static final long serialVersionUID = 7617147846823557416L;
	static{
		UIManager.put("swing.boldMetal", Boolean.FALSE);
	}
	
	private static boolean isApplet = true;

	private JPanel topLevelPanel;

	private ExecutionControl executionControl;

	private JTabbedPane mainTabbedPane;

	private ComplexTopLevelPanel complexTopLevelPanel;

	private IFSTopLevelPanel iteratedTopLevelPanel;

	private JProgressBar progressBar;

	private JPanel statusPanel;

	private JLabel statusLabel;
	

	@Override
	public void init(){
		
		executionControl = ExecutionControl.getInstance();
		try{
			componentsInit();
			executionControl.setComplexTopLevelPanel(complexTopLevelPanel);
			executionControl.setIfsTopLevelPanel(iteratedTopLevelPanel);
			executionControl.setProgressBar(progressBar);
			executionControl.setStatusLabel(statusLabel);
		}catch(Exception e){
			e.printStackTrace();

		}
	}

	/**
	 * Initializes all GUI components.
	 * 
	 * @throws Exception if creation of any component is unsuccessful
	 */
	private void componentsInit() throws Exception{
		mainTabbedPane = new JTabbedPane();
		complexTopLevelPanel = new ComplexTopLevelPanel();
		iteratedTopLevelPanel = new IFSTopLevelPanel();
		mainTabbedPane.addTab("Complex", complexTopLevelPanel);
		mainTabbedPane.addTab("Iterated", iteratedTopLevelPanel);

		topLevelPanel = new JPanel();
		topLevelPanel.setLayout(new GridBagLayout());
		topLevelPanel.add(mainTabbedPane, new GridBagConstraints(
				0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		this.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e){
				FraktalApplet.this.topLevelPanelComponentResized();
			}
		});
		topLevelPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e){
				FraktalApplet.this.topLevelPanelComponentResized();
			}
		});

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(51, 51, 153));
		progressBar.setMinimum(0);
		progressBar.setStringPainted(true);

		statusPanel = new JPanel();
		statusPanel.setBorder(BorderFactory.createEtchedBorder());
		statusPanel.setLayout(new BorderLayout());
		
		statusLabel = new JLabel();
		statusLabel.setForeground(Color.black);
		statusLabel.setText(" ");

		this.getContentPane().add(topLevelPanel, BorderLayout.CENTER);

		topLevelPanel.add(statusPanel, new GridBagConstraints(
				0, 1, 1, 1, 0.8, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(3, 5, 3, 5), 0, 0));

		topLevelPanel.add(progressBar, new GridBagConstraints(
				1, 1, 1, 1, 0.2, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(3, 5, 3, 5), 0, 0));
		statusPanel.add(statusLabel, BorderLayout.CENTER);

		repaint();
	}

	
	@Override
	public void start(){
		super.start();
		// topLevelPanelComponentResized();
	}

	/**
	 * Returns applet parameter value with provided key(name)
	 * @param key name of parameter
	 * @param def returned value if key is not found
	 * @return value of parameter with key name or <code>def</code> if such parameter is not found
	 */
	public String getParameter(String key, String def){
		return ((getParameter(key) != null) ? getParameter(key) : def);
	}

	
	private final void topLevelPanelComponentResized(){
		if(isApplet){
			try{
				int width = Integer.parseInt(getParameter("WIDTH"));
				int height = Integer.parseInt(getParameter("HEIGHT"));
				resize(width, height);
				topLevelPanel.setSize(width, height);
			}catch(NumberFormatException nfe){
				// do something ?
			}		
			validate();
			repaint();
		}
	}

	/**
	 * Main method for running in stand alone way 
	 * @param args
	 */
	public static void main(String[] args){
		isApplet = false;
		FraktalApplet applet = new FraktalApplet();
		JFrame frame = new JFrame("Fractals");
		frame.add(applet);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
}
