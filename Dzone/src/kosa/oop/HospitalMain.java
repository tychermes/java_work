package kosa.oop;

public class HospitalMain {

	public static void main(String[] args) {
		
		Patient p1 = new Patient("홍길동", "020324-3XXXXX1");
		Patient p2 = new Patient("김길동", "020324-3XXXXX2");
		Patient p3 = new Patient("이길동", "020324-3XXXXX3");
		Patient p4 = new Patient("박길동", "020324-3XXXXX4");
		
		for(int i=0; i<PatientList.patientsTotal; i++) {
			System.out.print(PatientList.patientsNames[i]+",");
		}

	}

}
