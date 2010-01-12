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
package pl.wojciechantosiewicz.fractals.gui.complex;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import pl.wojciechantosiewicz.fractals.palette.FractalPalette;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
 */
public class FractalPaletteRenderer extends JLabel implements ListCellRenderer {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    /**  */
    private static final long serialVersionUID = -8829957090955734869L;

    private static final int WIDTH = 120;
    private static final int HEIGHT = 15;
    
    private static Color defaultBackground;
    private static Color focusedBackground;
    private static Color defaultForeground;
    private static Color focusedForeground;
    //~ Methods ------------------------------------------------------------------------------------------------------

    public FractalPaletteRenderer(){
    	super();
    	defaultBackground = this.getBackground();
    	focusedBackground = defaultBackground.darker().darker();
    	defaultForeground = this.getForeground();
    	focusedForeground = defaultForeground.brighter().brighter();
    	
    }
    
    /**
     * DOCUMENT ME!
     *
     * @param list DOCUMENT ME!
     * @param value DOCUMENT ME!
     * @param index DOCUMENT ME!
     * @param isSelected DOCUMENT ME!
     * @param cellHasFocus DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
    	
    	
    	FractalPalette palette = (FractalPalette)value;
        this.setText(" [" + palette.getSize() + "]");

        BufferedImage im = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = im.createGraphics();
        
        for (int x = 0; x < WIDTH; x++) {
            float position = x / (float)WIDTH;
            g.setColor(palette.getColor(position));
            g.drawLine(x, 1, x, HEIGHT-2);
        }

        setIconTextGap(5);
        setVerticalTextPosition(JLabel.CENTER);
        
        setIcon(new ImageIcon(im));

        if (cellHasFocus || isSelected) {
            setBackground(focusedBackground);
            setForeground(focusedForeground);
        }else{
        	setBackground(defaultBackground);
            setForeground(defaultForeground);
        }

        return this;
    }
}
