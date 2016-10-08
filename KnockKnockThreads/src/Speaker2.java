
public class Speaker2 implements Runnable {
	
	private boolean myTurn = false;
	
	public Speaker2 () {
		
	}
	
	public void run() {
		try {
			this.firstRemark();
			myTurn = false;
			while(!myTurn) {
				wait();
			}
			Thread.sleep(1000);
			this.secondRemark();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted.");
		}
	}
	
	public synchronized void firstRemark() {
		System.out.println("Who's there?");
	}
	
	public synchronized void secondRemark() {
			System.out.println("Boo who?");
	}
	
	public void setTurn(boolean turn) {
		this.myTurn = turn;
	}
}
