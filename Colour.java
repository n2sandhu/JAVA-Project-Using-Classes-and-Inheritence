/*
 * Class Name:    Colour
 *
 * Author:        Your Name
 * Creation Date: Thursday, October 03 2013, 16:23 
 * Last Modified: Wednesday, October 16 2013, 12:34
 * 
 * Class Description:
 *
 *   enum class for Dragon colours, part of the CSE1OOF/CSE4OOF
 *   assignment 3 semester 2, 2013
 *
 *   NOTE: this enum is FULLY IMPLEMENTED, it is not necessary
 *         to add anything to this enum (Although you may if wish)
 */

public enum Colour
{
    BL("Blue"),
    BN("Brown"),
    BZ("Bronze"),
    GD("Gold"),
    GN("Green");

    private String colour;

    Colour( String colour )
    {
         this.colour = colour;
    }

    public String getColour( )
    {
         return colour;
    }
}

