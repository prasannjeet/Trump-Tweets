package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

public class NoOfTweets {

	static BufferedWriter bufferedWriter = null;
	static BufferedReader br = null;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		try {
			br = new BufferedReader(new FileReader("src\\main\\data.js"));
			//File myFile = new File("src\\ps222vt_assign2\\Sets\\words.txt");
		
//			if (!myFile.exists()) {
//				System.out.println("=> "+myFile+" does not exist. Creating a new file words.txt.");
//				myFile.createNewFile();
//			}
//			bufferedWriter = new BufferedWriter(new FileWriter(myFile));
//		
//			PrintWriter writer = new PrintWriter(myFile);
//			writer.print("");
//			writer.close();
			String aLine;
		
			//String newLine = System.lineSeparator();
			int tweetCount = 0;
			while ((aLine = br.readLine()) != null) {
				//IdentifyWords.regexChecker("[A-Za-z']+", aLine, bufferedWriter);
				//bufferedWriter.write(newLine);
				if (aLine.contains("{")) tweetCount++;
				System.out.println(aLine);
			}
			//System.out.println("The file "+myFile.toString()+" has been updated successfully.");
			System.out.println("Tweet Count: "+tweetCount);
		} catch (IOException e) {
			System.out.println("IOException Has Occured. Program will now terminate: "+ e);
			System.exit(-1);
		} finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
				br.close();
			} catch (IOException e) {
				System.out.println("IOException Has Occured. Program will now terminate: "+ e);
				System.exit(-1);
			} catch (Exception e) {
				System.out.println("An exception Has Occured. Program will now terminate: "+ e);
				System.exit(-1);
			}
		}
	}
}
