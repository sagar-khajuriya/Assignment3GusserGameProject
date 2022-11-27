package guess.game.com;

import java.util.Scanner;

public class Gusser {
	int guessNumber;
// here the guesser can guess any random Number between range
	public int guessNumber() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Gusser please guess the Number Between(0-10) : ");
		guessNumber=sc.nextInt();
		if(guessNumber>10||guessNumber<0) {
			System.out.println("Invalid Guess Please Guess Again ");
			guessNumber();
		}
		return guessNumber;
	}
}
