import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.JSONException;
import org.json.JSONArray;

public class KnockKnock {

	public static void main(String args[]) {
		List<String> names = Arrays.asList("Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca");
		List<Joke> jokeList = new ArrayList<Joke>();
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
		
		try {
			JSONArray jsonArray = new JSONArray(jsonData);
			jokeList = Joke.jsonToJokes(jsonArray);
		} catch (JSONException e2){
			e2.printStackTrace();
		}
		
		Speaker speaker = new Speaker(names, jokeList);
		speaker.speakJokes();
		speaker.speakJokes();
	}
}
