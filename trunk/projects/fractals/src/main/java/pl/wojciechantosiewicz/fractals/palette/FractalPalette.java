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
package pl.wojciechantosiewicz.fractals.palette;

import java.awt.Color;

import woj.image.Gradient;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public class FractalPalette extends Gradient {
    //~ Static fields/initializers -----------------------------------------------------------------------------------

    /** DOCUMENT ME! */
    public static final int CONVERGENT_PALETTE = 0;

    /** DOCUMENT ME! */
    public static final int DIVERGENT_PALETTE = 1;

    //~ Instance fields ----------------------------------------------------------------------------------------------

    private int type;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new FractalPalette object.
     *
     * @param colors DOCUMENT ME!
     * @param segmentSize 
     * @param type DOCUMENT ME!
     */
    public FractalPalette(Color[] colors, int segmentSize, int type) {
        super(colors, segmentSize);

        switch (type) {
            case CONVERGENT_PALETTE:
                this.type = CONVERGENT_PALETTE;

                break;

            case DIVERGENT_PALETTE:
                this.type = DIVERGENT_PALETTE;

                break;

            default:
                throw new IllegalArgumentException(
                    "Type parameter is wrong. Use FractalPalette.CONVERGENT_PALETTE or FractalPalette.DIVERGENT_PALETTE values.");
        }
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return the type
     */
    public int getType() {
        return type;
    }
}
