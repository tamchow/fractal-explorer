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
package pl.wojciechantosiewicz.fractals.ifs;

/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class IFSFractal {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    private String name;

    /** DOCUMENT ME! */
    private AffineTransform[] transformations;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new FractalIFS object.
     *
     * @param transformCount DOCUMENT ME!
     */
    public IFSFractal(int transformCount) {
        name = new String("");
        transformations = new AffineTransform[transformCount];
    }


    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
/**
     * Creates a new FractalIFS object.
     *
     * @param name DOCUMENT ME!
     * @param transformations DOCUMENT ME!
     */
    public IFSFractal(String name, AffineTransform[] transformations) {
        this.transformations = transformations;
        this.name = name;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String toString() {
        return name + " (" + transformations.length + ")";
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTransformCount() {
        return transformations.length;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the transformations
     */
    public AffineTransform[] getTransformations() {
        return transformations;
    }
}
