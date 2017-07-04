//package ScubaDivingAssitant;


/*
 * 		! DON'T CHANGE THIS NOTE !
 * 		========================================================================================
 * 		Console Based Application for Scuba Diving Calculation Assistant
 * 		This Class use SDCalcEngine
 * 		=========================================================================================
 * 		Code's Created by : 
 * 		Riyan Saputra Irawan (141105151104) 
 * 		Ibn Khaldun Bogor University
 * 		Copyright 2016
 * 		=========================================================================================
 * 		Keep it clean,don't modification without author permissions :).
 * 		Contact Us 		: riyansaputrai007@gmail.com 
 * 		Visit our blog 	: tech4hd.blogspot.com
 * 		=========================================================================================
 * 		! DON'T CHANGE THIS NOTE !
 */

import java.util.Scanner;

public class ScubaDiving extends SDCalcEngine
{
	Scanner scn=new Scanner(System.in);
	double tempNumber,Fg,Pg,P;
	int rows,cols;
	
	String[] inUser=new String[2];
	int inUserInt[]=new int[4];
	
	
	
	/*
	 * Menu Functions For User Navigation
	 */
	public static void main(String[] args)
	{
		ScubaDiving SD=new ScubaDiving();
		SD.MainMenu(null);
	}
	
	//MainMenu will show menu list and spesifict menu
	public void MainMenu(String spesificMenu)
	{
		if (spesificMenu==null)
		{

			System.out.println("\n\t(: Scuba Diving Calculation Assistant :)");
			System.out.print("\n\n\t< Choose which you want to perform ? >"+
			"\n\t-MOD\n\t-SMOD\n\t-PP\n\t-PPT\n\t-EAD\n\t-EADT\n\t-BM\n\t-Help\n\t-About\n\t-Exit\n\n\tType here : ");
			
			inUser[0]=scn.nextLine();
			
		}
		else
		{
			inUser[0]=spesificMenu;
		}
		
		
		if (inUser[0].equals("mod")||inUser[0].equals("MOD")||inUser[0].equals("Mod"))
		{
			inputMODParam();
		}
		else if (inUser[0].equals("smod")||inUser[0].equals("SMOD")||inUser[0].equals("Smod"))
		{
			inputSMODParam();
		}
		else if (inUser[0].equals("pp")||inUser[0].equals("ppo2")||inUser[0].equals("PP")
				||inUser[0].equals("PPO2")||inUser[0].equals("Ppo2"))
		{
			inputPPO2Param();
		}
		else if (inUser[0].equals("ppt")||inUser[0].equals("ppo2t")||inUser[0].equals("PPT")
				||inUser[0].equals("PPO2T")||inUser[0].equals("Ppo2t"))
		{
			inputPPO2TParam();
		}
		else if (inUser[0].equals("ead")||inUser[0].equals("EAD")||inUser[0].equals("Ead"))
		{
			inputEADParam();
		}
		else if (inUser[0].equals("eadt")||inUser[0].equals("Eadt")||inUser[0].equals("EADT"))
		{
			inputEADTParam();
		}
		else if (inUser[0].equals("bm")||inUser[0].equals("Bm")||inUser[0].equals("BM"))
		{
			inputBestMixParam();
		}
		else if (inUser[0].equals("help")||inUser[0].equals("Help")||inUser[0].equals("HELP"))
		{
			Help();
		}
		else if (inUser[0].equals("about")||inUser[0].equals("About")||inUser[0].equals("ABOUT"))
		{
			About();
		}
		else if (inUser[0].equals("exit")||inUser[0].equals("Exit")||inUser[0].equals("EXIT"))
		{
			System.out.println("\n\n\n\t(: Thanks For Use This Scuba Diving Calculation Assistant :)");
			System.exit(0);
		}
		else
		{
			System.out.println("\n\n\tValue "+inUser[0]+" didn't valid !\n\tPlease type a correct name of menu list !");
			MainMenu(null);
		}
		

		errorMsg=null;
	}
	//Dynamic but simple submenu also catch all as MainMenu
	public void SubMenu(String lastPlace)
	{
		inUserClear();
		if (lastPlace.equals("About") || lastPlace.equals("Help"))
		{
			System.out.print("\n\n\tRepeat "+lastPlace+" ?Y/N : ");	
		}
		else
		{

			System.out.print("\n\n\tRepeat "+lastPlace+" Calculation ?Y/N : ");
		}
		
		inUser[0]=scn.nextLine();
		
		if (inUser[0].equals("y")|| inUser[0].equals("Y"))
		{
			MainMenu(lastPlace);
		}
		else if (inUser[0].equals("n")||inUser[0].equals("N"))
		{
			MainMenu(null);
		}
		else
		{
			System.out.println("\n\tInput "+inUser[0]+" didn't valid !");
			inUserClear();
			SubMenu(lastPlace);
		}

		errorMsg=null;
	}
	
