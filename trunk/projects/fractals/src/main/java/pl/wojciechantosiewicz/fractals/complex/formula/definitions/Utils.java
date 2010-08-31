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
package pl.wojciechantosiewicz.fractals.complex.formula.definitions;

/**
 * @author Wojciech Antosiewicz
 *
 */
public class Utils {
	/**
	 * Calculates hyperbolic sine
	 * 
	 * @param x input value of sine
	 * @return value of hyperbolic sine for specified argument
	 */
	public static final double sinh(double x){
		return 0.5 * (Math.exp(x) - Math.exp(-x));
	}

	/**
	 * Calculates hyperbolic cosine
	 * 
	 * @param x input value of cosine
	 * @return value of hyperbolic cosine for specified argument
	 */
	public static final double cosh(double x){
		return 0.5 * (Math.exp(x) + Math.exp(-x));
	}
}
