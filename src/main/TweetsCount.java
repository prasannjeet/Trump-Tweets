package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetsCount {
	public static void main(String[] args) throws IOException {
		/* ========Counting Number of tweets============= */
		String aLine;
		BufferedReader br = new BufferedReader(new FileReader("src\\main\\data.js"));
		int tweetCount = 0;
		while ((aLine = br.readLine()) != null) {
			if (aLine.contains("{"))
				tweetCount++;
			// System.out.println(aLine);
		}
		System.out.println("Tweet Count: " + tweetCount);
		br.close();
		/* =========Tweets that are NOT from an iPhone================== */
		BufferedReader br2 = new BufferedReader(new FileReader("src\\main\\data.js"));
		int notFromiPhone = 0;
		int fromiPhone = 0;
		while ((aLine = br2.readLine()) != null) {
			if (aLine.contains("Twitter for iPhone"))
				fromiPhone++;
		}
		notFromiPhone = tweetCount - fromiPhone;
		System.out.println("Tweets not from iPhone: " + notFromiPhone);
		br2.close();
		/* ======Highest amount of favorites ============ */
		BufferedReader br3 = new BufferedReader(new FileReader("src\\main\\data.js"));
		int highestFav = 0;
		while ((aLine = br3.readLine()) != null) {
			if (aLine.contains("favorite_count")) {
				Pattern p = Pattern.compile("-?\\d+");
				Matcher m = p.matcher(aLine);
				while (m.find()) {
					// System.out.println(m.group());
					int temp = Integer.parseInt(m.group());
					if (temp > highestFav) {
						highestFav = temp;
					}
				}
			}
		}
		System.out.println("Highest Favorite Count: " + highestFav);
		br3.close();
		/* ==============Highest Fav on a retweet=============== */
		int highestFav2 = 0;
		int someInt = 0;
		BufferedReader br4 = new BufferedReader(new FileReader("src\\main\\data.js"));
		while ((aLine = br4.readLine()) != null) {
			if (aLine.contains("favorite_count")) {
				// int someInt = 0;
				Pattern p = Pattern.compile("-?\\d+");
				Matcher m = p.matcher(aLine);
				while (m.find()) {
					// System.out.println(m.group());
					int temp = Integer.parseInt(m.group());
					if (temp > someInt)
						someInt = temp;
				}
				while ((aLine = br4.readLine()) != null) {
					if (aLine.contains("is_retweet")) {
						// System.out.println(someInt);
						// System.out.println(aLine);
						if (aLine.contains("true")) {
							// System.out.println(aLine);
							if (someInt > highestFav2)
								highestFav2 = someInt;
							// System.out.println("SomeInt"+someInt);
							// System.out.println(highestFav2);
						}
						if (aLine.contains("false")) {
							someInt = 0;
							break;
						}
					}
				}
			}
		}
		System.out.println("Highst Fav on a retweet: " + highestFav2);
		br4.close();
		/* ===================date========================== */
		/*BufferedReader br5 = new BufferedReader(new FileReader("src\\main\\data.js"));
		String date = "";
		int noTweets = 0;
		while ((aLine = br5.readLine()) != null) {
			if (aLine.contains("created_at")) {
				Pattern p = Pattern.compile("[A-Za-z]+ \\d\\d ");
				Matcher m = p.matcher(aLine);
				while (m.find()) {
					// System.out.println(m.group());
					date = m.group();
				}
				while ((aLine = br5.readLine()) != null) {
					String tempString = "";
					Pattern p1 = Pattern.compile("[A-Za-z]+ \\d\\d ");
					Matcher m1 = p1.matcher(aLine);
					while (m1.find()) {
						// System.out.println(m.group());
						tempString = m.group();
					}
					if (tempString == date)
				}
			}
		}*/
	}
}
