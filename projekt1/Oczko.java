package projekt1;

import java.util.Random;
import java.util.Scanner;

public class Oczko {

	
	public static void main(String[] args){
	
		System.out.println("oczko v0.5");
		
		int oczko = 21;
		int wynik =0;
		Scanner scn = new Scanner(System.in);
		
		do{
			System.out.println("nacisnij eneter aby rzucic");
			scn.nextLine();
			int rzut = kosc();
			System.out.println(rzut);
			wynik = wynik+rzut;
			if(wynik>=15){
				System.out.println("czy chcesz dodac swoj rzut: T/N");
				String s = scn.nextLine();
				if(s.equals("T")){
					wynik = wynik + rzut;
				}else if (s.equals("N")){
					//System.out.println("twoj wynik " + wynik);
					wynik = wynik - rzut;
					break;
				}
			} else {
				//wynik = wynik+rzut;
			}
			System.out.println("twoj wynik "+wynik);
			if(wynik>21){
				System.out.println("przegrałes");
				break;
			}
		}while(wynik!=oczko);
		
		if(wynik == oczko){
		System.out.println("wygrales");}
		else {
			System.out.println("twoj wynik to "+ wynik);
		}
		scn.close();
	}
	public static int kosc() {
		Random rnd = new Random();
		int los = rnd.nextInt(5) + 1;
		return los;
	}
}
