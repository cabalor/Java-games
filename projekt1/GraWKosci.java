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

		System.out.println("GRA w Kosci v.0.7");
		Scanner scn = new Scanner(System.in);
		game(scn);
		scn.close();
	}

	
	
	public static void game(Scanner scn){
		
		while(true){
		int[] gracz1 = new int[6];
		int[] gracz2 = new int[6];

		for (int i = 0; i < 6; i++) {
			gracz1[i] = kosc();
		}

		System.out.println();
		for (int i = 0; i < 6; i++) {
			gracz2[i] = kosc();
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
		Arrays.sort(gracz1);
		Arrays.sort(gracz2);
		System.out.println("wynik rzutow pierwszego gracza "+Arrays.toString(gracz1)+"\n");
		System.out.println("wynik rzutow drugiego gracza "+Arrays.toString(gracz2)+"\n");

		String g1 = sprawdzenie(gracz1);
		String g2 = sprawdzenie(gracz2);

		System.out.println("gracz 1 trafil " + g1);
		System.out.println("gracz 2 trafil " + g2);
		System.out.println("do you want to play again? y/n");
		scn.nextLine();
		String answer = scn.nextLine();
		if(answer.equals("y")||answer.equals("Y")){
			System.out.println("new game");
		} else if (answer.equals("n")||answer.equals("N")){
			System.out.println("end");
			System.exit(0);
		}
		
		}
		
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
		Collection<Integer> lista2 = new ArrayList<>();
		lista = counterMap.values();
		lista2 = counterMap.keySet();
		String str = lista.toString();
		String str3 = lista2.toString();
		String str2 = "";
		
		if (str3.contains("1") && str3.contains("2") && str3.contains("3") && str3.contains("4")
				&& str3.contains("5")== true) {
			str2 = "maly strit";
		} else if(str3.contains("2") && str3.contains("3") && str3.contains("4") && str3.contains("5")
				&& str3.contains("6")== true){
			str2 = "duzy strit";
		} 
		
		else if (str.contains("2") && str.contains("3") == true) {
			str2 = "full";
		} else if (str.contains("3") == true) {
			str2 = "3";
		} else if (str.contains("4") == true) {
			str2 = "kareta";
		} else if (str.contains("6") == true) {
			str2 = "poker";
		} else if(str.contains("2") && str.contains("2") == true){
			str2 = "dwie 2";
		} else if (str.contains("2") == true) {
			str2 = "2";
		}
		return str2;
	}
	
	public static void newGame(Scanner scn){
		System.out.println("do you want to play again? y/n");
		String answer = scn.nextLine();
		if(answer.equals("y")||answer.equals("Y")){
			System.out.println("new game");
		} else if (answer.equals("n")||answer.equals("N")){
			System.out.println("end");
			System.exit(0);
		}
		
	}
	
}
