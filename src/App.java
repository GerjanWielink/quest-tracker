import connectors.HighScoreConnector;
import types.PlayerType;

import java.io.IOException;

public class App {
	public static void main (String[] args) throws IOException {
		PlayerType playerType = args.length > 1 && args[1].equals("-i") ? PlayerType.IRONMAN : PlayerType.NORMAL;

		System.out.print(HighScoreConnector.getPlayerStats(args[0], playerType));
		System.out.flush();
	}
}
