import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Responder extends Speaker implements Runnable {
	
	List<Joke> jokeList;
	String currentName;
	
	/**
	 * Responder extends Speaker 
	 * @param names
	 * @param jokeList
	 */
	public Responder(List<String> names, List<Joke> jokeList) {
		super(names, jokeList);
	}
	
	public void run() {
		currentName = getCurrentName();
		jokeList = getJokeList();
		while (!jokeList.isEmpty()) {
			String jokeLine = jokeList.get(0).getLine1();
			String responderString = String.format("%s: Who's there?\n", currentName);
			System.out.println(responderString);
			responderString = String.format("%s: %s who?\n", currentName, jokeLine);
			System.out.println(responderString);
			setRandomName();
		}
	}
	
	private void setRandomName() {
		List<String> names = getNames();	
		int idx = ThreadLocalRandom.current().nextInt(1, names.size());
		currentName = names.get(idx);
	}
}
