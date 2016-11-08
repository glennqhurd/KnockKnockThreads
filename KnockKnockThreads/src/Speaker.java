import java.util.Collections;
import java.util.concurrent.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class Speaker implements Runnable {
	private List<String> names;
	private String currentName;
	private List<Joke> jokeList;
	private String nameInUse = "";
	private BlockingQueue<String> messageToTeller = new ArrayBlockingQueue<String>(1);
	private BlockingQueue<String> messageToResponder = new ArrayBlockingQueue<String>(1);
	
	/**
	 * A Speaker is an object that uses the run command to tell jokes
	 * as part of a Thread.  It reads Joke object variables to turn the
	 * lines of the joke into Strings that are printed out.
	 * 
	 * @param names A List of Strings that contains the possible names
	 * @param jokeList A List of Joke objects that store Strings
	 */
	public Speaker (List<String> names, List<Joke> jokeList, BlockingQueue<String> messageToTeller, 
			BlockingQueue<String> messageToResponder) {
		this.names = names;
		this.jokeList = jokeList;
		this.messageToTeller = messageToTeller;
		this.messageToResponder = messageToResponder;
		this.setRandomName();
	}
	
	/**
	 * Default method used by Threads to print Strings using the method speakJokes
	 */
	public void run() {
		while (!jokeList.isEmpty()) {
			speakJokes();
			setRandomName();
		}
	}
	
	/**
	 * Method that takes the first Joke element in the List jokeList and uses String Format
	 * to print out the currentName and the Joke info in a String
	 */
	public void speakJokes () {
		String jokeLine = jokeList.get(0).getLine1();
		String firstSpeaker = String.format("%s: Knock knock!\n", currentName);
		System.out.println(firstSpeaker);
		String secondSpeaker = String.format("%s: Who's there?\n", currentName);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: %s\n", currentName, jokeLine);
		System.out.println(firstSpeaker);
		secondSpeaker = String.format("%s: %s who?\n", currentName, jokeLine);
		System.out.println(secondSpeaker);
		jokeLine = jokeList.get(0).getLine2();
		firstSpeaker = String.format("%s: %s\n", currentName, jokeLine);
		System.out.println(firstSpeaker);
		jokeList.remove(0);
		setRandomName();
	}
	
	/**
	 * Sets the String variable currentName randomly from the List<String> names
	 */
	private void setRandomName() {
		int idx;
		if (nameInUse == "") {
			idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
			currentName = names.get(idx);
		}
		else {
			idx = names.indexOf(nameInUse);
			Collections.swap(names, idx, (names.size() - 1));
			idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
			currentName = names.get(idx);
		}
	}
	
	protected List<Joke> getJokeList() {
		return jokeList;
	}
	
	protected String getCurrentName() {
		return currentName;
	}
	
	protected List<String> getNames() {
		return names;
	}
	
	protected void addToTeller(String line) {
		messageToTeller.add(line);
	}
	
	protected String getFromTeller() {
		try {
			return messageToTeller.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	protected void addToResponder(String line) {
		messageToResponder.add(line);
	}
	
	protected String getFromResponder() {
		try {
			return messageToResponder.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "";
	}
}