	public void About()
	{
		System.out.println("\n\tAbout Scuba Diving Calculation Assistant");
		System.out.println("\n\t=========================================");
		System.out.println("\tThis tool is for calculation all things");
		System.out.println("\tAbout Scuba Diving inculded :\n");
		System.out.println("\t-Maximum Operating Depth (MOD)");
		System.out.println("\t-Standard Maximum Operating Depth (MOD)");
		System.out.println("\t-Partial Pressure of oxygen (PPO2)");
		System.out.println("\t-Partial Pressure of oxygen (PPO2) Table");
		System.out.println("\t-Equivalent Air Depth (EAD)");
		System.out.println("\t-Equivalent Air Depth (EAD) Table");
		System.out.println("\t-Fraction of Oxygen (Best Mix)");
		System.out.println("\t=========================================");
		System.out.println("\n\n\tAll Team : \n");
		System.out.println("\t>> Leader <<");
		System.out.println("\t-Riyan Saputra Irawan (141105151104)");
		System.out.println("\t>> Members <<");
		System.out.println("\t-M.Naufal Fahmi\t(141105150720)");
		System.out.println("\t-Ghamal Nasser\t(141105150809)");
		System.out.println("\t-M.Yuda H\t(141105151137)");
		System.out.println("\t-M.Nafis\t(141105151146)");
		System.out.println("\t>> Contributions <<");
		System.out.println("\t-Made Calculation Engine\t\t: Riyan");
		System.out.println("\t-Made Console Based Application\t\t: Riyan");
		System.out.println("\t-Made README\t\t\t\t: Riyan");
		System.out.println("\t-Made Makefile\t\t\t\t: Riyan");
		System.out.println("\t-Made GUI Based Application\t\t: Fahmi & Riyan");
		System.out.println("\t-Made The Design Report\t\t\t: Nafis");
		System.out.println("\t-Made Black Box & White Box Tester\t: Nafis");
		System.out.println("\t-Made Javadoc Web based\t\t\t: Ghamal");
		System.out.println("\t-Made Manual Book\t\t\t: Yudha");
		System.out.println("\t=========================================");
		System.out.println("\tIbn Khaldun University");
		System.out.println("\tCopyright 2016"+"\n\tVersion 0.0.1c(Fixed on 07/04/2016)");
		SubMenu("About");
	}
	
