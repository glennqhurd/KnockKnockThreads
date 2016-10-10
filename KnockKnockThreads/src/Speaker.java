import java.util.concurrent.ThreadLocalRandom;

public class Speaker {
	private String[] names;
	private String currentName1;
	private String currentName2 = "";
	
	public Speaker (String[] names) {
		this.names = names;
		int name1 = ThreadLocalRandom.current().nextInt(0, names.length);
		this.currentName1 = names[name1];
		while (currentName2.equals("")) {
			int name2 = ThreadLocalRandom.current().nextInt(0, names.length);
			if (!(name2 == name1)) {
				this.currentName2 = names[name2];
			}
		}
	}
	
	public void speakJokes () {
		String firstSpeaker = String.format("%s: Knock knock!", this.currentName1);
		System.out.println(firstSpeaker);
		String secondSpeaker = String.format("%s: Who's there?", this.currentName2);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Boo.", this.currentName1);
		System.out.println(firstSpeaker);
		secondSpeaker = String.format("%s: Boo who?", this.currentName2);
		System.out.println(secondSpeaker);
		firstSpeaker = String.format("%s: Why are you crying?", this.currentName1);
		System.out.println(firstSpeaker);
	}
	
	/*public void setRandomNames () {
		
	}*/
}