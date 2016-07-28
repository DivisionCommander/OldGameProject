package characters.playerclasses;

import characters.*;
import exceptions.SomethingGoesWrongException;

public class Warrior extends PlayerCharacter {

	private static final ClassInGame CHARACTER_CLASS = ClassInGame.WARRIOR;

	private static final int DEFAULT_STRENGTH = 20;
	private static final int DEFAULT_DEXTERITY = 16;
	private static final int DEFAULT_SWIFTNESS = 16;
	private static final int DEFAULT_VITALITY = 20;
	private static final int DEFAULT_STAMINA = 19;
	private static final int DEFAULT_WILLPOWER = 11;
	private static final int DEFAULT_INTELLECT = 6;
	private static final int DEFAULT_WISDOM = 6;
	private static final int DEFAULT_MINDPOWER = 5;
	private static final int DEFAULT_SPIRIT = 6;

	private static final int[] DEFAULT_STATS = { DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_SWIFTNESS,
			DEFAULT_VITALITY, DEFAULT_STAMINA, DEFAULT_WILLPOWER, DEFAULT_INTELLECT, DEFAULT_WISDOM, DEFAULT_MINDPOWER,
			DEFAULT_SPIRIT };

	public Warrior(String name, boolean isMale) throws SomethingGoesWrongException {
		super(name, isMale, DEFAULT_STATS, CHARACTER_CLASS);
	}

}
