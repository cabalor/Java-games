package projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Oczko {

	static List<Integer> scores = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("blackjack v0.75");
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("what do you want  to do \n 1 for game \n 2 for scores \n 3 for exit");
			String s = scn.nextLine();
			menu(s, scn);
			
			scn.close();
		}

	}

	public static int dice() {
		Random rnd = new Random();
		int los = rnd.nextInt(5) + 1;
		return los;
	}

	public static void start(Scanner scn) {

		int result = 0;
		while (true) {
			int Throw = dice();
			if (result < 15) {
				System.out.println("hit enter for next throw");
				scn.nextLine();
				System.out.println(Throw);
				result = result + Throw;
				System.out.println("you result " + result);

			} else if (result >= 15) {
				System.out.println("do you want to throw again: y/n");
				String s = scn.nextLine();

				if (s.equals("Y") || s.equals("y")) {
					System.out.println("rzut " + Throw);
					result = result + Throw;
					System.out.println("you result " + result);

				}

				else if (s.equals("n") || s.equals("N")) {
					System.out.println("your result " + result);
					scores.add(result);
					result = 0;
					System.out
							.println("Do you want to play again or see your scores \n 1 for new game \n 2 for sccores");
					s = scn.nextLine();
					switch (s) {
					case "1": {
						System.out.println("-------new game------");
						break;
					}
					case "2": {
						show(scores);
						System.out.println("----new game -----");
						break;
					}
					}
				}

			}

			if (result > 21) {
				System.out.println("you have lost");
				newGame(scn, result);
				scores.add(result);
				result = 0;
			}
			if (result == 21) {
				System.out.println("you have won");
				{
					newGame(scn, result);
					scores.add(result);
					result = 0;
				}
			}
		}

	}

	public static void newGame(Scanner scn, int result) {
		System.out.println("do you want to play again? y/n");
		String answer = scn.nextLine();
		if (answer.equals("y") || answer.equals("Y")) {
		} else if (answer.equals("n") || answer.equals("N")) {
			System.out.println("your result is " + result);
			System.exit(0);
		}

	}

	public static void show(List<Integer> list) {
		for (Integer i : list) {
			System.out.println("wynik " + i);
		}

	}

	public static  void menu(String s, Scanner scn){
		if(s.equals("1")){
			start(scn);
		} else if(s.equals("2")) {
			show(scores);
		} else if(s.equals("3")){
			System.exit(0);
		}
	}
	
	
}
