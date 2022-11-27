package guess.game.com;

import java.util.Scanner;

public class Player {
	public String[] str;
	public int[] ar;
	Scanner sc=new Scanner(System.in);	
//To get the Number of players in range between 2-5 if user enter out of range
//then it again ask for number of players till the user not give the right input
	public String[] noOfPlayers() {
		System.out.print("Enter the Number of Players (Range 2-5) : ");
	    int	num=sc.nextInt();
	    System.out.println("\n*********************************************");
	    System.out.println("|_ _ _ _ _ _ENTER NAME OF PLAYERS_ _ _ _ _ _|");
	    System.out.println("*********************************************\n");
	    str=new String[num];
		if(num<=5&&num>=2) {
			for(int i=0;i<num;i++) {
			System.out.print("Enter Player "+(i+1)+" Name : ");
			str[i]=sc.next();
			}
		}else {
			System.out.println("Invalid Number of Players \n Please Enter Again");
			noOfPlayers();
			}
		System.out.println("*********************************************");
		System.out.println("*********************************************");
//		playerGuessNo(str);
		return str;
	}
// Here Number is guessing is done by the players	
	public int[] playerGuessNo(String[] str1) {
		ar=new int[str1.length];
		for(int i=0;i<str1.length;i++) {
			System.out.print(str1[i]+" Guess the Number : ");
			ar[i]=sc.nextInt();
		}
		System.out.println("*********************************************");
		return ar;
	}
			
}

class Umpire{
	static int guessNumber;
	String[] str;
	static int[] ar;
	int round=1;
// here compute method compute the results
	void compute() {
		Scanner sc=new Scanner(System.in);
		Gusser gs=new Gusser();
		Player play=new Player();
		
		guessNumber=gs.guessNumber();
		str=play.noOfPlayers();
		ar=play.playerGuessNo(str);
		
		int counts=counting(ar,guessNumber);
		match(counts);
	}
// this method is responsible to declare the Winning player
// and also for REMATCH if two or more players guessed the same number which
// is equal to the guessed number by the Gusser
	public void match(int count) {
		Gusser gs=new Gusser();
		Player play=new Player();
		Scanner sc=new Scanner(System.in);
		
		if(count==0) {
			System.out.println("...............Game Lost..............");
		}
		if(count==1) {
			for(int i=0;i<ar.length;i++) {
				if(ar[i]==00) {
					System.out.println("** "+str[i]+" Won the Game  **CONGRATULATIONS**");
					System.out.println("*********************************************");
				}
			}
		}
		if(count==2) {
			int[] arr=new int[count];
			int j=0;
			for(int i=0;i<ar.length;i++) {
				if(ar[i]==00) {
					while(j<2) {
						arr[j]=i;
						break;
					}
					j++;
				}
			}
			round++;
			System.out.println("Game draw Between "+str[arr[0]]+" and "+str[arr[1]]);
			System.out.println("******************REMATCH********************");
			System.out.println("*********************************************");
			System.out.println("Round --> "+round+"\n");
			String[] st=new String[count];
				for(int i=0;i<st.length;i++) {
					st[i]=str[arr[i]];
				}
					guessNumber=gs.guessNumber();
					ar=play.playerGuessNo(st);
					int count1=counting(ar,guessNumber);
//					System.out.println(count1);
					match(count1);
		}

		if(count==3) {
			int[] arr=new int[count];
			int j=0;
			for(int i=0;i<ar.length;i++) {
				if(ar[i]==00) {
					while(j<3) {
						arr[j]=i;
						break;
					}
					j++;
				}
			}
			round++;
			System.out.println("Game draw Between Player "+str[arr[0]]+","+str[arr[1]]+" and "+str[arr[2]]);
			System.out.println("******************REMATCH********************");
			System.out.println("*********************************************");
			System.out.println("Round --> "+round+"\n");
			String[] st=new String[count];
				for(int i=0;i<st.length;i++) {
					st[i]=str[arr[i]];
				}
					guessNumber=gs.guessNumber();
					ar=play.playerGuessNo(st);
					int count1=counting(ar,guessNumber);
					match(count1);
		}
		
		if(count==4) {
			int[] arr=new int[count];
			int j=0;
			for(int i=0;i<ar.length;i++) {
				if(ar[i]==00) {
					while(j<4) {
						arr[j]=i;
						break;
					}
					j++;
				}
			}
			round++;
			System.out.println("Game draw Between Player "+str[arr[0]]+","+str[arr[1]]+","+str[arr[2]]+" and "+str[arr[3]]);
			System.out.println("******************REMATCH********************");
			System.out.println("*********************************************");
			System.out.println("Round --> "+round+"\n");
			String[] st=new String[count];
				for(int i=0;i<st.length;i++) {
					st[i]=str[arr[i]];
				}
					guessNumber=gs.guessNumber();
					ar=play.playerGuessNo(st);
					int count1=counting(ar,guessNumber);
					match(count1);
				}
		
		if(count==5) {
			System.out.println("All players Guessed Right Number ");
			System.out.println("To play again Press P");
			String again=sc.next();
			if(again.equalsIgnoreCase("P")) {
				
				int[] arr=new int[count];
				int j=0;
				for(int i=0;i<ar.length;i++) {
					if(ar[i]==00) {
						while(j<5) {
							arr[j]=i;
							break;
						}
						j++;
					}
				}
				round++;
				System.out.println("Game draw Between Player "+str[arr[0]]+","+str[arr[1]]+","+str[arr[2]]+","+str[arr[3]]+" and "+str[arr[4]]);
				System.out.println("******************REMATCH********************");
				System.out.println("*********************************************");
				System.out.println("Round --> "+round+"\n");
				String[] st=new String[count];
					for(int i=0;i<st.length;i++) {
						st[i]=str[arr[i]];
					}
						guessNumber=gs.guessNumber();
						ar=play.playerGuessNo(st);
						int count1=counting(ar,guessNumber);
						match(count1);
			
				
			}
		}

	}
// this method will return the number of players who guessed the right number
	public int counting(int[] ar,int guessNumber) {
		int count=0;
		for(int i=0;i<ar.length;i++) {
			if(guessNumber==ar[i]) {
				ar[i]=00;
				count++;
			}
		}
		return count;
	}
	

	
	
}

