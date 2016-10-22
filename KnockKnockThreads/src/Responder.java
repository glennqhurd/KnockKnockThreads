import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Responder extends Speaker implements Runnable {
	
	List<Joke> jokeList;
	String currentName;
	
	public Responder(List<String> names, List<Joke> jokeList) {
		super(names, jokeList);
	}
	
	public void run() {
		currentName = this.getCurrentName();
		jokeList = this.getJokeList();
		while (!jokeList.isEmpty()) {
			String jokeLine = jokeList.get(0).getLine1();
			String responderString = String.format("%s: Who's there?\n", currentName);
			System.out.println(responderString);
			responderString = String.format("%s: %s who?\n", this.currentName, jokeLine);
			System.out.println(responderString);
			this.setRandomName();
		}
	}
	
	private void setRandomName() {
		List<String> names = this.getNames();	
		int idx = ThreadLocalRandom.current().nextInt(1, names.size());
		this.currentName = names.get(idx);
	}
}
