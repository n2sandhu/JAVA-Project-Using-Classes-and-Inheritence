/*
 * Class Name:    Rider
 *
 * Author:        Your Name
 * Creation Date: Thursday, October 03 2013, 13:36 
 * Last Modified: Saturday, October 19 2013, 13:39
 * 
 * Class Description:
 * 
 *  Rider class for CSE1OOF/4OOF Assignment 3 Semester 2 2013
 *
 */
import java.util.*;
public class Rider
{
   private String name;
   private String code ;
   private boolean onMission;
   private int[] missions = new int[3];
   private boolean[] missType=new boolean[3];
   private int levelFall=0;

   public Rider(String name,String code)
   {
      this.name=name;
      this.code=code;
      this.onMission=false;
      for(int i=0;i<3;i++)
      {
         missions[i]=0;
      }
      for(int j=0;j<3;j++)
      {
         missType[j]=false;
      }
   }
   public Rider(String name,String code,boolean onMission,int training,int transport,int fall,boolean onTrainMiss,boolean onTransportMiss,boolean onFallMiss)
   {
      this.name=name;
      this.code=code;
      this.onMission=onMission;
      this.missions[0]=training;
      this.missions[1]=transport;
      this.missions[2]=fall;
      this.missType[0]=onTrainMiss;
      this.missType[1]=onTransportMiss;
      this.missType[2]=onFallMiss;
   }
   public String getName()
   {
      return this.name;
   }
   public String getCode()
   {
      return this.code;		
   }
   public boolean getOnMission()
   {
      return this.onMission;
   }
   public int[] getMission()
   {
      int[] temp=new int[3];
      for(int i=0;i<3;i++)
      {
         temp[i]=missions[i];
      }
      return temp;
   }
   public String getDragonColour()
   {
      String s=Info.getColour(this.code);
	  return s;
   }
   public int getStatus()
   {
	String newSt=this.code.substring(6,7);
      int stat=Integer.parseInt(newSt);
      return stat;
   }
   public boolean availOnMission()
   {
      int stat=getStatus();
      if(stat==3)
      {
         return false;
      }
      return true;
   }
   public void setMission(int missionType)
   {
      boolean avail=availOnMission();
      if(avail==true)
      {
         if(missionType==0 && getStatus()==0)
         {
            addMission(missionType);
			onMission=true;
         }
         else if((missionType==1 ) && (getStatus()==1 || getStatus()==2))
         {
            addMission(missionType);
			onMission=true;
         }
		 else if(missionType==2 && (getStatus()==1 || getStatus()==2))
		 {
		 Scanner keyboard=new Scanner(System.in);
			System.out.println("Enter the level of fall(1 or 2): ");
			int fall=keyboard.nextInt();
			if(getStatus()==1 && fall==2)
			{
				System.out.println("Rider with status 1 cannot be assigned to level 2 fall");
				System.out.println("Mission not set");
				
			}
			else 
			{
				addMission(missionType);
				onMission=true;
			}
			this.levelFall=fall;
		 }
		 else
		 {
			System.out.println("Not possible");
		 }
      }
	  else
	  {
		System.out.println("Rider is not available for mission....");
	  }
   }
   private void addMission(int missionType)
   {
      switch(missionType)
      {
         case 0:
            missions[0]+=1;
         missType[0]=true;
         break;
         case 1:
            missions[1]+=1;
         missType[1]=true;
         break;
         case 2:
            missions[2]+=1;
         missType[2]=true;
         break;
      }
   }
   public void endMission()
   {
      boolean avail=onMission;
      if(avail==true)
      {
         for(int i=0;i<3;i++)
         {
            if(missType[i]=true)
            {
               missType[i]=false;
			   this.onMission=false;
               return;
            }
         }
      }
	  else
	  {
		System.out.println("Rider is not on the mission");
	  }
      this.onMission=false;
   }
   public void endMission(int missionType)
   {
      missType[missionType]=false;
   }
   public void updateHours()
   {
      if(missType[0]==true)
      {
         int hours=Info.getHours(this.code);
         int newHours=hours+4;
         if(newHours>99)
         {
            String temp= Info.resetHours( this.code );
            setStatus(3);
            endMission(0);
         }
         else
         {
            this.code=code.substring(0,7)+newHours;   
         }
      }
      else if(missType[1]==true)
      {
         int hours=Info.getHours(this.code);
         int newHours=hours+6;
         if(newHours>99)
         {
            String temp= Info.resetHours( this.code );
            setStatus(3);
            endMission(1);
         }
         else
         {
            this.code=code.substring(0,7)+newHours;   
         }
      }
      else if(missType[2]==true)
      {
         int hours=Info.getHours(this.code);
         int newHours=hours+2;
         if(newHours>99)
         {
            String temp= Info.resetHours( this.code );
            setStatus(3);
            endMission(1);
         }
         else
         {
            this.code=code.substring(0,7)+newHours;   
         }
      }
	 

   }

   public void setStatus(int newStatus)
   {
      if(newStatus>=0 || newStatus<=3)
      {
         String s=Info.updateStatus(this.code,newStatus);
         this.code=s;
		 //System.out.println(code);
      }
      else
      {
         System.out.println("Invalid choice........!!!!!!!!!");
      }
   }
   public String toString()
   {
      String s="Rider[ name: "+name+" is "+Info.getGender(this.code);
      s+=" rides "+ getDragonColour()+" dragon "+ this.code.substring(1,4);
	  s+="\n";
      if(onMission==false)
      {
         s+=" is not on mission"+"\n Mission type:none";
      }
      else if(onMission==true)
      {
         s+="is currently on mission"+"\n MissionType: ";
		 if(missType[0]==true)
		 {
			s+="Thread training";
		 }
		 else if(missType[1]==true)
		 {
			s+="Thread tansport"+"level of fall is"+levelFall;
		 }
		 else if(missType[2]==true)
		 {
			s+="Thread Fall"+"level of fall is"+levelFall;
		 }
      }
      s+=" \n is of status level: "+getStatus()+"\n";
      s+="currently has flown for "+Info.getHours(this.code)+" hours withou a break" +"\n";
      s+="and has flown a total of "+missions[0]+" training missions, "+missions[1]+" transport missions, "+
         missions[2]+" fall missions ]\n";
      return s;
   }
}

