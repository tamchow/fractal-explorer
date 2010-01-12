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
package pl.wojciechantosiewicz.fractals.complex.divergent;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.Formula;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class TrygonometricMandelbrot extends DivergentFractal {
    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new TrygMandelbrot object.
     */
    public TrygonometricMandelbrot() {
        super(new String("Trigonometric Mandelbrot"), 10);

        Formula formula = new Formula(-1.5 * Math.PI, 1.5 * Math.PI, -1.5 * Math.PI, 1.5 * Math.PI) {
                public final Complex calculate(Complex z) {
                    double eec = Math.sin(z.getReal()) * cosh(z.getImaginary());
                    double eed = Math.cos(z.getReal()) * sinh(z.getImaginary());

                    return Complex.valueOf(
                        (cons.getReal() * eec) - (cons.getImaginary() * eed),
                        (cons.getReal() * eed) + (cons.getImaginary() * eec));
                }


                public String toString() {
                    return "C * sin(Z)";
                }
                
                @Override
				public int getPolynomialOrder() {
					return 0;
				}
            };

        formulas.add(formula);
        //##############################################################################
        formula = new Formula(-2 * Math.PI, 2 * Math.PI, -2 * Math.PI, 2 * Math.PI) {
                    public final Complex calculate(Complex z) {
                        double eec = Math.cos(z.getReal()) * cosh(z.getImaginary());
                        double eed = Math.sin(z.getReal()) * sinh(z.getImaginary());

                        return Complex.valueOf(
                            (cons.getReal() * eec) - (cons.getImaginary() * eed),
                            (cons.getImaginary() * eed) + (cons.getImaginary() * eec));
                    }


                    public String toString() {
                        return "C * cos(Z)";
                    }
                    
                    @Override
    				public int getPolynomialOrder() {
    					return 1;
    				}
                };
        formulas.add(formula);
        formula = formulas.get(0);
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    private final double sinh(double x) {
        return 0.5 * (Math.exp(x) - Math.exp(-x));
    }


    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    private final double cosh(double x) {
        return 0.5 * (Math.exp(x) + Math.exp(-x));
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param u DOCUMENT ME!
     * @param v DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final int rgbColor(final double u, final double v) {
        z = Complex.valueOf(u, v);
        formula.setConstant(u, v);

        for (int i = 0; i < palette.getSize(); i++) {
            z = formula.calculate(z);

            if (z.magnitude() > radius) {
                return palette.getRGB(i);
            }
        }

        return 0x000000;
    }
}
