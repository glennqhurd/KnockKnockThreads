import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Joke {
	private final String line1;
	private final String line2;
	
	/**
	 * Joke object that translates a JSONObject into two line member variables
	 * that store the lines of a Knock Knock Joke
	 * @param json
	 */
	public Joke(JSONObject json) {
		String l1 = "";
		String l2 = "";
		try {
			l1 = json.getString("Line 1");
			l2 = json.getString("Line 2");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.line1 = l1;
		this.line2 = l2;
	}

	/**
	 * Opens a text file and translates the text into a List of Joke objects using JSON
	 * @return jokeList
	 */
	public static List<Joke> jsonToJokes() {
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("C:\\Users\\Glenn\\KnockKnockThreads\\KnockKnockThreads\\Jokes.txt"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		List<Joke> jokeList = new ArrayList<Joke>();
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			for (int i = 0; i < jsonArray.length(); i++){
				jokeList.add(new Joke(jsonArray.getJSONObject(i)));
			}
		} catch (JSONException e2){
			e2.printStackTrace();
		}
		return jokeList;
	}
	
	public String getLine1() {
		return line1;
	}
	
	public String getLine2() {
		return line2;
	}
}
