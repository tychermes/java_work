package kosa.oop4;

public class Worker extends Man implements Speakable {

	public Worker() {}
	
	public Worker(String name) {
		super(name);
	}
	
	@Override
	public String speak() {
		return getName()+": 열심히 일해야 한다";
	}

}
