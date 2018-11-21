package connectors;

import types.PlayerType;
import types.Skill;
import util.GetRequest;

public class HighScoreConnector {
	private static final String API_BASE_URL = "http://services.runescape.com/m=hiscore_oldschool";

	public static String getPlayerStats (String username, PlayerType playerType) {

		GetRequest playerConnector = new GetRequest(createHighScoreUrl(playerType, username));
		String content = playerConnector.get();

		return parseHighScoreResponse(content);
	}

	private static String createHighScoreUrl (PlayerType playerType, String username) {
		String queryParam = playerType == PlayerType.NORMAL ? "" : "_" + playerType.getTag();

		return HighScoreConnector.API_BASE_URL + queryParam + "/index_lite.ws?player=" + username;
	}

	private static String parseHighScoreResponse (String response) {
		String[] skillsData = response.split(",");

		String formatted = "";

		// TODO: Replace with Stringbuffer or something else for efficiency
		for (Skill skill: Skill.values()) {
			formatted += skill.getName() + ": ";
			formatted += skillsData[(skill.getIndex() * 2) + 1];
			formatted += "\n";
		}

		return formatted;
	}
}