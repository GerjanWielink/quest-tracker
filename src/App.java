import util.ArrayCompare;
import util.FileReader;

import java.io.IOException;

public class App {
	public static void main (String[] args) throws IOException {
		FileReader gerjan = new FileReader("\\static\\gerjan.txt");
		FileReader jasper = new FileReader( "\\static\\jasper.txt");

		ArrayCompare comparer =  new ArrayCompare(gerjan.getLines(), jasper.getLines());

		for(String quest: comparer.intersection()) {
			System.out.println(quest);
		}
	}
}
