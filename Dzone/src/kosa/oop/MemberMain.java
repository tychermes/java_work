package kosa.oop;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(20);
		System.out.println("이름: "+m.getName());
		System.out.println("나이: "+m.getAge());
	}

}
