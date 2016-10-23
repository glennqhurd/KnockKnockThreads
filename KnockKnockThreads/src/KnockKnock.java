import java.util.Arrays;
import java.util.List;

public class KnockKnock {

	public static void main(String args[]) {
		List<String> names = Arrays.asList("Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca");
		List<Joke> jokeList = Joke.jsonToJokes();
		
		Speaker speaker1 = new Teller(names, jokeList);
		Speaker speaker2 = new Responder(names, jokeList);
		
		Thread thread1 = new Thread(speaker1);
		Thread thread2 = new Thread(speaker2);
		
		thread1.start();
		thread2.start();
	}
}
