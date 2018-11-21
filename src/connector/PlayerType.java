package connector;

public enum PlayerType {
	NORMAL (""),
	IRONMAN ("ironman"),
	ULTIMATE_IRONMAN ("ultimate"),
	HARDCORE_IRONMAN ("hardcore_ironman"),
	DEADMAN ("deadman"),
	SEASONAL ("seasonal");

	private String tag;

	PlayerType (String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}
}
