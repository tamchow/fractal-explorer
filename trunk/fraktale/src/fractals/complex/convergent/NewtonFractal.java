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
package fractals.complex.convergent;

import fractals.complex.Formula;

import org.jscience.mathematics.functions.Polynomial;
import org.jscience.mathematics.functions.Variable;
import org.jscience.mathematics.numbers.Complex;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class NewtonFractal extends ConvergentFractal {
    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new NewtonFractal_1 object.
     */
    public NewtonFractal() {
        super("Newton fractals");

        createFormulas();
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     */
    private void createFormulas() {
        formulas.add(createFormula1());
        formulas.add(createFormula2());
    }

	private Formula createFormula1() {
		Variable.Local<Complex> varZ = new Variable.Local<Complex>("z");
		final Polynomial<Complex> function = Polynomial.valueOf(Complex.ONE, varZ).pow(3).plus(
                Complex.valueOf(-1, 0));
        final Polynomial<Complex> derivative = function.differentiate(function.getVariables().get(0));

        Formula formula = new Formula(-2, 2, -2, 2) {
                    public Complex calculate(Complex value) {
                        Complex funcValue = function.evaluate(value);
                        Complex derivValue = derivative.evaluate(value);

                        return funcValue.divide(derivValue);
                    }


                    public String toString() {
                        return function.toString();
                    }
                    
                    @Override
    				public int getPolynomialOrder() {
    					return 3;
    				}
                };

        Complex[] roots = {
                Complex.valueOf(1, 0), Complex.valueOf(-0.5, Math.sqrt(3) / 2),
                Complex.valueOf(-0.5, -Math.sqrt(3) / 2)
            };
        formula.setPoints(roots);
        return formula;
	}

	private Formula createFormula2() {
		Variable.Local<Complex> varZ = new Variable.Local<Complex>("z");
		final Polynomial<Complex> function = Polynomial.valueOf(Complex.ONE, varZ).pow(4).plus(
                Complex.valueOf(-1, 0));
        final Polynomial<Complex> derivative = function.differentiate(function.getVariables().get(0));

        Formula formula = new Formula(-2, 2, -2, 2) {
                    public Complex calculate(Complex value) {
                        Complex funcValue = function.evaluate(value);
                        Complex derivValue = derivative.evaluate(value);

                        return funcValue.divide(derivValue);
                    }


                    public String toString() {
                        return function.toString();
                    }
                    
                    @Override
    				public int getPolynomialOrder() {
    					return 4;
    				}
                };

        Complex[] roots = {
                Complex.valueOf(1, 0), Complex.valueOf(-1, 0), Complex.valueOf(0, 1), Complex.valueOf(0, -1),
            };
        formula.setPoints(roots);
        return formula;
	}
}
