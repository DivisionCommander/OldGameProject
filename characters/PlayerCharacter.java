package characters;

import java.util.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import exceptions.*;

public abstract class PlayerCharacter extends IngameCharacter {

	private static final String CHARACTER_INFO = "%s %s:%s %d";
	private static final int POINTS_AT_LEVEL_UP = 12;
	private static final String PLAYER_HAS_LEVEL_UP = "Player %s has reached %d!\nHit Points %d / %d \nMana Points %d / %d ";
	public static final int INDEX_OF_STENGTH = 0;
	public static final int INDEX_OF_VITALITY = 3;
	public static final int INDEX_OF_INTELLECT = 5;

	private static final String BASIC = "Basic";
	private static final int NUMBER_OF_STATS = 10;
	private static final int STARTING_LEVEL = 1;
	private static final long START_EXPERIENCE = 0l;
	private static final boolean IS_PLAYER = true;

	private int modifiedMaxHitPoints;
	private int modifiedCurrentHitPoints;

	private int modifiedMaxManaPoints;
	private int modifiedCurrentManaPoints;

	private int[] basicStats;
	private int[] realStats;
	public static final String[] STATST_NAMES = { "Strength", "Dexterity", "Swiftness", "Vitality", "Stamina",
			"Will Power", "Intellect", "Wisdom", "Mind Power", "Spirit" };

	public PlayerCharacter(String name, boolean isMale, int[] defaultStats, ClassInGame playerClass)
			throws SomethingGoesWrongException {
		super(name, playerClass, IS_PLAYER, isMale, defaultStats[INDEX_OF_VITALITY], defaultStats[INDEX_OF_INTELLECT],
				STARTING_LEVEL, START_EXPERIENCE);
		this.basicStats = Arrays.copyOf(defaultStats, defaultStats.length);
		this.realStats = Arrays.copyOf(basicStats, basicStats.length);
	}

	public void printCharacterStats() {
		for (int index = 0; index < NUMBER_OF_STATS; index++) {
			String whitespace = " ";
			int countOfWhiteSpace = 15;
			if (basicStats[index] < 10) {
				countOfWhiteSpace++;
			}
			for (int indexOfChars = STATST_NAMES[index].length(); indexOfChars < countOfWhiteSpace; indexOfChars++) {
				whitespace += " ";
			}
			String info = String.format(CHARACTER_INFO, BASIC, STATST_NAMES[index], whitespace, this.basicStats[index]);
			System.out.print(info);
			System.out.println();
		}

	}

	public void levelUp() throws SomethingGoesWrongException {
		this.levelUpPoints();
		super.levelUp(basicStats[INDEX_OF_VITALITY], basicStats[INDEX_OF_INTELLECT]);
		this.calculatePoints();
		String levelUp = String.format(PLAYER_HAS_LEVEL_UP, super.getCharacterName(), super.getCharacterLevel(),
				this.modifiedCurrentHitPoints, this.modifiedMaxHitPoints, this.modifiedCurrentManaPoints,
				this.modifiedMaxManaPoints);
		System.out.println(levelUp);
	}

	public void calculatePoints() {
		ClassInGame charClass = super.getCharacterClass();
		this.modifiedMaxHitPoints = (int) (charClass.getVitalityToHealth() * this.realStats[INDEX_OF_VITALITY]);
		this.modifiedMaxManaPoints = (int) (charClass.getIntellectToMana() * this.realStats[INDEX_OF_INTELLECT]);
		this.modifiedCurrentHitPoints = this.modifiedMaxHitPoints;
		this.modifiedCurrentManaPoints = this.modifiedMaxManaPoints;
	}

	private void levelUpPoints() throws SomethingGoesWrongException {
		try {
			int pointsToSpend = POINTS_AT_LEVEL_UP;
			Scanner scanner = new Scanner(System.in);
			do {
				if (pointsToSpend == 0) {
					break;
				}
				for (int index = 0; index < NUMBER_OF_STATS; index++) {
					if (pointsToSpend == 0) {
						break;
					}

					if (pointsToSpend < 0) {
						throw new InvalidStatPointException("Negative count of points to spend!");
					}
					String whitespace = " ";
					int countOfWhiteSpace = 10;
					for (int indexOfChars = STATST_NAMES[index]
							.length(); indexOfChars < countOfWhiteSpace; indexOfChars++) {
						whitespace += " ";
					}
					String text = String.format("%s %s Basic %d, Modified %d\tPoints to spend left:%d",
							STATST_NAMES[index], whitespace, basicStats[index], realStats[index], pointsToSpend);
					System.out.print(text);
					String text2 = String.format("\nAdd points to %s:", STATST_NAMES[index]);
					System.out.print(text2);
					int spendedPoints = scanner.nextInt();
					this.addPoints(index, spendedPoints);
					pointsToSpend -= spendedPoints;
				}
				System.out.println();
			} while (true);
		} catch (InvalidStatPointException e) {
			throw new SomethingGoesWrongException("Zmiiski krilca");

		}
	}

	private void addPoints(int indexOfPoint, int point) throws SomethingGoesWrongException {
		try {
			if (point < 0) {
				throw new InvalidStatPointException("Negative point");
			}
			if ((indexOfPoint < 0) || (indexOfPoint >= NUMBER_OF_STATS)) {
				throw new InvalidStatPointException("Incorrect index of point!");
			}
		} catch (InvalidStatPointException e) {
			throw new SomethingGoesWrongException();
		}
		this.basicStats[indexOfPoint] += point;
		this.realStats[indexOfPoint] += point;
		if ((indexOfPoint == INDEX_OF_VITALITY) || (indexOfPoint == INDEX_OF_INTELLECT)) {
			this.calculatePoints();
		}
	}
}
