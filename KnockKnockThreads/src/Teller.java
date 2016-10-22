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
		currentName = this.getCurrentName();
		jokeList = this.getJokeList();
		while (!jokeList.isEmpty()) {
			String jokeLine = this.jokeList.get(0).getLine1();
			String tellerString = String.format("%s: Knock knock!\n", this.currentName);
			System.out.println(tellerString);
			tellerString = String.format("%s: %s\n", this.currentName, jokeLine);
			System.out.println(tellerString);
			jokeLine = this.jokeList.get(0).getLine2();
			tellerString = String.format("%s: %s\n", this.currentName, jokeLine);
			System.out.println(tellerString);
			this.jokeList.remove(0);
			this.setRandomName();
		}
	}
	
	private void setRandomName() {
		List<String> names = this.getNames();
		int idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
		this.currentName = names.get(idx);
		Collections.swap(names, idx, 0);
	}
}
