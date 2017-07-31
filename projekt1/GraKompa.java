package projekt1;

import java.util.Random;
import java.util.Scanner;

public class GraKompa {

	static final String LESS = "mniej";
	static final String MORE = "wiecej";
	//static final String EXIT = "exit";
	static final String GUESSED = "zgadles";
	public static void main(String[] args) {
		System.out.println("wpisz liczbę od 1 do 1000 a komputer zgodnie z twoją pomoca");
		Scanner scn = new Scanner(System.in);
		int number = 0;
		boolean zombie = true;
		do {
			while (!scn.hasNextInt()) {
				scn.next();
				System.out.println("podaj jeszcze raz");
			}
			number = scn.nextInt();
			if (number > 1000) {
				System.out.println("podana liczba jest za duza");
			} else if (number < 1) {
				System.out.println("podana liczba jest za mala");
			} else {
				zombie = false;
			}
		} while (zombie == true);

		//System.out.println(liczba);

		String wyb = "";
		Random random = new Random();
		int losowana = random.nextInt(999) + 1;
		boolean flag = true;
		System.out.println("wpisz mniej aby komputer wybrał mniejsza liczbe");
		System.out.println("wpisz więcej aby komputer wybrał wieksza liczbe");
		System.out.println("jezeli zgadlem wpisz zgadles");
		System.out.println();
		int min = 1;
		int max = 1000;
		int guess =losowana;
		int count =0;
		System.out.println("moja liczba "+guess);
		do {
			wyb = scn.nextLine();
			count++;
			switch (wyb) {
			case (LESS):
						max=guess;
						guess = ((max -min)/2)+min;
						System.out.println("wylosowana liczba "+guess);
						break;
			case (MORE):
						min=guess;
						guess = ((max-min)/2)+min;
						System.out.println("wylosowana liczba "+guess);
						break;
			case(GUESSED):
						flag=false;
						System.out.println("zgadles w "+count+" probach");
						break;
			default:
				System.out.println("wpisz mniej lub wiecej, ewentualnie zgadles");
			}

		} while (true==flag);
		scn.close();
	}

}