	public void Help()
	{
		System.out.println("\n\tHelp for Scuba Diving Calculation Assistant");
		System.out.println("\n\t============================================================");
		System.out.println("\n\t:: Menu Input ::");
		System.out.println("\t>Type correctly the name of menu item list\n\t\t#No sensitive case i.e no matter in low or upper case");
		System.out.println("\n\t:: Calculation Input ::");
		System.out.println("\t>Type correctly the value which you want");
		System.out.println("\t>Type the value contain decimals\n\t\t#With dot(.) not a comma(,) example : 1.4");
		System.out.println("\t>Type inputs just numbers not alphabhetical");
		System.out.println("\t>Some Calculation required spesifict conditions input");
		System.out.print("\n\t- MOD Calculation: "
				+ "\n\t\tThe percentage of Oxygen should in the range of 18 to 50"
				+ "\n\t- SMOD Calculation:"
				+ "\n\t\tPercentage of oxygen should in the range of 18 % - 50%."
				+ "\n\t- PP Calculation:"
				+ "\n\t\tThe depth of dive should between 3 and 70 (inclusive)."
				+ "\n\t\tPercentage of oxygen should in the range of 18 % - 50%"
				+ "\n\t- PPT Calculation:"
				+ "\n\t\tOnly requires percentages of Oxygen from 18% to 50%."
				+ "\n\t\tThe Depths should from 3 metres to 70 metres."
				+ "\n\t- EAD Calculation:"
				+ "\n\t\tThe depth of dive should between 3 and 70 (inclusive)."
				+ "\n\t\tPercentage of oxygen should in the range of 18 % - 50%."
				+ "\n\t- BM Calculation:"
				+ "\n\t\tThe depth of the dive should between 3 and 70 inclusive."
				+ "\n\t-Depths increments of all Table calculation is 3 metres");
		System.out.println("\n\t==============================================================");
		SubMenu("Help");
	}
	//-----------END Menu Fucntions-------//
	
	
	
	
	
	
	/*
	 *  Input Fuctions For User Input Parameters
	 */

	//Clearing input user values
	public void inUserClear()
	{
		for(int i=0;i<inUser.length;i++)
		{
			inUser[i]=null;
		}
	}
	
