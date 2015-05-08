/*
 * Class Name:    Pern
 *
 * Author:        Your Name
 * Creation Date: Thursday, October 03 2013, 16:30 
 * Last Modified: Saturday, October 19 2013, 13:36
 * 
 * Class Description:
 *
 *  This is the driver class for the CSE1OOF/CSE4OOF
 *  assignment 3, semester 2 2013
 *
 */

import java.util.Scanner;
import java.io.IOException;

public class Pern
{
    private Scanner kb = new Scanner( System.in );
    private Weyr benden;
    
    public Pern( )
    {
       benden = new Weyr( );
    }

    private void run( ) throws IOException
    {
         char choice;
         do
         {
              menu( );
              choice = kb.nextLine( ).toLowerCase( ).charAt( 0 );
              switch( choice )
              {
                   case 'a':
                      addRider( );
					  updateRiderHours();
                     break;

                   case 's' :
                       benden.displayRiders();
					   updateRiderHours();
                     break;

                   case 'm' :
						System.out.print("Enter Riders name: ");
						String name=kb.nextLine();
						System.out.print("Enter mission Type(0 for training,1 for transport, 2 for fall): ");
						int mType=kb.nextInt();
						kb.nextLine();
						benden.mission(name,mType);
						updateRiderHours();
						break;

                   case 'u' :
                        System.out.print("Enter Riders name: ");
						String name1=kb.nextLine();
						System.out.print("Enter the new status: ");
						int status=kb.nextInt();
						kb.nextLine();
						String s=benden.setStatus(name1,status);
						System.out.println(s);
						updateRiderHours();
						break;

                   case 'e' :
                      System.out.print("Enter Riders name: ");
						String name2=kb.nextLine();
						benden.endMission(name2);
						updateRiderHours();
                     break;

                   case 'r' :
                       System.out.print("Enter the file name you want to read from: ");
					   String filename=kb.nextLine();
					   benden.readFromFile(filename);
					   updateRiderHours();
                     break;

                   case 'q':
                       System.exit(0);
                     break;
                   default:
                        System.out.println("Invalid choice");
                     break;
              }
			  
         }while( choice != 'q' );
    }

    private void menu( )
    {
         System.out.println( "\n\tMain Menu\n");
         System.out.println( "\t a - Add Rider");
         System.out.println( "\t s - Show All Riders ");
         System.out.println( "\t r - Read from file");
         System.out.println( "\t m - Set mission");
         System.out.println( "\t u - Update status");
         System.out.println( "\t e - End Mission");
         System.out.println( "\t q - Quit");
         System.out.print( "\t\tEnter choice >> ");
    }

    private void addRider( )
    {
       
       
		 System.out.print("Enter Riders name: ");
		  String name=kb.nextLine();
				   System.out.print("Enter the code: ");
				   String code=kb.nextLine();
				   Rider rider=new Rider(name,code);
				   benden.addRider(rider);
    }
	private void updateRiderHours()
	{
		benden.updateHours();
	}


    public static void main( String [ ] args ) throws IOException
    {
         Pern p = new Pern( );
         p.run( );
    }
}

