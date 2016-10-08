
public class KnockKnock {

	public static void main(String args[]) {
		Thread speaker1 = new Thread(new Speaker1());
		Thread speaker2 = new Thread(new Speaker2());
		speaker1.run();
		speaker2.run();
	}
}
