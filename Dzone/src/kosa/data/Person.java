package kosa.data;

public class Person implements Comparable<Person>{

	String name;
	int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// 나이 기준 오름차순 정렬
		if(age < o.age) { // o.getAge()해도 되고, 같은 클래스라 o.age 해도 되고.
			return -1; // 오름차순인데 뒤의 값이 더 크면 자리 이동할 필요X
		} else if(age > o.age) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


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
