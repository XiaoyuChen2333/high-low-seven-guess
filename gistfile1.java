package osu.cse1223;
import java.util.Scanner;
public class Project07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in=new Scanner(System.in);
	int currentPool=100;
	int bet=1;
	int winnings=0;
	bet=getBet(in, currentPool);
	while(bet>=0&&currentPool>0){
		char getHighLow=getHighLow(in);
		int die1=getRoll();
		System.out.println("Die 1 rolls: "+die1);
		int die2=getRoll();
		System.out.println("Die 2 rolls: "+die2);
		int roll=die1+die2;
		System.out.println("Total of two dice is: "+roll);
		winnings=determineWhinngs(getHighLow, bet, roll);
		if(winnings>=0){
		System.out.println("You won "+winnings+" dollars!");
		}
		else{
			System.out.println("You lost!");
		}
		currentPool =currentPool+winnings;
		if(currentPool!=0){
			bet=getBet(in,currentPool);
		}
		
	}
	System.out.println("You have "+  currentPool +" dollars.");
	System.out.println("Goodbye!");
	}
	private static int getBet(Scanner inScanner, int currentPool ){
	    System.out.println("You have "+currentPool+ " dollars.");
		System.out.println("Enter an amout to bet (0 to quit): ");
		int number=inScanner.nextInt();
		if(number==0){
			System.out.println("Goodbye!");
		}
		while((number<0)||(number>currentPool)){
			System.out.println("Your bet MUST be between 0 and "+currentPool+" dollars");
			System.out.println("You have "+currentPool+" dollars.");
			System.out.println("Enter an amout to bet (0 to quit): ");
			number=inScanner.nextInt();
		}
	
		return number;
	}
   private static char getHighLow(Scanner inSanner){
	   Scanner in=new Scanner(System.in);
	   System.out.println("High, low or sevens (H/L/S): ");
	   char getHighLow=in.next().charAt(0);
	   while(!((getHighLow=='s')||(getHighLow=='l')||(getHighLow=='h')||(getHighLow=='S')||(getHighLow=='L')||(getHighLow=='H'))){
		   System.out.println("Error! Please enter High, low or sevens (H/L/S):  ");
		   getHighLow=in.next().charAt(0);
		   
	   }
	   return getHighLow;
   }
   private static int getRoll(){
	   int roll=(int)(6*Math.random()+1);
	   return roll;
	 
   }
private static int determineWhinngs(char highLow, int bet, int roll){
	int total=100;
	if((roll>=8&&highLow=='h')||(roll>=8&&highLow=='H')||(roll<=6&&highLow=='L')||(roll<=6&&highLow=='l')||(roll==7&&highLow=='S')||(roll==7&&highLow=='s')){
		if(roll==7){
			return bet*4;
		}
		else{
		return bet;
		}
	}
	else {
		return (-1)*bet;
		
	}
	
	
	
  }
}
