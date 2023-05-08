package kosa.courseRegistration;
import java.util.ArrayList;

public class Student {
	private String name;
	// ▼ 생성자나 메서드 밖에서도 리스트 객체 new로 생성 가능.
	// TODO: 왜 되는 거지? => 실제 Course 객체가 아니라 주소값만 부여하는 거라서?
	private ArrayList<Course> courseList = new ArrayList<Course>();	

	public Student() {}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Student(String name, Course course) {
		super();
		this.name = name;
		this.courseList.add(course);
	}
	
	void resister(Course course) {
		this.courseList.add(course);
	}
	
	void drop(Course course) {
		if (courseList.contains(course)) {
			String name = course.getName();
			courseList.remove(course);
			System.out.println(name+" 과목 수강 철회 완료.");
		} else {
			System.out.println("해당 과목이 수강 내역에 없습니다.");
		}
		print();
	}
	
	void print() {
		System.out.println("___________________________________________________________");
		System.out.println("이름: "+ name);
		
//		// 인덱스가 필요할 때 쓸 수 있는 for문. 여기에서는 인덱스가 필요 없다.
//		for(int i=0; i<courseList.size(); i++) {
//			System.out.println("수강 과목: "+courseList.get(i).getName());
//			
//		}
		// 향상된 for문으로!
		for (Course course : courseList) {
			System.out.print("수강 과목: ");
			System.out.println(course.getName());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
}
