import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public class Responder extends Speaker implements Runnable {
	
	private List<Joke> jokeList;
	private String currentName;
	
	/**
	 * Responder extends Speaker 
	 * @param names
	 * @param jokeList
	 */
	public Responder(List<String> names, List<Joke> jokeList) {
		super(names, jokeList);
	}
	
	public void run() {
		String blockCondition;
		currentName = getCurrentName();
		jokeList = getJokeList();
		while (!jokeList.isEmpty()) {
			blockCondition = getFromResponder();
			String responderString = String.format("%s: Who's there?\n", currentName);
			System.out.println(responderString);
			addToTeller(jokeList.get(0).getLine1());
			blockCondition = getFromResponder();
			responderString = String.format("%s: %s who?\n", currentName, blockCondition);
			System.out.println(responderString);
			addToTeller(jokeList.get(0).getLine2());
			setRandomName();
		}
	}
	
	private void setRandomName() {
		List<String> names = getNames();	
		int idx = ThreadLocalRandom.current().nextInt(1, names.size());
		currentName = names.get(idx);
	}
}
