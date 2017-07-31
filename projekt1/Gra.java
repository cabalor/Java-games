package projekt1;

import java.util.Random;
import java.util.Scanner;

public class Gra {

	public static void main(String[] args) {

		Random rd = new Random();
		int random = rd.nextInt(101);
		Scanner scn = new Scanner(System.in);
		int number = 0;
		System.out.println("zgadnij liczbe");
		boolean flag = true;
		do {

			while (!scn.hasNextInt()) {
				scn.next();
				System.out.println("podaj jeszcze raz");
			}
			number = scn.nextInt();

			if (number > random) {
				System.out.println("podana liczba za duza");
			} else if (number < random) {
				System.out.println("podana liczba za mala");
			} else {
				System.out.println("zgadeles liczbe, była to liczba " + number);
				flag = false;
			}
		} while (flag ==true);
		scn.close();
	}
}


