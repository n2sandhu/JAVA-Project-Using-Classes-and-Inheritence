/*
 * Class Name:    Weyr
 *
 * Author:        Your Name
 * Creation Date: Thursday, October 03 2013, 16:35 
 * Last Modified: Monday, October 07 2013, 02:15
 * 
 * Class Description:
 *
 *  Array-based class to hold Riders
 *  this is part of the CSE1OOF/CSE4OOF assignment 3,
 *  semester 3, 2013
 *
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Weyr
{
    private final int SIZE = 1500;
    private Rider [ ] riders;
    private int count;

    public Weyr( )
    {
         riders = new Rider[ SIZE ];
         count = 0;
    }

    public void addRider( Rider newRider )
    {
		String name=newRider.getName();
		int indx=search(name);
		if(indx==-1)
		{
        riders[count]=newRider;
		count++;
		System.out.println("RIDER ADDED");
		}
		 else
      {
         System.out.println("RIDER WITH SAME NAME ALREADY EXIST AT INDEX "+indx+" ...CANNOT ADD THIS RIDER");
      }
    }
	public void displayRiders()
	{
		for(int i=0;i<count;i++)
		{
			System.out.println(riders[i]);
		}
	}
	public void readFromFile(String filename) throws IOException
	{
		int skipped=0;
		File input=new File(filename);
		Scanner file=new Scanner(input);
		while(file.hasNextLine())
		{
		
			String name=file.nextLine();
			int ind=search(name);
			if(ind==-1)
			{
			String code=file.nextLine();
			boolean onMission=Boolean.parseBoolean(file.nextLine());	
			int training=file.nextInt();
			int transport=file.nextInt();
			int fall=file.nextInt();
			file.nextLine();
			boolean onTrainMiss=Boolean.parseBoolean(file.next());
			boolean onTransportMiss=Boolean.parseBoolean(file.next());
			boolean onFallMiss=Boolean.parseBoolean(file.next());
			file.nextLine();
			Rider ride=new Rider(name,code,onMission,training,transport,fall,onTrainMiss,onTransportMiss,onFallMiss);
			riders[count]=ride;
			count++;
			}
			else
			{
				file.nextLine();
				file.nextLine();
				file.nextLine();
				file.nextLine();
				skipped++;
			}
		}
		file.close();
		System.out.println(skipped+" persons not added because they had the same name");
		skipped=0;
	}
	private int search(String name)
	{
		int index=-1;
		for(int i=0;i<count;i++)
		{
			if(riders[i].getName().equals(name))
			{
				index=i;
			}
		}
		return index;
	}
	public void mission(String name,int type)	
	{
		int index=search(name);
		if(index==-1)
		{
			System.out.println("Rider with this name does not exist");
		}
		else
		{
			riders[index].setMission(type);
		}
	}
	public void endMission(String name)
	{
		int index=search(name);
		if(index==-1)
		{
			System.out.println("Rider with this name does not exist");
		}
		else
		{
			riders[index].endMission();
		}	
	}
	public String setStatus(String name,int status)
	{
		String s="";
		int index=search(name);
		if(index==-1)
		{
			System.out.println("Rider with this name does not exist");
		}
		else
		{
			if(riders[index].getStatus()==status)
			{
				System.out.println("Rider is already in the same status.......");
			}
			else
			{
				if((riders[index].getStatus()==1 || riders[index].getStatus()==2) && status==0)
				{
					s="rider is in 1 or 2 status...cannot set to 0....";
				}
				else if(riders[index].getStatus()==2 && status==1)
				{
					s="rider is in status 2...cannot set to 1....";
				}
				else if(riders[index].getStatus()==0 && status==2)
				{
					s="rider is in status 0...cannot set to 2....";
				}
				else
				{
					riders[index].setStatus(status);
					s="updated successfully";
				}
			}
		}
		return s;
	}
	public void updateHours( )
	{
		for(int i=0;i<count;i++)
		{
			riders[i].updateHours();
		}
	}
}

