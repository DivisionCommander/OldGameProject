package game.demos;

import characters.*;
import characters.playerclasses.*;
import exceptions.SomethingGoesWrongException;

public final class ClassDemo {

	public static void main(String[] args) {
		try {
			PlayerCharacter avhia = new Sage("Avhia", false);
			PlayerCharacter blindguard = new Magician("BlindGuard", false);
			PlayerCharacter deneira = new Stranger("Deneira", false);
			PlayerCharacter sturmfuhrer = new Warrior("Strurmfuher", true);
//			avhia.printCharacterStats();
//			blindguard.printCharacterStats();
			blindguard.printCharacterInfo();
			System.out.println();
			blindguard.levelUp();
//			blindguard.printCharacterStats();
//			deneira.printCharacterStats();
//			sturmfuhrer.printCharacterStats();
			
		} catch (SomethingGoesWrongException e) {
			System.err.println("Somethings Goes Very Wrong");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Zmiiski butcheta i jabeshki kriltsa!");
		}
	}

}
