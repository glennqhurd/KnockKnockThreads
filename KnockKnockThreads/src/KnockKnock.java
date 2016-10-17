import java.util.Arrays;
import java.util.List;

public class KnockKnock {

	public static void main(String args[]) {
		List<String> names = Arrays.asList("Grandpa Lyman", "Uncle Glenn", "Uncle JJ", "Aunt Becca");
		Speaker speaker = new Speaker(names);
		speaker.speakJokes();
		speaker.speakJokes();
	}
}
