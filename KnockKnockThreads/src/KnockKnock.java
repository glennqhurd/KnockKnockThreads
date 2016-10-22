import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnockKnock {

	public static void main(String args[]) {
		List<String> names = Arrays.asList("Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca");
		List<Joke> jokeList = Joke.jsonToJokes();
		
		//Speaker speaker1 = new Speaker(names, jokeList);
		//Speaker speaker2 = new Speaker(names, jokeList);
		Speaker speaker1 = new Teller(names, jokeList);
		Speaker speaker2 = new Responder(names, jokeList);
		
		Thread thread1 = new Thread(speaker1);
		Thread thread2 = new Thread(speaker2);
		
		thread1.start();
		thread2.start();
		
		/*
		speaker.speakJokes();
		speaker.speakJokes();
		*/
	}
}
