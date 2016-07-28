package characters;

import exceptions.*;

public abstract class IngameCharacter {

	private static final String UNDEFINED = "Undefined";
	private static final String FEMALE = "Female";
	private static final String MALE = "Male";

	private static final String STRING_MONSTER = "Monster: ";
	private static final boolean MONSTER = false;
	private static final String STRING_PLAYER = "Player: ";
	private static final boolean PLAYER = true;

	private final String name;
	private final ClassInGame charClass;
	protected String title;
	private final boolean isPlayerCharacter;
	private final boolean isMale;

	// Basic Hit points per class before apply bonuses of equipment and skills;
	private int maximumHitPoints;
	int currentHitPoints;

	// Basic Mana Points per class before apply bonuses of equipment and skills;
	private int maximumManaPoints;
	int currentManaPoints;

	// Current experience points of character // basic experience points
	// rewarded for killing this mob;
	private long experience;

	// Current level of character
	private int level;

	// Basic constructor; will be switched to protected soon;
	public IngameCharacter(String name, ClassInGame classname, boolean isPlayer, boolean isMale, int health, int mana,
			int level, long exp) throws SomethingGoesWrongException {
		this.charClass = classname;
		try {
			// Is player;
			if (isPlayer) {
				this.isPlayerCharacter = PLAYER;
				if ((name == null) || (name.equals("") || name.contains(" ")) || (name.length() < 3)) {
					throw new InvalidCharNameException("Wrong character name");
				}
				if (!classname.canBePlayer()) {
					throw new InvalidPlayerException("Choose correct class for player");
				}
				if (health < level) {
					throw new InvalidHeathException("Incorrect player Vitality inserted");
				}
				if (mana < level) {
					throw new InvalidManaException("Incorrect player Intellect inserted");
				}

				this.name = name;
				this.maximumHitPoints = this.calculateMaxHitPoints(health);
				this.maximumManaPoints = this.calculateMaxManaPoints(mana);

				// Is non-player Character;
			} else {
				this.isPlayerCharacter = MONSTER;
				if ((name == null) || (name.equals(""))) {
					this.name = "Just a mob";
				} else {
					this.name = name;
				}
				if (health <= 0) {
					throw new InvalidHeathException("Negative or zero NPC health!");
				}
				if (mana < 0) {
					throw new InvalidManaException("Negative NPC mana!");
				}
				this.maximumHitPoints = health;
				this.maximumManaPoints = mana;
				this.level = level;
			}
			if (level <= 0) {
				throw new InvalidLevelException("Negative or zero Character level! ");
			}
			if (exp < 0) {
				throw new InvalidExperienceException("Negative charracter Experience!");
			}
			this.experience = exp;
		} catch (SomethingGoesWrongException e) {
			e.printStackTrace();
			throw new SomethingGoesWrongException("Incorrect parameters for new character.");
		}
		this.isMale = isMale;
		this.level = level;
		this.currentHitPoints = maximumHitPoints;
		this.currentManaPoints = maximumManaPoints;
	}

	private int calculateMaxHitPoints(int vitality) {
		double vitalityToHPCoeffitient = this.charClass.getVitalityToHealth();
		return (int) (vitality * vitalityToHPCoeffitient);
	}

	private int calculateMaxManaPoints(int intelect) {
		double intellectToManaCoeffitient = this.charClass.getIntellectToMana();

		return (int) (intelect * intellectToManaCoeffitient);

	}

	protected void levelUp(int newVitality, int newIntellect) throws SomethingGoesWrongException {
		try {

			if (isPlayerCharacter) {
				level++;
				if (newVitality > 0) {
					double coeffitinetHp = ((double) this.currentHitPoints) / ((double) this.maximumHitPoints);
					this.maximumHitPoints = calculateMaxHitPoints(newVitality);
					this.currentHitPoints = (int) (this.maximumHitPoints * coeffitinetHp);
				} else {
					throw new InvalidHeathException("Incorrect Vitality!");
				}
				if (newIntellect > 0) {
					double coeffitientMana = ((double) this.currentManaPoints) / ((double) this.maximumManaPoints);
					this.maximumManaPoints = calculateMaxManaPoints(newIntellect);
					this.currentManaPoints = (int) (this.maximumManaPoints * coeffitientMana);
				} else {
					throw new InvalidManaException("Incorrect Intellect");
				}
			} else {
				throw new InvalidPlayerException("Monsters cannot Level Up!");
			}
		} catch (InvalidPlayerException e) {
			throw new SomethingGoesWrongException("Leveling on monster!");
		} catch (SomethingGoesWrongException e) {
			throw new SomethingGoesWrongException("Wrong Level up! data.");
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void printCharacterInfo() {
		System.out.println("\t" + getKind() + ": " + this.getCharacterName());
		System.out.println("\tLevel " + this.getCharacterLevel() + " " + this.getClassName());
		System.out.println("Experience: " + this.experience);
		System.out.println("Hit Points: " + this.currentHitPoints + "/" + this.maximumHitPoints);
		System.out.println("Mana:" + this.currentManaPoints + "/" + this.maximumManaPoints);
	}

	protected String getKind() {
		if (this.isPlayerCharacter == PLAYER) {
			return STRING_PLAYER;
		} else {
			return STRING_MONSTER;
		}
	}

	protected String getCharacterName() {
		return this.name;
	}

	protected int getCharacterLevel() {
		return this.level;
	}

	protected ClassInGame getCharacterClass() {
		return this.charClass;
	}

	protected String getClassName(){
		return this.charClass.toString(isMale);
	}
	
	protected boolean isMale() {
		return this.isMale;
	}

	protected String getCharacterSex() {
		if (this.charClass.equals(ClassInGame.UNDEFINED)) {
			return UNDEFINED;
		}
		if (isMale) {
			return MALE;
		} else {
			return FEMALE;
		}
	}
}
