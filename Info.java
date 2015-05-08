/*
 * Class Name:    Info
 *
 * Author:        Your Name
 * Creation Date: Thursday, October 03 2013, 15:18 
 * Last Modified: Saturday, October 19 2013, 14:20
 * 
 * Class Description:
 *
 *  Utility class to be used for CSE1OOF/4OOF Assignment 3
 *  Semester 2 2013
 *
 *  Note: this class has been PARTIALLY implemented.
 *        Read the assignment for information on the remaining
 *        methods.
 *
 *        All methods are static
 *
 *        This means that there is no constructor and to call
 *        any of these methods, use the class name followed by
 *        method name.
 *
 *        For example, to call the getStatus method, the call would
 *        look like this:
 *
 *        Info.getStatus( code );
 *
 *        where code was, of course, a String variable
 */

public class Info
{
    public static int getStatus( String code )
    {
         return (int)(code.charAt( 6 )  - '0' );
    }


    /*
     * to be implemented
     * return the code String with the updated status
     *
     */
    public static String updateStatus( String code, int status )
    {
         String s=code.substring(0,6)+status+code.substring(7);
         return s;
    }

    public static char getGender( String code )
    {
         return code.charAt( 0 );
    }

    /*
     * to be implemented
     * return the String that represents the actual colour
     * of the Dragon.
     *
     * Note you will need to use the enum Colour to
     * match the 2 letter enum stored in the 
     * colour part of the code String
     *
     */
    public static String getColour( String code )
    {
         String temp=code.substring(4,6);
		 Colour colour=Colour.valueOf(temp);
         String temp1=colour.getColour();
		 return temp1;
    }

    public static int getHours( String code )
    {
         return Integer.parseInt( code.substring( 7 ).trim( ) );
    }

    /*
     * to be implemented
     * returns the code String with the hours part set to 0
     */
    public static String resetHours( String code )
    {
       String temp=code.substring(0,7)+"00";
         return temp;
    }

    public static String getDragonCode( String code )
    {
         return code.substring( 1, 4 );
    }

    /*
     * to be implemented
     *
     * returns the code String with the hours part of the code
     * String updated to include the addition of the hours
     * passed in
     *
     * Recall that if the hours exceed 99 then the hours are set
     * to 0 and the status part of the code String passed in is
     * set to 3, then the updated code String is returned.
     *
     */
    public static String updateHours( String code, int addHours )
    {
       String temp="";
         int hours=getHours(code);
         int newHours=hours+addHours;
         if(newHours>99)
         {
            String newCode=resetHours(code);
            temp=updateStatus(newCode,3);
         }
         else
         {
            temp=code.substring(0,7)+newHours;   
         }
         return temp;
    }
    
     
}

