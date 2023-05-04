package kosa.oop;

// 내가 직접 주제를 정하여 객체 예제를 만들어 보자.
public class Patient {	// 환자

	// public 멤버 변수 선언
	public int patientNo;
	public String socialNo;
	public String name;
	public String lastVisitDate;
	public String appointmentDate;
	
	public Patient() {}	// 디폴트 생성자 선언
	
	public Patient(String name, String socialNo) {
		int i=0;
		for (; i<=PatientList.patientsTotal; i++) {
			if(socialNo.equals(PatientList.patientsSocialNos[i])) {
				System.out.println("이미 등록된 환자입니다.");
				// TODO: 이미 만들어진 객체(중복 환자 등록으로 버려야 할 객체)를 어떻게 없애지?
				// => 없애는게 아니라 중복되는 필수 필드값이면 생성 시도조차 하지말자
				// 한 번 생성을 하면 내가 Total 카운트를 올리든 말든 객체는 무조건 하나 더 만들어지는 것이니까, 
				// HospitalMain()에서 전처리 과정을 통해 객체를 생성할 지 말지를 먼저 검사하고 들어오자.
				break;
			} else { 
				this.name = name;
				this.socialNo = socialNo;
				patientNo = ++PatientList.patientsTotal;
				//'마지막 환자 번호'는 '토탈 환자 수'와 항상 같다. 
				// => 배열의 인덱스로 쓸 때에는 1을 빼주자.
			}
		}
	}

	public void makeAppointment(String name, String birthDate) {
		
	}
	
	
	
}
