import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.List;

public class KnockKnock {

	public static void main(String args[]) {
		String[] nameArray = {"Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca"};
		List<String> names = Arrays.asList(nameArray);
		List<Joke> jokeList = Joke.readJokesFromFile("C:\\Users\\Glenn\\KnockKnockThreads\\KnockKnockThreads\\Jokes.txt");
		BlockingQueue<String> tellerQueue = new ArrayBlockingQueue<String>(1);
		BlockingQueue<String> responderQueue = new ArrayBlockingQueue<String>(1);
		Speaker teller = new Teller(names, jokeList, tellerQueue, responderQueue);
		Speaker responder = new Responder(names, jokeList, tellerQueue, responderQueue);
		
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
