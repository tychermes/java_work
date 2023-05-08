package kosa.courseRegistration2;

import kosa.courseRegistration2.Course;
import java.util.ArrayList;


// 양방향 관계 ==> student들도 자신들의 course들이 나오고, course안에도 수강하고 있는 student들이 나옴.
public class CourseRegistrationMain {

	public static void main(String[] args) {
		
		ArrayList<Course> generalCourseList = new ArrayList<Course>();
		ArrayList<Student> generalStudentList = new ArrayList<Student>();
		
		// 학생 생성
		generalStudentList.add(new Student("홍길동")); // 학생 이름만 지정하여 생성
		generalStudentList.add(new Student("김길동"));
		generalStudentList.add(new Student("이길동"));
		
		// 과목 생성
		generalCourseList.add(new Course("C언어"));
		generalCourseList.add(new Course("자바"));
		generalCourseList.add(new Course("JS"));
		generalCourseList.add(new Course("데이터베이스"));
		generalCourseList.add(new Course("프로젝트"));

		// 수강 신청.. 각 3과목 정도 
		generalStudentList.get(0).resister(generalCourseList.get(0));
		generalStudentList.get(0).resister(generalCourseList.get(2));
		generalStudentList.get(0).resister(generalCourseList.get(4));

		generalStudentList.get(1).resister(generalCourseList.get(2));
		generalStudentList.get(1).resister(generalCourseList.get(3));
		generalStudentList.get(1).resister(generalCourseList.get(4));

		generalStudentList.get(2).resister(generalCourseList.get(1));
		generalStudentList.get(2).resister(generalCourseList.get(2));
		generalStudentList.get(2).resister(generalCourseList.get(3));
		
	
		// 한 학생 객체의 수강 과목들을 출력
		System.out.println("___________________________________________________________");
		System.out.println("<학생 별 수강 과목>");
		for(Student s : generalStudentList) {
			s.print();
		}
		// 한 과목을 신청한 학생(수강자)들을 출력
		System.out.println("___________________________________________________________");
		System.out.println("<과목 별 수강 명단>");
		for(Course c : generalCourseList) {
			c.print();
		}
		
		// 수강 철회 (학생리스트 단<=>과목리스트 단에서 모두 remove 되어야 함.)
		generalStudentList.get(1).drop(generalCourseList.get(3));
		

	}

}
