import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Joke {
	private String line1, line2;
	
	public Joke(JSONObject json) {
		try {
			line1 = json.getString("Line 1");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			line2 = json.getString("Line 2");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getLine1() {
		return line1;
	}
	
	public String getLine2() {
		return line2;
	}
	
	public static List<Joke> jsonToJokes(JSONArray json) {
		List<Joke> jokeList = new ArrayList<Joke>();
		try {
			for (int i = 0; i < json.length(); i++){
				jokeList.add(new Joke(json.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jokeList;
	}
}
