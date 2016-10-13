import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Speaker {
	private List<String> names;
	private String currentName;
	private Joke joke = new Joke();
	
	public Speaker (List<String> names) {
		this.names = names;
		this.setRandomName();
	}
	
	public void speakJokes () {
		String firstSpeaker = String.format("%s: Knock knock!\n", this.currentName);
		System.out.println(firstSpeaker);
		String secondSpeaker = String.format("%s: Who's there?\n", this.currentName);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Boo.\n", this.currentName);
		System.out.println(firstSpeaker);
		secondSpeaker = String.format("%s: Boo who?\n", this.currentName);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Why are you crying?\n", this.currentName);
		System.out.println(firstSpeaker);
		this.setRandomName();
	}
	
	private void setRandomName() {
		int idx = ThreadLocalRandom.current().nextInt(names.size());
		this.currentName = this.names.get(idx);
	}
}
