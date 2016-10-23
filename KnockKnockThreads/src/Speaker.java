import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class Speaker implements Runnable {
	private List<String> names;
	private String currentName;
	private List<Joke> jokeList;
	private String nameInUse = "";
	
	/**
	 * A Speaker is an object that uses the run command to tell jokes
	 * as part of a Thread.  It reads Joke object variables to turn the
	 * lines of the joke into Strings that are printed out.
	 * 
	 * @param names A List of Strings that contains the possible names
	 * @param jokeList A List of Joke objects that store Strings
	 */
	public Speaker (List<String> names, List<Joke> jokeList) {
		this.names = names;
		this.jokeList = jokeList;
		this.setRandomName();
	}
	
	/**
	 * Default method used by Threads to print Strings using the method speakJokes
	 */
	public void run() {
		while (!jokeList.isEmpty()) {
			this.speakJokes();
			this.setRandomName();
		}
	}
	
	/**
	 * Method that takes the first Joke element in the List jokeList and uses String Format
	 * to print out the currentName and the Joke info in a String
	 */
	public void speakJokes () {
		String jokeLine = this.jokeList.get(0).getLine1();
		String firstSpeaker = String.format("%s: Knock knock!\n", this.currentName);
		System.out.println(firstSpeaker);
		String secondSpeaker = String.format("%s: Who's there?\n", this.currentName);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: %s\n", this.currentName, jokeLine);
		System.out.println(firstSpeaker);
		secondSpeaker = String.format("%s: %s who?\n", this.currentName, jokeLine);
		System.out.println(secondSpeaker);
		jokeLine = this.jokeList.get(0).getLine2();
		firstSpeaker = String.format("%s: %s\n", this.currentName, jokeLine);
		System.out.println(firstSpeaker);
		this.jokeList.remove(0);
		this.setRandomName();
	}
	
	/**
	 * Sets the String variable currentName randomly from the List<String> names
	 */
	private void setRandomName() {
		int idx;
		if (this.nameInUse == "") {
			idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
			this.currentName = this.names.get(idx);
		}
		else {
			idx = names.indexOf(this.nameInUse);
			Collections.swap(this.names, idx, (this.names.size() - 1));
			idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
			this.currentName = this.names.get(idx);
		}
	}
	
	protected List<Joke> getJokeList() {
		return this.jokeList;
	}
	
	protected String getCurrentName() {
		return this.currentName;
	}
	
	protected List<String> getNames() {
		return this.names;
	}
}
