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
package pl.wojciechantosiewicz.fractals.palette;

import java.awt.Color;

import pl.wojciechantosiewicz.image.Gradient;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class FractalPalette extends Gradient {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------

	public enum PaletteType {
		CONVERGENT, DIVERGENT
	}

	// ~ Instance fields ----------------------------------------------------------------------------------------------

	private PaletteType type;

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new FractalPalette object.
	 * 
	 * @param colors
	 *        DOCUMENT ME!
	 * @param segmentSize
	 * @param type
	 *        DOCUMENT ME!
	 */
	public FractalPalette(Color[] colors, int segmentSize, PaletteType type) {
		super(colors, segmentSize);
		this.type = type;

	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @return the type
	 */
	public PaletteType getType(){
		return type;
	}
}
