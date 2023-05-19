package kosa.thread;

public class SumThread0 extends Thread {

	private int start, end, total;
	
	public SumThread0() {}
	
	public SumThread0(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		// start~end 합을 구하는 스레드
		for(int i=start; i<=end; i++) {
			total += i;
		}
	}
	
	// ========================
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
