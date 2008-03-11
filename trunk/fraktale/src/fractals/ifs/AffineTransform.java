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
package fractals.ifs;

/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class AffineTransform {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    /** DOCUMENT ME! */
    double a;

    /** DOCUMENT ME! */
    double b;

    /** DOCUMENT ME! */
    double c;

    /** DOCUMENT ME! */
    double d;

    /** DOCUMENT ME! */
    double e;

    /** DOCUMENT ME! */
    double f;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new AffineTransform object.
     *
     * @param a DOCUMENT ME!
     * @param b DOCUMENT ME!
     * @param c DOCUMENT ME!
     * @param d DOCUMENT ME!
     * @param e DOCUMENT ME!
     * @param f DOCUMENT ME!
     */
    public AffineTransform(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }


    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
/**
     * Creates a new AffineTransform object.
     *
     * @param a DOCUMENT ME!
     * @param b DOCUMENT ME!
     * @param c DOCUMENT ME!
     * @param d DOCUMENT ME!
     * @param e DOCUMENT ME!
     * @param f DOCUMENT ME!
     */
    public AffineTransform(float a, float b, float c, float d, float e, float f) {
        this((double)a, (double)b, (double)c, (double)d, (double)e, (double)f);
    }


    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
/**
     * Creates a new AffineTransform object.
     *
     * @param affineTransform DOCUMENT ME!
     */
    public AffineTransform(AffineTransform affineTransform) {
        this(
            affineTransform.a, affineTransform.b, affineTransform.c, affineTransform.d, affineTransform.e,
            affineTransform.f);
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final float transformX(float x, float y) {
        return (float)((x * a) + (y * b) + e);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final float transformY(float x, float y) {
        return (float)((x * c) + (y * d) + f);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final double transformX(double x, double y) {
        return (x * a) + (y * b) + e;
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final double transformY(double x, double y) {
        return (x * c) + (y * d) + f;
    }


    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public double[] transform(double x, double y) {
        double[] newCoords = new double[2];
        newCoords[0] = transformX(x, y);
        newCoords[1] = transformY(x, y);

        return newCoords;
    }


    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public float[] transform(float x, float y) {
        float[] newCoords = new float[2];
        newCoords[0] = transformX(x, y);
        newCoords[1] = transformY(x, y);

        return newCoords;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the a
     */
    public double getA() {
        return a;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the b
     */
    public double getB() {
        return b;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the c
     */
    public double getC() {
        return c;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the d
     */
    public double getD() {
        return d;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the e
     */
    public double getE() {
        return e;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the f
     */
    public double getF() {
        return f;
    }


    /**
     * DOCUMENT ME!
     *
     * @param newTransform DOCUMENT ME!
     */
    public void setCoefficients(AffineTransform newTransform) {
        a = newTransform.getA();
        b = newTransform.getB();
        c = newTransform.getC();
        d = newTransform.getD();
        e = newTransform.getE();
        f = newTransform.getF();
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param c the c to set
     */
    public void setC(double c) {
        this.c = c;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param d the d to set
     */
    public void setD(double d) {
        this.d = d;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param e the e to set
     */
    public void setE(double e) {
        this.e = e;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param f the f to set
     */
    public void setF(double f) {
        this.f = f;
    }
}
