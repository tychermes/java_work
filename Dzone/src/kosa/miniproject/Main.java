package kosa.miniproject;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Employee> empList = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		
		// 사실 서버에서 할 일인데, 전 사원 리스트 가져오기!
		CSVReader csvReader = new CSVReader();
		csvReader.readCSV();
		
//		Menu menu = new Menu();
//		menu.listMemberMenu();

		
		

		

	}

}
