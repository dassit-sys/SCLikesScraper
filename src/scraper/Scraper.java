package scraper;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class Scraper {
	public String filePath;
	
	public Scraper() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the filename: ");
		this.filePath = s.nextLine();
		s.close();
	}
	
	public void makePretty() throws FileNotFoundException {
		File in = new File("src\\scraper\\report.txt");
		File out = new File("src\\scraper\\prettyReport.txt");
		Scanner s = new Scanner(in);
		PrintWriter p = new PrintWriter(out);
		while (s.hasNextLine()) { //For each line
			String nextLine = s.nextLine(); //Grab the next line
			nextLine = nextLine.replaceAll("https://soundcloud.com/", "").replaceAll("/", " - "); //Re-format the line
			p.write(String.format("%s\n", nextLine)); //Write to prettyReport.txt
		}
		s.close();
		p.close();
	}
	
	public void readFile() throws FileNotFoundException {
		//"src\\scraper\Phanerona's likes on SoundCloud.html"
		File file = new File(filePath);
		File report = new File("src\\scraper\\report.txt");
		Scanner s = new Scanner(file, "UTF-8");
		int currentLine = 0;
		int tracksFound = 0;
		ArrayList<Integer> lines = new ArrayList<Integer>();
		PrintWriter out = new PrintWriter(report);
		while (s.hasNextLine()) {
			currentLine++;
			String line = s.nextLine();
			if (line.contains("sc-link-dark sc-type-light playableTile__mainHeading audibleTile__mainHeading playableTile__heading playableTile__audibleHeading audibleTile__audibleHeading sc-truncate sc-font-light")) { //Find song lines
				tracksFound++;
				String[] tokens = line.split("\\s+"); //Split tokens up from line
				for (String token : tokens) { //For each token
					if (token.contains("soundcloud.com/")  && !token.contains("</a>") && !token.contains("soundcloud.com/terms-of-use") && !token.contains("soundcloud.com/imprint") && !token.contains("soundcloud.com/pages/") && !token.contains("/charts/top") && !token.contains("popular/searches") && !token.contains("blog.soundcloud") && !token.contains("creators.soundcloud")) { //If its a link to a song URL
						lines.add(currentLine); //Add to line list (why?)
						String formattedURL = String.format("%s \n", token.replaceAll("href=\"", "").replaceAll("\"", "").replaceAll(">", "")); //Format the token
						out.write(formattedURL); //Write to output file
					}
				}
			}
		}
		s.close();
		out.close();
		System.out.printf("Tracks found: %d\nLines: %s", tracksFound, lines.toString());
	}
}