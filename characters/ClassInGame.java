package characters;

public enum ClassInGame {

	// Undefined;
	UNDEFINED(0, false, "UNDEFINED", "UNDEFINED"),

	// Basic classes:
	MAGICIAN(100, true, "Mage", "Magie", 9.8, 11.5), SAGE(200, true, "Sage", 10, 10.5),
	// Basic classes;
	STRANGER(300, true, "Stranger", 10.5, 10), WARRIOR(400, true, "Warrior", 11.5, 9.8),

	// Advanced classes:

	// Mage Sub-classes:
	SORCERER(110, true, "Sorcerer", "Sorceress", 9.8, 11.5), WARLOCK(120, true, "Warlock", 9.8, 11.5),
	// Sorcerer Sub-classes:
	WIZARD(111, true, "Wizard", 9.8, 11.5), ARCHMAGE(112, true, "Arch Mage", "Arch Magie", 9.8, 11.5),
	// Warlock Sub-classes:
	NECROMANCER(121, true, "Necromancer", "Necromanceress", 9.8, 11.5),
	// Soul Link?
	DEMONOMASTER(122, true, "Demon Master", "Demon Mistress", 9.8, 11.5),

	// Sage Sub-classes:
	MONK(210, true, "Monk", "Nun", 10, 10.5), HERMIT(220, true, "Hermit", 10, 10.5),
	// Monk Sub-classes:
	PRIEST(211, true, "Priest", "Priestess", 10, 10.5), ZEALOT(212, true, "Zealot", 10, 10.5),
	// Hermit Sub-classes
	SHAMAN(221, true, "Shaman", 10, 10.5), BATTLEHERMIT(222, true, "Battle Hermit", 10, 10.5),

	// Stranger Sub-classes:
	BARBARIAN(310, true, "Barbarian", 10.5, 10), HUNTER(320, true, "Hunter", "Huntress", 10.5, 10),
	// Barbarian Sub-classes:
	RAIDER(311, true, "Raider", 10.5, 10), BERSERKER(312, true, "Berserker", 10.5, 10),
	// Hunter sub-classes:
	RANGER(321, true, "Ranger", 10.5, 10), TRAPPER(322, true, "Trapper", 10.5, 10),

	// Warrior Sub-classes:
	SOLDIER(410, true, "Soldier", 11.5, 9.8), ARCHER(420, true, "Archer", 11.5, 9.8),
	// Soldier Sub-classes:
	KNIGHT(411, true, "Knight", "Lady", 11.5, 9.8), MARAUDER(412, true, "Marauder", 11.5, 9.8),
	// Archer Sub-classes:
	MARKSMAN(421, true, "Marskman", "Markswoman", 11.5, 9.8), BARRAGER(422, true, "Barrager", 11.5, 9.8),

	// Non-player classes;
	PALADIN(1000, false, "Paladin", 14, 14),

	// WITCH(1100, false, "Witcher", "Witch", 10, 15),
	// BATTLEMAGE(1300, false, "Battle Mage", "Battle Magie",12, 12),
	// DRUID(1400, false, "Druid", 12, 12)
	;

	private boolean canBeAPlayer;
	private int indexOfClass;
	private String male;
	private String female;
	private double vitalityToHealth;
	private double intellectToMana;

	private ClassInGame(int index, boolean canBeAPlayer) {
		this.indexOfClass = index;
		this.canBeAPlayer = canBeAPlayer;
		this.intellectToMana = 10.00;
		this.vitalityToHealth = 10.00;
	}

	private ClassInGame(int index, boolean canBeAPlayer, String male) {
		this(index, canBeAPlayer);
		this.male = male;
		this.female = male;
		this.vitalityToHealth = 10.00;
		this.intellectToMana = 10.00;
	}

	private ClassInGame(int index, boolean canBeAPlayer, String male, String female) {
		this(index, canBeAPlayer, male);
		this.female = female;
	}

	private ClassInGame(int index, boolean canBeAPlayer, String male, double healthMod, double manaMod) {
		this(index, canBeAPlayer, male);
		this.setModificators(healthMod, manaMod);
	}

	private ClassInGame(int index, boolean canBeAPlayer, String male, String female, double healthMod, double manaMod) {
		this(index, canBeAPlayer, male, female);
		this.setModificators(healthMod, manaMod);

	}

	public int getClassIndex() {
		return this.indexOfClass;
	}

	public boolean canBePlayer() {
		return canBeAPlayer;
	}

	private void setModificators(double healthMod, double manaMod) {
		this.vitalityToHealth = healthMod;
		this.intellectToMana = manaMod;

	}

	public double getVitalityToHealth() {
		return this.vitalityToHealth;
	}

	public double getIntellectToMana() {
		return this.intellectToMana;
	}

	@Override
	public String toString() {
		String name = super.toString();
		if (this.male == null) {
			char firstChar = name.charAt(0);
			name = firstChar + ((name.substring(1, name.length())).toLowerCase());
		} else {
			name = this.male;
		}
		return name;
	}

	public String toString(boolean isMale) {
		if (isMale) {
			return this.male;
		} else {
			return this.female;
		}

	}

}
