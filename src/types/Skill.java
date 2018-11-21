package types;

public enum Skill {
	OVERALL (0, "Total"),
	ATTACK (1, "Attack"),
	DEFENCE (2, "Defence"),
	STRENGTH (3, "Strength"),
	HITPOINTS (4, "Hitpoints"),
	RANGED (5, "Ranged"),
	PRAYER (6, "Prayer"),
	MAGIC (7, "Magic"),
	COOKING (8, "Cooking"),
	WOODCUTTING (9, "Woodcutting"),
	FLETCHING (10, "Fletching"),
	FISHING (11, "Fishing"),
	FIREMAKING (12, "Firemaking"),
	CRAFTING (13, "Crafting"),
	SMITHING (14, "Smithing"),
	MINING (15, "Mining"),
	HERBLORE (16, "Herblore"),
	AGILITY (17, "Agility"),
	THIEVING (18, "Thieving"),
	SLAYER (19, "Slayer"),
	FARMING (20, "Farming"),
	RUNECRAFTING (21, "Runecrafting"),
	HUNTER (22, "Hunter"),
	CONSTRUCTION (23, "Construction");

	private int index;
	private String name;

	Skill (int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return this.index;
	}

	public String getName() {
		return this.name;
	}
}
