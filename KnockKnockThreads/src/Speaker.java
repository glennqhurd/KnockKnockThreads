import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Speaker {
	private List<String> names;
	private String currentName;
	private List<Joke> jokeList;
	private String nameInUse = "";
	
	public Speaker (List<String> names, List<Joke> jokeList) {
		this.names = names;
		this.jokeList = jokeList;
		this.setRandomName();
	}
	
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
	
	public String getCurrentName() {
		return this.currentName;
	}
	
	public void setNameInUse(String nameInUse) {
		this.nameInUse = nameInUse;
	}
	
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
}
