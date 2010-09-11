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
package pl.wojciechantosiewicz.fractals.complex.divergent;

import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.FractalType;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: author $
 * @version $Rev: 000 $
 * @todo DOCUMENT ME!
 */
public abstract class DivergentFractal extends ComplexFractal {

	/** TODO: DOCUMENT ME! */
	protected final double radius;

	/** TODO: DOCUMENT ME! */
	protected double epsilon;

	/**
	 * Creates a new DivergentFractal object.
	 * 
	 * @param name
	 *        TODO: DOCUMENT ME!
	 * @param epsilon
	 *        TODO: DOCUMENT ME!
	 */
	public DivergentFractal(String name, double epsilon) {
		super(name, FractalType.Divergent);
		this.epsilon = epsilon;
		radius = epsilon * epsilon;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return TODO: DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	public int getPaletteSize(){
		return palette.getSize();
	}

}
