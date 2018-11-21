package connectors;

import types.PlayerType;
import types.Skill;
import util.GetRequest;

import java.io.IOException;

public class HighScoreConnector {
	private static final String API_BASE_URL = "http://services.runescape.com/m=hiscore_oldschool";

	public static String getPlayerStats (String username, PlayerType playerType) {

		GetRequest playerConnector = new GetRequest(createHighScoreUrl(playerType, username));

		try {
			String content = playerConnector.execute();
			return parseHighScoreResponse(content);
		} catch (IOException e) {
			return "User not found or server not reachable.";
		}
	}

	private static String createHighScoreUrl (PlayerType playerType, String username) {
		String queryParam = playerType == PlayerType.NORMAL ? "" : "_" + playerType.getTag();

		return HighScoreConnector.API_BASE_URL + queryParam + "/index_lite.ws?player=" + username;
	}

	private static String parseHighScoreResponse (String response) {
		String[] skillsData = response.split(",");

		StringBuilder formatted = new StringBuilder();

		for (Skill skill: Skill.values()) {
			formatted.append(skill.getName()).append(": ");
			formatted.append(skillsData[(skill.getIndex() * 2) + 1]);
			formatted.append("\n");
		}

		return formatted.toString();
	}
}