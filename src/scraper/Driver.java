package scraper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		Scraper scraper = new Scraper();
		scraper.readFile(); //Read the file and generate report.txt (Format: https://www.soundcloud.com/..., one per line)
		scraper.makePretty(); //Generate prettyReport.txt (Format: artist name - song title, one per line)
	}

}