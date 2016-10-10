import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Speaker {
	private List<String> names;
	private String currentName1;
	private String currentName2 = "";
	
	public Speaker (List<String> names) {
		this.names = names;
		this.setRandomNames();
	}
	
	public void speakJokes () {
		String firstSpeaker = String.format("%s: Knock knock!\n", this.currentName1);
		System.out.println(firstSpeaker);
		String secondSpeaker = String.format("%s: Who's there?\n", this.currentName2);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Boo.\n", this.currentName1);
		System.out.println(firstSpeaker);
		secondSpeaker = String.format("%s: Boo who?\n", this.currentName2);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Why are you crying?\n", this.currentName1);
		System.out.println(firstSpeaker);
		this.setRandomNames();
	}
	
	public void setRandomNames () {
		int idx = ThreadLocalRandom.current().nextInt(names.size());
		this.currentName1 = this.names.get(idx);
		Collections.swap(this.names, idx, (this.names.size() - 1));
		idx = ThreadLocalRandom.current().nextInt(names.size() - 1);
		this.currentName2 = this.names.get(idx);
	}
}
