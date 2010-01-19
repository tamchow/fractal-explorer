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

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.fractals.complex.formula.IPolynomialFormula;
import pl.wojciechantosiewicz.fractals.complex.formula.PolynomialFormula;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class Mandelbrot extends DivergentFractal {
	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new Mandelbrot object.
	 */
	public Mandelbrot() {
		super(new String("Mandelbrot set"), 5);
		createFormulas();
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @param u
	 *        DOCUMENT ME!
	 * @param v
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	@Override
	public final int rgbColor(final double u, final double v){
		Complex z = Complex.valueOf(u, v);
		formula.setConstant(z);

		double magn = 0;

		for(int i = 1; i < palette.getSize(); i++){
			z = formula.calculate(z);
			magn = z.magnitude();

			if(magn > radius){
				float position = i - (float)(Math.log10(Math.log10(magn)) / Math.log(((IPolynomialFormula)formula).getOrder()));
				position /= (palette.getSize() - 1);

				return palette.getRGB(position);
			}
		}

		return 0x000000;
	}

	// ********************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	private void createFormulas(){
		formulas.add(new PolynomialFormula(new FormulaProperties(-2.2, 1.0, -1.6, 1.6), 2) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				Complex egh = Complex.valueOf(re2 - im2 + this.constant.getReal(), (z.getReal() * z.getImaginary() * 2)
						+ constant.getImaginary());

				return egh;
			}

			@Override
			public String toString(){
				return "Z^2 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-3.0, 0.8, -1.5, 1.5), 2) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(re2 - im2 + z.getReal() + constant.getReal(), (z.getReal() * z.getImaginary() * 2)
						+ z.getImaginary() + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^2 + Z + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.5, -1.5, 1.5), 3) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((z.getReal() * (re2 - (3 * im2))) + constant.getReal(), (z.getImaginary() * ((3 * re2) - im2))
						+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^3 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-2.5, 1.5, -1.5, 1.5), 3) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(((z.getReal() * (re2 - (3 * im2))) + re2) - im2 + constant.getReal(),
						(z.getImaginary() * ((3 * re2) - im2)) + (2 * z.getReal() * z.getImaginary()) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^3 + Z^2 + C";
			}
		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-2.0, 1.5, -1.6, 1.6), 3) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(((z.getReal() * (re2 - (3 * im2))) + re2) - im2 + z.getReal() + constant.getReal(), (z
						.getImaginary() * ((3 * re2) - im2))
						+ (2 * z.getReal() * z.getImaginary()) + z.getImaginary() + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^3 + Z^2 + Z + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.7, 1.2, -1.5, 1.5), 4) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((re2 * (re2 - (3 * im2))) - (im2 * ((3 * re2) - im2)) + constant.getReal(), (z.getReal()
						* z.getImaginary() * ((4 * re2) - (4 * im2)))
						+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^4 + C";
			}
		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.8, 1.1, -1.5, 1.5), 4) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + constant.getReal(), (z
						.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
						+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^4 + Z^3 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 0.9, -1.5, 1.5), 4) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + re2) - im2
						+ constant.getReal(), (z.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
						+ (2 * z.getReal() * z.getImaginary()) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^4 + Z^3 + Z^2 + C";
			}
		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.7, 0.8, -1.5, 1.5), 4) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + re2) - im2 + z.getReal()
						+ constant.getReal(), (z.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
						+ (2 * z.getReal() * z.getImaginary()) + z.getImaginary() + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^4 + Z^3 + Z^2 + Z + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.5, -1.5, 1.5), 5) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2))))) + constant.getReal(),
						(z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2)))) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^5 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.0, -1.25, 1.25), 5) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(
						((z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2))))) + (re2 * (re2 - (3 * im2))))
								- (im2 * ((3 * re2) - im2)) + constant.getReal(),
						(z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2))))
								+ (z.getReal() * z.getImaginary() * ((4 * re2) - (4 * im2))) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^5 + Z^4 + C";
			}
		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.0, -1.25, 1.25), 5) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(
						((z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2))))) + (re2 * (re2 - (3 * im2))))
								- (im2 * ((3 * re2) - im2)) + (z.getReal() * (re2 - (3 * im2))) + constant.getReal(),
						(z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2))))
								+ (z.getReal() * z.getImaginary() * ((4 * re2) - (4 * im2))) + (z.getImaginary() * ((3 * re2) - im2))
								+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^5 + Z^4 + Z^3 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.0, -1.25, 1.25), 5) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(
						(((z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2))))) + (re2 * (re2 - (3 * im2))))
								- (im2 * ((3 * re2) - im2)) + (z.getReal() * (re2 - (3 * im2))) + re2)
								- im2 + constant.getReal(),
						(z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2))))
								+ (z.getReal() * z.getImaginary() * ((4 * re2) - (4 * im2))) + (z.getImaginary() * ((3 * re2) - im2))
								+ (2 * z.getReal() * z.getImaginary()) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^5 + Z^4 + Z^3 + Z^2 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.0, -1.25, 1.25), 5) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(
						(((z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2))))) + (re2 * (re2 - (3 * im2))))
								- (im2 * ((3 * re2) - im2)) + (z.getReal() * (re2 - (3 * im2))) + re2)
								- im2 + z.getReal() + constant.getReal(),
						(z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2))))
								+ (z.getReal() * z.getImaginary() * ((4 * re2) - (4 * im2))) + (z.getImaginary() * ((3 * re2) - im2))
								+ (2 * z.getReal() * z.getImaginary()) + z.getImaginary() + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^5 + Z^4 + Z^3 + Z^2 + Z + C";
			}
		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.5, -1.5, 1.5), 6) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf((re2 * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2)))))
						+ (im2 * ((im2 * ((3 * re2) - im2)) - (re2 * ((5 * re2) - (7 * im2))))) + constant.getReal(), (z.getReal()
						* z.getImaginary() * ((re2 * ((6 * re2) - (10 * im2))) - (im2 * ((10 * re2) - (6 * im2)))))
						+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^6 + C";
			}

		});
		// ##############################################################################
		formulas.add(new PolynomialFormula(new FormulaProperties(-1.5, 1.5, -1.5, 1.5), 8) {
			public final Complex calculate(Complex z){
				double a;
				double b;
				double c;
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();
				a = re2 - (3 * im2);
				b = (3 * re2) - im2;
				c = re2 - im2;

				return Complex.valueOf(((re2 * re2 * a * a) + (im2 * im2 * b * b)) - (2 * re2 * im2 * ((8 * c * c) + (a * b)))
						+ constant.getReal(), (8 * z.getReal() * z.getImaginary() * c * ((re2 * a) - (im2 * b))) + constant.getImaginary());
			}

			@Override
			public String toString(){
				return "Z^8 + C";
			}
		});
		formula = formulas.get(0);
	}
}
