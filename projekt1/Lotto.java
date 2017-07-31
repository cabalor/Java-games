package projekt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {

		int[] drawn = draw();
		System.out.println(Arrays.toString(drawn));

		System.out.println("wprowadz liczbe z zakresu od 1 do 49 i wcisnij enter");
		int[] numbers = new int[6];
		int bet = 0;
		List<Integer> hits = new ArrayList<Integer>();
		Scanner scn = new Scanner(System.in);
		do {
			while (!scn.hasNextInt()) {
				scn.next();
				System.out.println("nie wpisuj liter");
			}
			int num1 = scn.nextInt();
			if (num1 <= 0) {
				System.out.println("wprowadz liczbe wieksza od zera ale wieksza od 49");
			} else if (num1 > 49) {
				System.out.println("wprowadz liczbę mniejsza od 49");
			} else {
				if (checked(numbers, num1) == true) {
					System.out.println("powtarzasz liczbe");
				} else {
					numbers[bet] = num1;
					bet++;
				}
				System.out.println("wprowadz kolejna liczbe");
			}
		} while (bet != 6);
		System.out.println(Arrays.toString(numbers));
		int count = 0;
		scn.close();
		for (int i = 0; i < drawn.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (drawn[i] == numbers[j]) {
					count++;
					hits.add(drawn[i]);
					break;
				}
			}
		}
		if (count == 3) {
			System.out.println("trafiłes 3 " + hits.toString());
		} else if (count == 4) {
			System.out.println("trafiles 4 " + hits.toString());
		} else if (count == 5) {
			System.out.println("trafiles 5 " + hits.toString());
		} else if (count == 6) {
			System.out.println("trafiles 6 " + hits.toString());
		} else {
			System.out.println("trafiles 2 lub mniej liczb");
		}
	}

	public static int[] draw() {
		List<Integer> lista = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i <= 5; i++) {
			int num = rnd.nextInt(48) + 1;
			if (!lista.contains(num)) {
				lista.add(num);
			}
		}
		// Integer[] wylosowane = lista.toArray(new Integer[lista.size()]);
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = lista.get(i);
		}
		return arr;
	}

	public static boolean checked(int[] arry, int val) {
		boolean flag = false;
		for (int s : arry) {
			if (s == val) {
				flag = true;
			}
		}
		return flag;
	}

}
