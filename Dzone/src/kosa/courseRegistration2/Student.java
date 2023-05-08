package kosa.courseRegistration2;
import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Course> courseList;	
	// private List<Course> courseList = new ArrayList<Course>(); 해도 무방함.

	public Student() {}

	public Student(String name) {
		super();
		this.name = name;
		courseList = new ArrayList<Course>();
	}
	
	public Student(String name, Course course) {
		super();
		this.name = name;
		courseList = new ArrayList<Course>();
		this.courseList.add(course);
	}
	
	void resister(Course course) {
		this.courseList.add(course);
		course.addStudent(this); // 해당 Course에도 이 Student 객체를 넣어줌.
		// 연결 시 주의! Course가 인공지능으로 Student를 선택하는 것이 아니기 때문에, 
		// 방금 Course를 추가하자 마자 여기서 바로 또 Course에 본인(학생)객체를 전달해 줌.
	}
	
	void drop(Course course) {
		if (courseList.contains(course)) {
			String courseName = course.getName();
			courseList.remove(course);
			course.removeStudent(this);
			System.out.println(name+" 학생이 "+courseName+" 과목 수강 철회 완료.");
		} else {
			System.out.println("해당 과목이 수강 내역에 없습니다.");
		}
		print();
	}
	
	// 한 학생 객체의 수강 과목들을 출력
	void print() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("이름: "+ name);
		
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
