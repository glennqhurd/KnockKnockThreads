import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public class Teller extends Speaker implements Runnable{
	
	private List<Joke> jokeList;
	private String currentName;
	
	public Teller (List<String> names, List<Joke> jokeList) {
		super(names, jokeList);
	}

	public void run() {
		String blockCondition;
		currentName = getCurrentName();
		jokeList = getJokeList();
		while (!jokeList.isEmpty()) {
			String tellerString = String.format("%s: Knock knock!\n", currentName);
			System.out.println(tellerString);
			addToResponder("");
			blockCondition = getFromTeller();
			tellerString = String.format("%s: %s\n", currentName, blockCondition);
			System.out.println(tellerString);
			addToResponder(jokeList.get(0).getLine1());
			blockCondition = getFromTeller();
			tellerString = String.format("%s: %s\n", currentName, blockCondition);
			System.out.println(tellerString);
			jokeList.remove(0);
			setRandomName();
		}
	}
	
	private void setRandomName() {
		List<String> names = getNames();
		int idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
		currentName = names.get(idx);
		Collections.swap(names, idx, 0);
	}
}
