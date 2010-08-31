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
package pl.wojciechantosiewicz.fractals.complex.formula;

/**
 * Abstract class extending ComplexFormula by adding order of the polynomial.
 * @author Wojciech Antosiewicz
 */
public abstract class PolynomialFormula extends ComplexFormula implements IPolynomialFormula {
	/**
	 * Order of the polynomial used by this formula
	 */
	protected int order;

	/**
	 * Creates new PolynomialFormula with specified properties and order
	 * @param properties formula properties to use
	 * @param order of the polynomial
	 */
	public PolynomialFormula(FormulaProperties properties, int order) {
		super(properties);
		this.order = order;
	}

	/**
	 * Creates new PolynomialFormula with default properties and specified order
	 * @param order
	 */
	public PolynomialFormula(int order){
		super();
		this.order = order;
	}
	
	/*
	 * (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.PolynomialFormula#getOrder()
	 */
	public int getOrder(){
		return order;
	}
}
