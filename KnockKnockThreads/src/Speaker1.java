
public class Speaker1 implements Runnable {
	
	private boolean myTurn = true ;
	
	public Speaker1 () {
		
	}
	
	public void run() {
		try {
			this.firstRemark();
			myTurn = false;
			while (!myTurn) {
				wait();
			}
			Thread.sleep(1000);
			this.secondRemark();
			myTurn = false;
			while (!myTurn) {
				wait();
			}
			Thread.sleep(1000);
			this.lastRemark();
		} catch (InterruptedException e) {
			System.out.println("Interrupted.");
		}
	}
	
	public synchronized void firstRemark() {
			System.out.println("Knock knock.");
	}
	
	public synchronized void secondRemark() {
		System.out.println("Boo.");
	}
	
	public synchronized void lastRemark() {
		System.out.println("Why are you crying?");
	}
	
	public void setTurn(boolean turn) {
		this.myTurn = turn;
	}
}
