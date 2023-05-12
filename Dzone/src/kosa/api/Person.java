package kosa.api;

public class Person {
	private String name;
	private int age;
	
	public Person() {}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// Method
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		if(this.name.equals(p.getName()) && this.age==p.getAge()) {
		// if(this.name.equals(p.name) && this.age==p.age) { 
			return true; // TODO: △ getter 안쓰고 그냥 필드 접근했는데 왜 되지?
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

	// Getter & Setter ================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
