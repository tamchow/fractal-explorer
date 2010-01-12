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
package pl.wojciechantosiewicz.fractals;


import pl.wojciechantosiewicz.fractals.complex.convergent.ConvergentFractal;
import pl.wojciechantosiewicz.fractals.complex.convergent.NewtonFractal;
import pl.wojciechantosiewicz.fractals.complex.divergent.DivergentFractal;
import pl.wojciechantosiewicz.fractals.complex.divergent.FireShip;
import pl.wojciechantosiewicz.fractals.complex.divergent.Julia;
import pl.wojciechantosiewicz.fractals.complex.divergent.Mandelbrot;
import pl.wojciechantosiewicz.fractals.complex.divergent.TrygonometricJulia;
import pl.wojciechantosiewicz.fractals.complex.divergent.TrygonometricMandelbrot;
import pl.wojciechantosiewicz.fractals.ifs.AffineTransform;
import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public abstract class Fraktale {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    private static final IFSFractal trojkatSierpinskiego = new IFSFractal(
            "Sierpinski triangle",
            new AffineTransform[] {
                new AffineTransform(0.5f, 0.0f, 0.0f, 0.5f, -0.5f, -0.5f),
                new AffineTransform(0.5f, 0.0f, 0.0f, 0.5f, 0.5f, -0.5f),
                new AffineTransform(0.5f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f)
            });
    private static final IFSFractal drzewko = new IFSFractal(
            "Tree",
            new AffineTransform[] {
                new AffineTransform(0.195f, -0.488f, 0.344f, 0.443f, -0.4375f, 0.3125f),
                new AffineTransform(0.462f, 0.414f, -0.252f, 0.361f, 0.375f, 0.25f),
                new AffineTransform(0.0f, -0.070f, 0.453f, -0.111f, 0.0417f, -0.5f),
                new AffineTransform(0.0f, 0.070f, -0.469f, -0.022f, -0.0417f, -0.5f),
                new AffineTransform(-0.637f, 0.0f, 0.0f, 0.501f, 0.0f, 0.0f)
            });
    private static final IFSFractal pieciokat = new IFSFractal(
            "Pentagon",
            new AffineTransform[] {
                new AffineTransform(0.385f, 0.0f, 0.0f, 0.385f, 0.0f, 0.625f),
                new AffineTransform(0.385f, 0.0f, 0.0f, 0.385f, 0.625f, 0.15f),
                new AffineTransform(0.385f, 0.0f, 0.0f, 0.385f, -0.625f, 0.15f),
                new AffineTransform(0.385f, 0.0f, 0.0f, 0.385f, -0.385f, -0.625f),
                new AffineTransform(0.385f, 0.0f, 0.0f, 0.385f, 0.385f, -0.625f)
            });
    private static final IFSFractal krysztal = new IFSFractal(
            "Crystal",
            new AffineTransform[] {
                new AffineTransform(-0.25f, 0.0f, 0.0f, 0.25f, 0.0f, 0.666f),
                new AffineTransform(0.25f, 0.0f, 0.0f, 0.25f, -0.666f, -0.408f),
                new AffineTransform(0.25f, 0.0f, 0.0f, 0.25f, 0.666f, -0.408f),
                new AffineTransform(-0.333f, 0.666f, 0.666f, 0.333f, 0.0f, 0.0f)
            });
    private static final IFSFractal labirynt = new IFSFractal(
            "Cantor's maze",
            new AffineTransform[] {
                new AffineTransform(0.333f, 0.0f, 0.0f, 0.333f, 0.0f, 0.666f),
                new AffineTransform(0.0f, 0.333f, 1.0f, 0.0f, 0.666f, 0.0f),
                new AffineTransform(0.0f, -0.333f, 1.0f, 0.0f, -0.666f, 0.0f)
            });
    private static final IFSFractal paproc = new IFSFractal(
            "Fern",
            new AffineTransform[] {
                new AffineTransform(0.0f, 0.0f, 0.0f, 0.25f, 0.0f, -0.75f),
                new AffineTransform(-0.150f, 0.283f, 0.260f, 0.23f, 0.285f, -0.5f),
                new AffineTransform(0.197f, -0.226f, 0.226f, 0.23f, -0.2292f, -0.5f),
                new AffineTransform(0.849f, 0.037f, -0.037f, 0.8542f, 0.035f, 0.2292f)
            });
    private static final IFSFractal lisc = new IFSFractal(
            "Leaf��",
            new AffineTransform[] {
                new AffineTransform(0.35f, 0.35f, -0.35f, 0.375f, 0.5f, 0.0f), // 0.2f
            new AffineTransform(0.35f, -0.35f, 0.35f, 0.375f, -0.5f, 0.0f), // 0.35f
            new AffineTransform(0.5f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f), // 0.2f
            new AffineTransform(0.5f, 0.0f, 0.0f, 0.588f, 0.0f, -0.25f), // 0.2f
            new AffineTransform(0.0f, 0.0f, 0.0f, 0.588f, 0.0f, -0.4)
            });
    private static final IFSFractal choinka = new IFSFractal(
            "Christmas tree",
            new AffineTransform[] {
                new AffineTransform(-0.67f, 0.0f, 0.0f, 0.75f, 0.0f, 0.25f),
                new AffineTransform(0.33f, 0.4375f, -0.2917f, 0.562f, 0.333f, -0.33f),
                new AffineTransform(-0.33f, -0.4375f, -0.2917f, 0.562f, -0.333f, -0.33f),
                new AffineTransform(0.0f, 0.0f, -0.5f, 0.0f, 0.0f, -0.5f)
            });
    private static final IFSFractal jajo = new IFSFractal(
            "Catkin",
            new AffineTransform[] {
                new AffineTransform(0.8f, -0.25f, 0.68f, 0.8f, 0.05f, 0.12f),
                new AffineTransform(0.8f, 0.25f, -0.68f, 0.8f, -0.05f, 0.12f)
            });
    private static final IFSFractal krzywaKocha = new IFSFractal(
            "Koch curve",
            new AffineTransform[] {
                new AffineTransform(0.5f, 0.5f, 0.25f, -0.5f, -0.375f, 0.0f),
                new AffineTransform(0.5f, -0.5f, -0.25f, -0.5f, 0.375f, 0.0f)
            });
    private static final IFSFractal platekKocha = new IFSFractal(
            "Koch petal",
            new AffineTransform[] {
                new AffineTransform(0.333f, 0.0f, 0.0f, 0.333f, -0.333f, 0.0f),
                new AffineTransform(0.333f, 0.0f, 0.0f, 0.333f, 0.333f, 0.0f),
                new AffineTransform(0.167f, -0.289f, 0.289f, 0.167f, -0.083f, 0.144f),
                new AffineTransform(0.167f, 0.289f, -0.289f, 0.167f, 0.083f, 0.144f)
            });
    private static final IFSFractal spirala = new IFSFractal(
            "Spiral",
            new AffineTransform[] {
                new AffineTransform(-0.44f, 0.0f, 0.0f, -0.4f, -0.25f, 0.5f),
                new AffineTransform(0.76f, -0.4f, 0.375f, 0.729f, 0.0f, -0.25f)
            });
    private static final IFSFractal krzyze = new IFSFractal(
            "Cross",
            new AffineTransform[] {
                new AffineTransform(0.3f, 0.3f, -0.3f, 0.3f, -0.5f, 0.5f),
                new AffineTransform(0.3f, 0.3f, -0.3f, 0.3f, 0.5f, 0.5f),
                new AffineTransform(0.3f, 0.3f, -0.3f, 0.3f, -0.5f, -0.5f),
                new AffineTransform(0.3f, 0.3f, -0.3f, 0.3f, 0.5f, -0.5f)
            });

    //******************************************************************************
    /** DOCUMENT ME! */
    public static final IFSFractal[] ifsFractals = new IFSFractal[] {
            trojkatSierpinskiego, drzewko, pieciokat, krysztal, labirynt, paproc, lisc, choinka, jajo, krzywaKocha,
            platekKocha, spirala, krzyze
        };

    /** DOCUMENT ME! */
    public static final DivergentFractal[] divergentFractals = new DivergentFractal[] {
            new Mandelbrot(), new Julia(), new TrygonometricMandelbrot(), new TrygonometricJulia(), new FireShip()
        };

    /** DOCUMENT ME! */
    public static final ConvergentFractal[] convergentFractals = new ConvergentFractal[] { new NewtonFractal() };
}
