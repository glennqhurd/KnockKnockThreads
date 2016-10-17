import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Joke {
	private List<String> jokeList = new ArrayList<String>();
	private List<String> syncJokeList = Collections.synchronizedList(jokeList);
	
	public Joke() {
		this.jokeList.add("Boo");
		this.jokeList.add("Why are you crying?");
		this.jokeList.add("A broken pencil");
		this.jokeList.add("Never mind, it's pointless");
	}
	
	public void setJokeList(List<String> jokeList) {
		this.jokeList = jokeList;
	}
	
	public String getNextLine() {
		String joke = this.jokeList.get(0);
		this.jokeList.remove(0);
		return joke;
	}
}
