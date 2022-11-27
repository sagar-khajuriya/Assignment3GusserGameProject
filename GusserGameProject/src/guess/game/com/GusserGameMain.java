package guess.game.com;

import java.util.Scanner;

public class GusserGameMain {
// this is a Multi Player game in which 2 to 5 players can play the game
// and also if the 2 or more then two players guessed the right number then
// there is an rematch until a single player win 
	public static void main(String[] args) {
		System.out.println("*W-E-L-C-O-M-E----T-H-E---------------G-A-M-E*");
	    System.out.println("*--------------T-O------G-U-E-S-S-E-R--------*");
	    System.out.println("*============================================*\n");
	    
	    Scanner sc=new Scanner(System.in);
		Umpire u=new Umpire();
		u.compute();
		
		System.out.println("To play Again Press P Or to Exit Press P");
		String str=sc.next();
		if(str.equalsIgnoreCase("P")) {
			u.compute();
		}
		System.out.println("\n*T*H*A*N*K*S**********************************");
	    System.out.println("**************F*O*R***************************");
	    System.out.println("*********************P*L*A*Y*I*N*G************");
	   
		
		
	}

}