	public void inputMODParam()
	{
		inUserClear();
		System.out.println("\n\n\t< MOD Calculation >\n");
		System.out.print("\tEnter the percentage of Oxygen\t\t: ");
		inUser[0]=scn.nextLine();
		System.out.print("\tEnter the partial pressure of Oxygen\n\t(between 1.1 and 1.6 inclusive)\t\t: ");
		inUser[1]=scn.nextLine();
		
		Fg=convertStringtoDouble(inUser[0]);
		Pg=convertStringtoDouble(inUser[1]);
		
		if (isErrorInput==false)
		{
			CountMOD(Pg,Fg);
			if (isErrorInput==false)
			{
				System.out.println("\n\n\t< Safe Stats For A Dive With >");
				System.out.printf("\n\t> Oxygen Percentage\t\t\t: %.1f %c O2",Fg,'%');
				System.out.printf("\n\t> Partial Pressure of Oxygen\t\t: %.2f ata ",Pg);
				System.out.printf("\n\t> Maximum Operating Depth\t\t: %.0f metres",Math.floor(MODResult));
			}
			else
			{
				if (errorMsg != null)
				{
					System.out.println("\n\n"+errorMsg);
				}
			}
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		
		
		SubMenu("MOD");
		errorMsg=null;
	}

	public void inputSMODParam()
	{
		inUserClear();
		
		System.out.println("\n\n\t< MOD Calculation >\n");
		System.out.print("\tEnter the percentage of Oxygen\t\t: ");
		inUser[0]=scn.nextLine();

		Fg=convertStringtoDouble(inUser[0]);
		
		if (isErrorInput==false)
		{
			CountMOD(1.4,Fg);
			if (isErrorInput==false)
			{
				System.out.println("\n\n\t< Safe Stats For A Dive With >");
				System.out.printf("\n\t> Oxygen Percentage\t\t\t: %.1f %c O2",Fg,'%');
				System.out.printf("\n\t> Partial Pressure of Oxygen\t\t: %.2f ata ",1.40f);
				System.out.printf("\n\t> Maximum Operating Depth\t\t: %.0f metres",Math.floor(MODResult));
			}
			else
			{
				if (errorMsg != null)
				{
					System.out.println("\n\n"+errorMsg);
				}
			}
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		
		
		SubMenu("SMOD");
		errorMsg=null;

	}
	
	public void inputPPO2Param()
	{
		inUserClear();
		
		System.out.println("\n\n\t< PPO2 Calculation >\n");
		System.out.print("\tEnter the depth of the dive (in metres)\t: ");
		inUser[0]=scn.nextLine();
		System.out.print("\tEnter the percentage of Oxygen\t\t: ");
		inUser[1]=scn.nextLine();

		P=convertStringtoDouble(inUser[0]);
		Fg=convertStringtoDouble(inUser[1]);
		
		if (isErrorInput==false)
		{
			CountPPO2(Fg,P);
			if (isErrorInput==false)
			{
				if (PPO2Result>=1.1 && PPO2Result <=1.6)
				{
					System.out.println("\n\n\t< Safe Stats For A Dive With >");
				}
				else
				{

					System.out.println("\n\n\t< Not Safe Stats For A Dive With >");
				}
				System.out.printf("\n\t> Oxygen Percentage\t\t\t: %.1f %c O2",Fg,'%');
				System.out.printf("\n\t> Partial Pressure of Oxygen\t\t: %.2f ata ",PPO2Result);
				System.out.printf("\n\t> Maximum Operating Depth\t\t: %.0f metres",P);
				if (PPO2Result<1.1 || PPO2Result >1.6)
				{
					System.out.printf("\n\n\tNote:\n\t-Your Stat of Partial Pressure of Oxygen is %.2f ata ",PPO2Result);
					System.out.print("\n\t-Safe of Partial Pressure of Oxygen is between 1.1 ata and 1.6 ata");
				}
			}
			else
			{
				if (errorMsg != null)
				{
					System.out.println("\n\n"+errorMsg);
				}
			}
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		
		SubMenu("PPO2");
		errorMsg=null;

	}
	
	public void inputPPO2TParam()
	{
		inUserClear();

		System.out.println("\n\n\t< PPO2 Table Calculation >\n");
		System.out.print("\tEnter a start and end percentage of Oxygen\t: ");
		inUser=scn.nextLine().split(" ");
		
		if (inUser.length != 2)
		{
			isErrorInput=true;
			inUser=new String[2];
			errorMsg="\n! Error ! : Input number can't less than 2 or  more than 2 parameters";
		}
		else
		{
			inUserInt[0]=convertStringtoInteger(inUser[0]);
			inUserInt[1]=convertStringtoInteger(inUser[1]);
			if ((inUserInt[0] <18 || inUserInt[0]>50)
				||(inUserInt[1] <18 || inUserInt[1]>50))
			{
				isErrorInput=true;
				errorMsg=" ! Error ! -Only requires percentages of Oxygen from 18% to 50%.";
			}
			else
			{
				isErrorInput=false;
			}
		}
		
		if (isErrorInput==false)
		{
			System.out.print("\tEnter a start and end depth (in metres)\t\t: ");
			inUser=scn.nextLine().split(" ");
			if (inUser.length != 2)
			{
				isErrorInput=true;
				inUser=new String[2];
				errorMsg="\n! Error ! : Input number can't less than 2 or  more than 2 parameters";
			}
			else
			{
				inUserInt[2]=convertStringtoInteger(inUser[0]);
				inUserInt[3]=convertStringtoInteger(inUser[1]);
				if (inUserInt[2] <3 ||inUserInt[3] >70)
				{
					isErrorInput=true;
					errorMsg=" ! Error ! -The Depths should from 3 metres to 70 metres.";
				}
				else
				{
					isErrorInput=false;
				}
			}
		}
		
		if (isErrorInput==false)
		{
			rows=inUserInt[3]-inUserInt[2];
			cols=inUserInt[1]-inUserInt[0];
			if (rows>=1 && cols>=1)
			{
				System.out.println("\n\tPartial Pressures Table\n\tOxygen\t\t: "+inUserInt[0]+" to "+inUserInt[1]+" percent\n\tDepths\t\t: "
						+inUserInt[2]+" to "+inUserInt[3]+" metres "
						+ "\n\t======================================================================");
						
						for (int j=cols+1;j>=0;j--)
						{
							if (j==cols+1)
							{
								System.out.printf("\t \\ ");
							}
							else
							{
								System.out.printf("\t   %d ",(inUserInt[1]-j));
							}
						}
						System.out.println("\n");
						
						for (int i=inUserInt[2];i<inUserInt[3];i+=3)
						{
							P=i;
							System.out.printf("\t %d ",i);
							for (int j=cols+1;j>=0;j--)
							{
								if (j!=(cols+1))
								{
									Fg=inUserInt[1]-j;
									if (CountPPO2(Fg,P)<=1.6)
									{
										System.out.printf("\t %.2f ",CountPPO2(Fg,P));
									}
									else
									{
										System.out.printf("\t      ");
									}
									
								}
							}
							
							System.out.println();
						}
			}
			else
			{
				System.out.println("\n! Error !\n-Range Oxygen or Depths didn't valid ! \n-Prove your input is min value then max value");
			}
			
			
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		
		SubMenu("PPO2T");
		errorMsg=null;

	}
	
	public void inputEADParam()
	{
		inUserClear();
		
		System.out.println("\n\n\t< EAD Calculation >\n");
		System.out.print("\tEnter the depth of the dive (in metres)\t: ");
		inUser[0]=scn.nextLine();
		System.out.print("\tEnter the percentage of Oxygen\t\t: ");
		inUser[1]=scn.nextLine();

		P=convertStringtoDouble(inUser[0]);
		Fg=convertStringtoDouble(inUser[1]);
		
		if (isErrorInput==false)
		{
			CountEAD(Fg,P);
			if (isErrorInput==false)
			{
				System.out.printf("\n\t<  Equivalent Air Depth Calculation Result >\n");
				System.out.printf("\n\t> Oxigen Percentage\t\t: %.1f %c O2",Fg,'%');
				System.out.printf("\n\t> Maximum Operating Depth\t: %.0f metres",P);
				System.out.printf("\n\t> Equivalent Air Depth\t\t: %.0f metres",valueConverter("ata","meter",EADResult));
			}
			else
			{
				if (errorMsg != null)
				{
					System.out.println("\n\n"+errorMsg);
				}
			}
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}

		

		SubMenu("EAD");
		errorMsg=null;

	}
	
	public void inputEADTParam()
	{
		inUserClear();

		System.out.println("\n\n\t< EAD Table Calculation >\n");
		System.out.print("\tEnter a start and end percentage of Oxygen\t: ");
		inUser=scn.nextLine().split(" ");
		
		if (inUser.length != 2)
		{
			isErrorInput=true;
			inUser=new String[2];
			errorMsg="\n! Error ! : Input number can't less than 2 or  more than 2 parameters";
		}
		else
		{
			inUserInt[0]=convertStringtoInteger(inUser[0]);
			inUserInt[1]=convertStringtoInteger(inUser[1]);
			if ((inUserInt[0] <18 || inUserInt[0]>50)
				||(inUserInt[1] <18 || inUserInt[1]>50))
			{
				isErrorInput=true;
				errorMsg=" ! Error !  -Only requires percentages of Oxygen from 18% to 50%.";
			}
			else
			{
				isErrorInput=false;
			}
		}
		
		if (isErrorInput==false)
		{
			System.out.print("\tEnter a start and end depth (in metres)\t\t: ");
			inUser=scn.nextLine().split(" ");
			if (inUser.length != 2)
			{
				isErrorInput=true;
				inUser=new String[2];
				errorMsg="\n! Error ! : Input number can't less than 2 or  more than 2 parameters";
			}
			else
			{
				inUserInt[2]=convertStringtoInteger(inUser[0]);
				inUserInt[3]=convertStringtoInteger(inUser[1]);
				if (inUserInt[2] <3 ||inUserInt[3] >70)
				{
					isErrorInput=true;
					errorMsg=" ! Error ! -The Depths should from 3 metres to 70 metres.";
				}
				else
				{
					isErrorInput=false;
				}
			}
		}
		
		if (isErrorInput==false)
		{
			
			if (((inUserInt[0]>=18 && inUserInt[0]<=50) && (inUserInt[1]>=18 && inUserInt[1]<=50))
				&& ((inUserInt[2]>=3 && inUserInt[2]<=70) && (inUserInt[3]>=3 && inUserInt[3]<=70)))
			{
				rows=inUserInt[3]-inUserInt[2];
				cols=inUserInt[1]-inUserInt[0];
				if (rows>=1 && cols>=1)
				{
					System.out.println("\n\tPartial Pressures Table\n\tOxygen\t\t: "+inUserInt[0]+" to "+inUserInt[1]+" percent\n\tDepths\t\t: "
							+inUserInt[2]+" to "+inUserInt[3]+" metres "
							+ "\n\t======================================================================");
							
							for (int j=cols+1;j>=0;j--)
							{
								if (j==cols+1)
								{
									System.out.printf("\t \\ ");
								}
								else
								{
									System.out.printf("\t %d ",(inUserInt[1]-j));
								}
							}
							System.out.println("\n");
							
							for (int i=inUserInt[2];i<inUserInt[3];i+=3)
							{
								P=i;
								System.out.printf("\t %d ",i);
								for (int j=cols+1;j>=0;j--)
								{
									if (j!=(cols+1))
									{
										Fg=inUserInt[1]-j;
										System.out.printf("\t %.0f ",valueConverter("ata","meter",CountEAD(Fg,P)));
										
									}
								}
								
								System.out.println();
							}
				}
				else
				{
					System.out.println("\n! Error !\n-Range Oxygen or Depths didn't valid ! \n-Prove your input is min value then max value");
				}
			}
			else
			{
				System.out.println("\n! Error !\n-For the purpose of this assignment Oxygen\n-Percentage set 18% upto 50%. i.e. 18 - 50 inclusive"
						+ "\n-And for Depths is set from 3m upto 70m. i.e. 3 - 70 inclusive");
			}
			
		}
		else
		{
			if (errorMsg != null)
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		
		SubMenu("EADT");
		errorMsg=null;


	}
	
	public void inputBestMixParam()
	{
		inUserClear();
		
		System.out.println("\n\n\t< BestMix Calculation >\n");
		System.out.print("\tEnter the partial pressure of Oxygen\n\t(between 1.1 and 1.6 inclusive)\t\t: ");
		inUser[0]=scn.nextLine();
		System.out.print("\tEnter the depth of the dive (in metres)\t: ");
		inUser[1]=scn.nextLine();

		Pg=convertStringtoDouble(inUser[0]);
		P=convertStringtoDouble(inUser[1]);
		
		if (isErrorInput==false)
		{
			CountBestMix(Pg,P);
			if (isErrorInput==false)
			{

				System.out.println("\n\n\t< Safe Stats For A Dive With >");
				System.out.printf("\n\t> Oxygen Percentage\t\t\t: %.0f %c O2",BestMixResult,'%');
				System.out.printf("\n\t> Partial Pressure of Oxygen\t\t: %.2f ata ",Pg);
				System.out.printf("\n\t> Maximum Operating Depth\t\t: %.0f metres",P);
			}
			else
			{
				System.out.println("\n\n"+errorMsg);
			}
		}
		else
		{
			System.out.println("\n\n"+errorMsg);
		}
		
		
		SubMenu("BM");
		errorMsg=null;
	}
}
