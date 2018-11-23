import connectors.HighScoreConnector;
import types.PlayerType;
import util.ArrayCompare;
import util.FileReader;

import java.io.IOException;
import java.util.List;

public class App {
	public static void main (String[] args) throws IOException {
		FileReader jp = new FileReader("\\static\\jasper.txt");
		FileReader gw = new FileReader("\\static\\gerjan.txt");

		List<String> jpQuests = jp.getLines();
		List<String> gwQuests = gw.getLines();

		ArrayCompare compare = new ArrayCompare(jpQuests, gwQuests);

//		compare.intersection(false).forEach(System.out::println);

		List<String> intersection = compare.intersection();

		int index = (int) (intersection.size() * Math.random());

		System.out.print(intersection.get(index));
		System.out.flush();
	}
}
