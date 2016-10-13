import java.util.List;
import java.util.ArrayList;

public class Joke {
	private List<String> jokeList;
	
	public Joke() {
		this.jokeList = new ArrayList<String>();
	}
	
	public void setJokeList(List<String> jokeList) {
		this.jokeList = jokeList;
	}
	
	public List<String> getJokeList() {
		return this.jokeList;
	}
}
