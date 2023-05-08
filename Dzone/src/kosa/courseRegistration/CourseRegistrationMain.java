package kosa.courseRegistration;

import java.util.ArrayList;

public class CourseRegistrationMain {

	public static void main(String[] args) {
		
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		
//		studentList.add(new Student("홍길동")); // 학생 이름만 지정하여 생성
		
		courseList.add(new Course("C언어"));
		courseList.add(new Course("자바"));
		courseList.add(new Course("JS"));
		
		studentList.add(new Student("홍길동")); // 학생 객체 생성과 동시에 과목 하나를 추가
		studentList.get(0).resister(courseList.get(0));
		studentList.get(0).resister(courseList.get(1));
		studentList.get(0).resister(courseList.get(2));
		
		studentList.get(0).print();
		
		studentList.get(0).drop(studentList.get(0).getCourseList().get(1));
		

	}

}
