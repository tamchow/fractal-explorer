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
 * Palette of colors arranged in an array with specified segments.
 * Each palette consist of a number of equally sized segments. Segments are only logical arrangement of colors.
 * 
 * @author Wojciech Antosiewicz
 */
public class FractalPalette extends Gradient {
	protected int numberOfSegments;


	/**
	 * Creates a new FractalPalette object.
	 * 
	 * @param colors array of colors
	 * @param numberOfSegments 
	 */
	public FractalPalette(Color[] colors, int numberOfSegments) {
		super(colors);
		this.numberOfSegments = numberOfSegments;
	}

	/**
	 * Creates a new FractalPalette object.
	 * 
	 * @param colors array of colors
	 */
	public FractalPalette(Color[] colors) {
		this(colors, 1);
	}
	
	/**
	 * @return the numberOfSegments
	 */
	public int getNumberOfSegments(){
		return numberOfSegments;
	}	
	
}
