package characters.playerclasses;

import characters.*;
import exceptions.SomethingGoesWrongException;

public class Sage extends PlayerCharacter {
	
	
	private static final ClassInGame CHARACTER_CLASS = ClassInGame.SAGE;
	private static final int DEFAULT_STRENGTH = 8;
	private static final int DEFAULT_DEXTERITY = 10;
	private static final int DEFAULT_SWIFTNESS = 11;
	private static final int DEFAULT_VITALITY = 13;
	private static final int DEFAULT_STAMINA = 15;
	private static final int DEFAULT_WILLPOWER = 19;
	private static final int DEFAULT_INTELLECT = 13;
	private static final int DEFAULT_WISDOM = 15;
	private static final int DEFAULT_MINDPOWER = 8;
	private static final int DEFAULT_SPIRIT = 13;

	private static final int[] DEFAULT_STATS = { DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_SWIFTNESS,
			DEFAULT_VITALITY, DEFAULT_STAMINA, DEFAULT_WILLPOWER, DEFAULT_INTELLECT, DEFAULT_WISDOM, DEFAULT_MINDPOWER,
			DEFAULT_SPIRIT };

	public Sage(String name, boolean isMale) throws SomethingGoesWrongException {
		super(name, isMale, DEFAULT_STATS, CHARACTER_CLASS);
	}
}
