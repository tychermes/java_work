package kosa.stream;

public class Student {
	
	private String name;
	private int score;
	
	public Student() {}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	@Override
	public boolean equals(Object o) {
		if(name.equals(((Student)o).name)) {
			return true;
		} else {
			return false;
		}		
	}
	
	// Getter & Setter ==========================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	


}
