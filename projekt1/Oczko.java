package projekt1;

import java.util.Random;
import java.util.Scanner;

public class Oczko {

	
	public static void main(String[] args){
	
		System.out.println("blackjack v0.7");
		Scanner scn = new Scanner(System.in);
		start(scn);
		
		scn.close();
	}
	
	
	public static int dice() {
		Random rnd = new Random();
		int los = rnd.nextInt(5) + 1;
		return los;
	}
	
	public static void start(Scanner scn){
		
		
		int result = 0;
		while(true){
			System.out.println("hit enter for next throw");
			scn.nextLine();
			int Throw= dice();
			System.out.println(Throw);
			result = result + Throw;
			System.out.println("you result " + result);
			if(result>=15){
				System.out.println("do you want to add your throw: Y/N");
				String s = scn.nextLine();
				if(s.equals("Y")||s.equals("y")){
					if(result>21){
						System.out.println("you have lost");
						newGame(scn, result);
						result=0;
					}if(result==21){
						System.out.println("you have won");{
						newGame(scn,result);
						result=0;
						}
					}
				} else if (s.equals("n")||s.equals("N")){
					result = result - Throw;
					newGame(scn, result);
					result=0;
				}
			}
		}	
	}
	
	public static void newGame(Scanner scn, int result){
		System.out.println("do you want to play again? y/n");
		String answer = scn.nextLine();
		if(answer.equals("y")||answer.equals("Y")){
			System.out.println("you got "+result+" points");
		} else if (answer.equals("n")||answer.equals("N")){
			System.out.println("your result is "+ result);
			System.exit(0);
		}
		
	}
	
	
	
	
}
