package kosa.courseRegistration2;

import java.util.ArrayList;

public class Course {
	
	private String name;
	private ArrayList<Student> studentList;
	// private List<Student> studentList = new ArrayList<Student>(); 해도 무방함.
	
	public Course() {}

	public Course(String name) {
		super();
		this.name = name;
		studentList = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	
	public void removeStudent(Student student) {
		this.studentList.remove(student);
		print();
	}

	// 한 과목을 신청한 학생(수강자)들을 출력
	void print() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("과목: "+ name);
		
		// 향상된 for문으로!
		for (Student student : studentList) {
			System.out.print("수강자: ");
			System.out.println(student.getName());
		}
	}

}
