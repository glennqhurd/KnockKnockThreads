import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Teller extends Speaker implements Runnable{
	
	List<Joke> jokeList;
	String currentName;
	
	public Teller (List<String> names, List<Joke> jokeList) {
		super(names, jokeList);
	}

	public void run() {
		currentName = getCurrentName();
		jokeList = getJokeList();
		while (!jokeList.isEmpty()) {
			String jokeLine = jokeList.get(0).getLine1();
			String tellerString = String.format("%s: Knock knock!\n", currentName);
			System.out.println(tellerString);
			tellerString = String.format("%s: %s\n", currentName, jokeLine);
			System.out.println(tellerString);
			jokeLine = jokeList.get(0).getLine2();
			tellerString = String.format("%s: %s\n", currentName, jokeLine);
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
