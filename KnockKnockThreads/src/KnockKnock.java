import java.util.Arrays;
import java.util.List;

public class KnockKnock {

	public static void main(String args[]) {
		String[] nameArray = {"Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca"};
		List<String> names = Arrays.asList(nameArray);
		List<Joke> jokeList = Joke.readJokesFromFile("C:\\Users\\Glenn\\KnockKnockThreads\\KnockKnockThreads\\Jokes.txt");
		
		Speaker teller = new Teller(names, jokeList);
		Speaker responder = new Responder(names, jokeList);
		
		Thread tellerThread = new Thread(teller);
		Thread responderThread = new Thread(responder);
		
		tellerThread.start();
		responderThread.start();
		try {
			tellerThread.join();
			responderThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
