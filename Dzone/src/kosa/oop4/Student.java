package kosa.oop4;

public class Student extends Man {
	
	public Student() {}

	public Student(String name) {
		super(name);
	}
	
	public String speak() {
		return getName()+": 공부나 열심히 해";
	}
}
