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

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

import pl.wojciechantosiewicz.fractals.palette.FractalPalette;


/**
 * ListCellRenderer for displaying fractal palettes. It draws the palette and size of it.
 * @author Wojciech Antosiewicz
 */
public class FractalPaletteRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = -8829957090955734869L;

	private static final int GRADIENT_WIDTH = 120;
	private static final int GRADIENT_HEIGHT = 12;
	
	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		FractalPalette palette = (FractalPalette)value;
		String text = " [" + palette.getSize() + "]";
		this.setText(text);
				
		BufferedImage im = new BufferedImage(GRADIENT_WIDTH, GRADIENT_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = im.createGraphics();

		for(int x = 0; x < im.getWidth(); x++){
			float position = x / (float)im.getWidth();
			g.setColor(palette.getColor(position));
			g.drawLine(x, 1, x, im.getHeight() - 2);
		}

		setIcon(new ImageIcon(im));

		return this;
	}
}
