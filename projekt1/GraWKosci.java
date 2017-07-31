package projekt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GraWKosci {

	public static void main(String[] args) {

		System.out.println("GRA w Kosci v.0.5");
		Scanner scn = new Scanner(System.in);
		int[] gracz1 = new int[6];
		int[] gracz2 = new int[6];

		for (int i = 0; i < 6; i++) {
			// System.out.print("nacisnij enter aby rzucic koscia");
			// scn.nextLine();
			gracz1[i] = kosc();
			// System.out.print(kosc() + " ");
		}

		System.out.println();
		for (int i = 0; i < 6; i++) {
			// System.out.print("nacisnij enter aby rzucic koscia");
			// scn.nextLine();
			gracz2[i] = kosc();
			// System.out.print(kosc() + " ");
		}

		Arrays.sort(gracz1);
		Arrays.sort(gracz2);
		System.out.println("Rzuca gracz n1");
		System.out.println(Arrays.toString(gracz1));
		System.out.println("Rzuca gracz n2");
		System.out.println(Arrays.toString(gracz2));
		System.out.println("");

		System.out.println("Gracz nr 1 ile kosci chcesz wymienic");

		int ile = scn.nextInt();
		int ktore[] = new int[ile];
		for (int i = 0; i < ile; i++) {
			System.out.println("które kości chceszs wymienic");
			ktore[i] = scn.nextInt() - 1;
		}

		for (int i = 0; i < ktore.length; i++) {
			for (int j = 0; j < gracz1.length; j++) {
				if (ktore[i] == j) {
					gracz1[j] = kosc();
					break;
				}
			}
		}

		System.out.println("Gracz nr 2 ile kosci chcesz wymienic");
		int ile2 = scn.nextInt();
		int ktore2[] = new int[ile2];
		for (int i = 0; i < ile2; i++) {
			System.out.println("które kości chceszs wymienic");
			ktore2[i] = scn.nextInt() - 1;
		}

		for (int i = 0; i < ktore2.length; i++) {
			for (int j = 0; j < gracz2.length; j++) {
				if (ktore2[i] == j) {
					gracz2[j] = kosc();
					break;
				}
			}
		}
		System.out.println(Arrays.toString(gracz1));
		System.out.println(Arrays.toString(gracz2));

		String g1 = sprawdzenie(gracz1);
		String g2 = sprawdzenie(gracz2);

		System.out.println("gracz 1 trafil " + g1);
		System.out.println("gracz 2 trafil " + g2);
		scn.close();
	}

	public static void wynik() {
	}

	public static int kosc() {
		Random rnd = new Random();
		int los = rnd.nextInt(5) + 1;
		return los;
	}

	public static String sprawdzenie(int[] arr) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (counterMap.containsKey(arr[i])) {
				counterMap.put(arr[i], counterMap.get(arr[i]) + 1);
			} else {
				counterMap.put(arr[i], 1);
			}
		}
		Collection<Integer> lista = new ArrayList<>();
		lista = counterMap.values();
		String str = lista.toString();
		String str2 = "";
		if (str.contains("1") && str.contains("1") && str.contains("1") && str.contains("1")
				&& str.contains("1") == true) {
			str2 = "strit";
		} else if (str.contains("2") && str.contains("2") == true) {
			str2 = "dwie 2";
		} else if (str.contains("2") && str.contains("3") == true) {
			str2 = "full";
		} else if (str.contains("3") == true) {
			str2 = "3";
		} else if (str.contains("4") == true) {
			str2 = "karet";
		} else if (str.contains("6") == true) {
			str2 = "poker";
		} else if (str.contains("2") == true) {
			str2 = "2";
		}
		return str2;
	}

}
