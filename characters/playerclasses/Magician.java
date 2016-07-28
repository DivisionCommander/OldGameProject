package characters.playerclasses;

import characters.ClassInGame;
import characters.PlayerCharacter;
import exceptions.SomethingGoesWrongException;

public class Magician extends PlayerCharacter {
	private static final int DEFAULT_STRENGTH = 6;
	private static final int DEFAULT_DEXTERITY = 6;
	private static final int DEFAULT_SWIFTNESS = 9;
	private static final int DEFAULT_VITALITY = 10;
	private static final int DEFAULT_STAMINA = 10;
	private static final int DEFAULT_WILLPOWER = 13;
	private static final int DEFAULT_INTELLECT = 20;
	private static final int DEFAULT_WISDOM = 18;
	private static final int DEFAULT_MINDPOWER = 18;
	private static final int DEFAULT_SPIRIT = 15;

	private static final int[] DEFAULT_STATS = { DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_SWIFTNESS,
			DEFAULT_VITALITY, DEFAULT_STAMINA, DEFAULT_WILLPOWER, DEFAULT_INTELLECT, DEFAULT_WISDOM, DEFAULT_MINDPOWER,
			DEFAULT_SPIRIT };

	private static final ClassInGame CHARACTER_CLASS = ClassInGame.MAGICIAN;

	public Magician(String name, boolean isMale) throws SomethingGoesWrongException {
		super(name, isMale, DEFAULT_STATS, CHARACTER_CLASS);
	}
}
