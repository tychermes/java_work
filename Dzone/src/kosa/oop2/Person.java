package kosa.oop2;

public class Person {
	private String name;
	private Role role;
	
	public Person() {}
	
	public Person(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}

	public void doIt() {
		role.doing();	
		// doing이라는 메소드 100% 확신할 수 있다. 
		// Study든 Work 객체든, 추상클래스의 메소드를 오버라이딩하도록 강제하기 때문.
		// 코드의 일관성! (doing 이든, done이든 그때그때 바뀌는 게 아니라.)
	}
	
	
	// Getter & Setter =========================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
