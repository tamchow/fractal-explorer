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
package fractals.complex.divergent;

import fractals.complex.Formula;

import javolution.text.TextFormat;
import javolution.text.TypeFormat;

import org.jscience.mathematics.numbers.Complex;

import java.io.IOException;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class Julia extends DivergentFractal {
    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new Julia object.
     */
    public Julia() {
        super(new String("Julia set"), 5);

        TextFormat<Complex> format = new TextFormat<Complex>() {
                int digits = 4;
                boolean scientific = false;
                boolean showZero = false;

                @Override
                public Appendable format(Complex complex, Appendable appendable)
                    throws IOException {
                    TypeFormat.format(complex.getReal(), digits, scientific, showZero, appendable);

                    if (complex.getImaginary() < 0.0) {
                        appendable.append(" - ");
                        TypeFormat.format(-complex.getImaginary(), digits, scientific, showZero, appendable);
                    } else {
                        appendable.append(" + ");
                        TypeFormat.format(complex.getImaginary(), digits, scientific, showZero, appendable);
                    }

                    return appendable.append('i');
                }


                @Override
                public Complex parse(CharSequence arg0, Cursor arg1) {
                    return null;
                }
            };

        Complex.FORMAT.setDefault(format);

        Formula formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                public final Complex calculate(Complex z) {
                    re2 = z.getReal() * z.getReal();
                    im2 = z.getImaginary() * z.getImaginary();

                    return Complex.valueOf(
                        re2 - im2 + cons.getReal(), (z.getReal() * z.getImaginary() * 2) + cons.getImaginary());
                }


                public String toString() {
                    return "Z^2 + C";
                }
            };

        Complex[] points = new Complex[] {
                Complex.valueOf(0.36, 0.36), Complex.valueOf(0.0, 1.0), Complex.valueOf(0.45, -0.31),
                Complex.valueOf(-0.4, 0.68), Complex.valueOf(-0.7, 0.3), Complex.valueOf(-1.77, 0.01),
                Complex.valueOf(0.34, 0.642), Complex.valueOf(-0.5, -0.5), Complex.valueOf(-1.18, 0.3),
                Complex.valueOf(0.25, 0.0), Complex.valueOf(0.42, -0.341), Complex.valueOf(-0.56, -0.64),
                Complex.valueOf(-0.15, -1.03), Complex.valueOf(0.43, 0.22), Complex.valueOf(-0.77, -0.1),
                Complex.valueOf(-0.25, -0.65), Complex.valueOf(0.17, 0.58), Complex.valueOf(-1.135, -0.213),
                Complex.valueOf(-1.08, -0.248)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);

        // ##############################################################################
        formula = new Formula(-2.0, 1.0, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            re2 - im2 + z.getReal() + cons.getReal(),
                            (z.getReal() * z.getImaginary() * 2) + z.getImaginary() + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^2 + Z + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-0.3, 0.75), Complex.valueOf(-0.35, 0.84), Complex.valueOf(-0.4, 0.84),
                Complex.valueOf(-0.36, 0.7), Complex.valueOf(-1.5, -0.02), Complex.valueOf(-1.034, 0.125),
                Complex.valueOf(-0.742, -0.525), Complex.valueOf(-0.77, -0.602), Complex.valueOf(-0.555, -0.804),
                Complex.valueOf(-0.093, -0.578), Complex.valueOf(0.003, -0.529), Complex.valueOf(-0.017, -0.525),
                Complex.valueOf(0.03, -0.17), Complex.valueOf(-0.938, 0.35), Complex.valueOf(-0.388, -0.65),
                Complex.valueOf(-0.476, -0.662)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);

        // ##############################################################################
        formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (z.getReal() * (re2 - (3 * im2))) + cons.getReal(),
                            (z.getImaginary() * ((3 * re2) - im2)) + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^3 + C";
                    }
                };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-2.0, 1.2, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            ((z.getReal() * (re2 - (3 * im2))) + re2) - im2 + cons.getReal(),
                            (z.getImaginary() * ((3 * re2) - im2)) + (2 * z.getReal() * z.getImaginary())
                            + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^3 + Z^2 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(0.14, 0.36), Complex.valueOf(-1.039, 0.024), Complex.valueOf(-1.066, 0.416),
                Complex.valueOf(-1.083, 0.378), Complex.valueOf(-1.032, 0.449), Complex.valueOf(-1.038, 0.466),
                Complex.valueOf(-1.025, 0.462), Complex.valueOf(-0.965, 0.553), Complex.valueOf(-1.003, 0.598),
                Complex.valueOf(-0.933, 0.565), Complex.valueOf(-0.891, 0.595), Complex.valueOf(-0.925, 0.609),
                Complex.valueOf(-0.441, 0.736), Complex.valueOf(-0.604, 0.825), Complex.valueOf(-0.605, 0.964),
                Complex.valueOf(-0.388, 0.922), Complex.valueOf(-0.227, 0.922), Complex.valueOf(-0.2, 0.847),
                Complex.valueOf(-0.284, 0.762), Complex.valueOf(-0.207, 0.722), Complex.valueOf(0.209, 0.574),
                Complex.valueOf(0.354, 0.275), Complex.valueOf(0.346, 0.143), Complex.valueOf(0.230, 0.019),
                Complex.valueOf(0.188, 4.4e-4)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.6, 1.0, -1.5, 1.6) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            ((z.getReal() * (re2 - (3 * im2))) + re2) - im2 + z.getReal() + cons.getReal(),
                            (z.getImaginary() * ((3 * re2) - im2)) + (2 * z.getReal() * z.getImaginary())
                            + z.getImaginary() + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^3 + Z^2 + Z + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-0.14, 0.0), Complex.valueOf(-0.195, 0.01), Complex.valueOf(-0.383, 0.13),
                Complex.valueOf(-0.408, 0.133), Complex.valueOf(-0.427, 0.203), Complex.valueOf(-0.436, 0.188),
                Complex.valueOf(-0.424, 0.195), Complex.valueOf(-0.465, 0.202), Complex.valueOf(-0.439, 0.243),
                Complex.valueOf(-0.436, 0.345), Complex.valueOf(-0.442, 0.39), Complex.valueOf(-0.497, 0.396),
                Complex.valueOf(-0.488, 0.448), Complex.valueOf(-0.498, 0.474), Complex.valueOf(-0.407, 0.473),
                Complex.valueOf(-0.332, 0.598), Complex.valueOf(-0.285, 0.614), Complex.valueOf(-0.256, 0.615),
                Complex.valueOf(-0.231, 0.643), Complex.valueOf(-0.202, 0.633), Complex.valueOf(-0.149, 0.657),
                Complex.valueOf(-0.125, 0.633), Complex.valueOf(-0.148, 0.69), Complex.valueOf(-0.11, 0.668),
                Complex.valueOf(-0.07, 0.682), Complex.valueOf(-0.09, 0.736), Complex.valueOf(-0.299, 0.667),
                Complex.valueOf(-0.011, 0.674), Complex.valueOf(0.07, 0.635), Complex.valueOf(0.083, 0.649),
                Complex.valueOf(0.106, 0.667), Complex.valueOf(0.105, 0.623), Complex.valueOf(0.135, 0.607),
                Complex.valueOf(0.169, 0.508), Complex.valueOf(0.219, 0.597), Complex.valueOf(0.032, -0.012)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (re2 * (re2 - (3 * im2))) - (im2 * ((3 * re2) - im2)) + cons.getReal(),
                            (z.getReal() * z.getImaginary() * ((4 * re2) - (4 * im2))) + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^4 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-1.235, 0.0), Complex.valueOf(-1.129, 0.07), Complex.valueOf(-1.058, 0.066),
                Complex.valueOf(-1.054, 0.137), Complex.valueOf(-0.971, 0.17), Complex.valueOf(-1.09, 0.212),
                Complex.valueOf(-0.546, 0.420), Complex.valueOf(-0.237, 0.411), Complex.valueOf(-0.242, 0.476),
                Complex.valueOf(0.304, 0.73), Complex.valueOf(0.275, 0.822), Complex.valueOf(0.557, 0.055),
                Complex.valueOf(0.537, 0.024), Complex.valueOf(0.476, 4.5e-4)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.8, 1.2, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            ((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + cons.getReal(),
                            (z.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
                            + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^4 + Z^3 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-1.52, 0.0), Complex.valueOf(-1.503, 0.031), Complex.valueOf(-1.43, 0.064),
                Complex.valueOf(-1.34, 0.017), Complex.valueOf(-1.356, 0.084), Complex.valueOf(-1.294, 0.114),
                Complex.valueOf(-1.289, 0.066), Complex.valueOf(-1.228, 0.076), Complex.valueOf(-1.22, -0.057),
                Complex.valueOf(-1.089, 0.051), Complex.valueOf(-1.008, 0.014), Complex.valueOf(-1.057, 0.095),
                Complex.valueOf(-1.479, 0.197), Complex.valueOf(-0.98, 0.129), Complex.valueOf(-1.081, 0.187),
                Complex.valueOf(-0.983, 0.228), Complex.valueOf(-0.291, 0.592), Complex.valueOf(-0.299, 0.688),
                Complex.valueOf(-0.195, 0.679), Complex.valueOf(-0.097, 0.665), Complex.valueOf(0.119, 0.86),
                Complex.valueOf(0.125, 0.971), Complex.valueOf(0.240, 0.856), Complex.valueOf(0.356, 0.874),
                Complex.valueOf(0.432, 0.868), Complex.valueOf(0.494, 0.818), Complex.valueOf(0.58, 0.816),
                Complex.valueOf(0.489, 0.777), Complex.valueOf(0.428, 0.821), Complex.valueOf(0.432, 0.752),
                Complex.valueOf(0.451, 0.698), Complex.valueOf(0.472, 0.294), Complex.valueOf(0.320, 0.002),
                Complex.valueOf(-0.733, 0.344)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.6, 1.2, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + re2) - im2
                            + cons.getReal(),
                            (z.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
                            + (2 * z.getReal() * z.getImaginary()) + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^4 + Z^3 + Z^2 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-1.236, 0.0), Complex.valueOf(-1.103, -0.015), Complex.valueOf(-1.054, 0.081),
                Complex.valueOf(-0.955, 0.077), Complex.valueOf(-0.938, 0.133), Complex.valueOf(-1.013, -0.096),
                Complex.valueOf(-0.889, 0.187), Complex.valueOf(-0.917, -0.051), Complex.valueOf(-0.888, -0.044),
                Complex.valueOf(-1.17, 0.397), Complex.valueOf(-0.856, 0.341), Complex.valueOf(-0.849, 0.434),
                Complex.valueOf(-0.84, 0.498), Complex.valueOf(-0.782, 0.547), Complex.valueOf(-0.798, 0.580),
                Complex.valueOf(-0.488, 0.903), Complex.valueOf(-0.373, 1.024), Complex.valueOf(-0.079, 1.047),
                Complex.valueOf(-0.017, 0.95), Complex.valueOf(0.056, 1.045), Complex.valueOf(-0.02, 1.187),
                Complex.valueOf(0.082, 0.916), Complex.valueOf(0.15, 0.839), Complex.valueOf(0.171, 0.756),
                Complex.valueOf(0.216, 0.7), Complex.valueOf(0.363, 0.691), Complex.valueOf(0.313, 0.7),
                Complex.valueOf(0.303, 0.413), Complex.valueOf(0.338, 0.289), Complex.valueOf(0.286, 0.113),
                Complex.valueOf(0.249, 0.035), Complex.valueOf(0.188, 0.003), Complex.valueOf(-0.81, 0.667)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.7, 1.0, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (((re2 - (3 * im2)) * (re2 + z.getReal())) - (im2 * ((3 * re2) - im2)) + re2) - im2
                            + z.getReal() + cons.getReal(),
                            (z.getImaginary() * (((4 * z.getReal() * (re2 - im2)) + (3 * re2)) - im2))
                            + (2 * z.getReal() * z.getImaginary()) + z.getImaginary() + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^4 + Z^3 + Z^2 + Z + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-0.965, -6.6e-4), Complex.valueOf(-0.878, 0.013), Complex.valueOf(-0.834, 0.009),
                Complex.valueOf(-0.787, 0.115), Complex.valueOf(-0.667, 0.081), Complex.valueOf(-0.613, 0.133),
                Complex.valueOf(-0.569, 0.193), Complex.valueOf(-0.557, 0.223), Complex.valueOf(-0.482, 0.285),
                Complex.valueOf(-0.459, 0.306), Complex.valueOf(-0.431, 0.337), Complex.valueOf(-0.348, 0.291),
                Complex.valueOf(-0.488, 0.336), Complex.valueOf(-0.529, 0.33), Complex.valueOf(-0.126, 0.274),
                Complex.valueOf(0.02, 0.216), Complex.valueOf(-0.025, 0.287), Complex.valueOf(-0.024, 0.404),
                Complex.valueOf(-0.007, 0.421), Complex.valueOf(0.019, 0.451), Complex.valueOf(0.042, 0.5),
                Complex.valueOf(0.069, 0.522), Complex.valueOf(0.034, 0.506), Complex.valueOf(0.107, 0.502),
                Complex.valueOf(0.178, 0.516), Complex.valueOf(0.321, 0.457), Complex.valueOf(0.312, 0.502),
                Complex.valueOf(0.297, 0.373)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (z.getReal() * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2)))))
                            + cons.getReal(),
                            (z.getImaginary() * ((re2 * ((5 * re2) - (7 * im2))) - (im2 * ((3 * re2) - im2))))
                            + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^5 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(0.001, 0.678), Complex.valueOf(0.062, 0.634), Complex.valueOf(0.115, 0.662),
                Complex.valueOf(0.096, 0.685), Complex.valueOf(0.0146, 0.728), Complex.valueOf(0.178, 0.686),
                Complex.valueOf(0.258, 0.695), Complex.valueOf(0.203, 0.731), Complex.valueOf(0.236, 0.773),
                Complex.valueOf(0.349, 0.789), Complex.valueOf(0.381, 0.717), Complex.valueOf(0.525, 0.632),
                Complex.valueOf(0.54, 0.746), Complex.valueOf(0.535, 0.81), Complex.valueOf(0.569, 0.879),
                Complex.valueOf(0.612, 0.895), Complex.valueOf(0.656, 0.793), Complex.valueOf(0.76, 0.762),
                Complex.valueOf(0.843, 0.746), Complex.valueOf(0.762, 0.204), Complex.valueOf(0.643, 0.083)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();

                        return Complex.valueOf(
                            (re2 * ((re2 * (re2 - (3 * im2))) - (im2 * ((7 * re2) - (5 * im2)))))
                            + (im2 * ((im2 * ((3 * re2) - im2)) - (re2 * ((5 * re2) - (7 * im2))))) + cons.getReal(),
                            (z.getReal() * z.getImaginary() * ((re2 * ((6 * re2) - (10 * im2)))
                            - (im2 * ((10 * re2) - (6 * im2))))) + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^6 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-1.139, 9.85e-4), Complex.valueOf(-1.058, 0.031), Complex.valueOf(-1.079, 0.017),
                Complex.valueOf(-1.08, 0.051), Complex.valueOf(-1.038, 0.089), Complex.valueOf(-1.01, 0.089),
                Complex.valueOf(-0.972, 0.0139), Complex.valueOf(-1.009, 0.201), Complex.valueOf(-0.909, 0.132),
                Complex.valueOf(-0.827, 0.058), Complex.valueOf(-0.827, 0.157), Complex.valueOf(-0.619, 0.372),
                Complex.valueOf(-0.472, 0.342), Complex.valueOf(-0.503, 0.406), Complex.valueOf(-0.54, 0.477),
                Complex.valueOf(-0.412, 0.701), Complex.valueOf(-0.457, 0.874), Complex.valueOf(-0.169, 0.838),
                Complex.valueOf(-0.176, 0.796), Complex.valueOf(0.18, 0.555), Complex.valueOf(0.735, 0.071),
                Complex.valueOf(0.604, 0.006)
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);
        // ##############################################################################
        formula = new Formula(-1.5, 1.5, -1.5, 1.5) {
                    public final Complex calculate(Complex z) {
                        double a;
                        double b;
                        double c;
                        re2 = z.getReal() * z.getReal();
                        im2 = z.getImaginary() * z.getImaginary();
                        a = re2 - (3 * im2);
                        b = (3 * re2) - im2;
                        c = re2 - im2;

                        return Complex.valueOf(
                            ((re2 * re2 * a * a) + (im2 * im2 * b * b)) - (2 * re2 * im2 * ((8 * c * c) + (a * b)))
                            + cons.getReal(),
                            (8 * z.getReal() * z.getImaginary() * c * ((re2 * a) - (im2 * b))) + cons.getImaginary());
                    }


                    public String toString() {
                        return "Z^8 + C";
                    }
                };
        points = new Complex[] {
                Complex.valueOf(-1.1, 4.28e-4), Complex.valueOf(-1.062, 0.015), Complex.valueOf(-1.055, 0.04),
                Complex.valueOf(-1.085, 0.047), Complex.valueOf(-1.029, 0.055), Complex.valueOf(-1.009, 0.093),
                Complex.valueOf(-0.945, 0.119), Complex.valueOf(-0.9, 0.1), Complex.valueOf(-0.845, 0.048),
                Complex.valueOf(-0.843, 0.117), Complex.valueOf(-0.789, 0.170), Complex.valueOf(-0.856, 0.191),
                Complex.valueOf(-0.759, 0.212), Complex.valueOf(-0.698, 0.29), Complex.valueOf(-0.671, 0.372),
                Complex.valueOf(-0.588, 0.627), Complex.valueOf(-0.683, 0.77), Complex.valueOf(-0.574, 0.858),
                Complex.valueOf(-0.55, 0.813), Complex.valueOf(-0.427, 0.727), Complex.valueOf(0.162, -1.027),
                Complex.valueOf(0.940, 0.486), Complex.valueOf(0.855, 0.523), Complex.valueOf(0.806, 0.218),
            };
        formula.setPoints(points);
        formula.setConstans(points[0]);
        formulas.add(formula);

        formula = formulas.get(0);
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

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

        for (int i = 0; i < palette.getSize(); i++) {
            z = formula.calculate(z);

            double magn = z.magnitude();

            //            if ( magn > radius) {
            //                return palette[i];
            //            }
            if (magn > radius) {
                float position = i - (float)(Math.log10(Math.log10(magn)) / Math.log(2));

                return palette.getRGB(position);
            }
        }

        return 0x000000;
    }
}
