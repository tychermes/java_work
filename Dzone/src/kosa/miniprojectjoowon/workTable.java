package kosa.miniprojectjoowon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class workTable {
	public static void main(String[] args) {
		
		Record r = new Record();
		Record w = new Work();
		Record o = new Out();
//		r.abstractWork();
		
		Scanner sc = new Scanner(System.in);
		List<Record> list = new ArrayList<Record>();

		
//		list.add(new Work(3,20, 9, 15));
//		list.add(new Out(3,20, 18, 0));
		list.add(new Work(4,20, 9, 15));
		list.add(new Out(4,20, 18, 0));
		list.add(new Work(4,21, 8, 0));
		list.add(new Out(4,21, 19, 0));
		list.add(new Work(4,22, 8, 30));
		list.add(new Out(4,22, 17, 30));
		list.add(new Work(4,23, 9, 0));
		list.add(new Out(4,23, 16, 0));
		list.add(new Work(4,24, 9, 0));
		list.add(new Out(4,24, 21, 0));
		
		int flag = 1;
		r.abstractWork(list);
		while (true) {
			System.out.println("1.근태 전체 조회 2.출근 3.퇴근 4.뒤로가기");
			switch (sc.nextLine()) {
			case "1": // 근태 현황 열람
				r.showAll(list);
				break;
			case "2": // 출근
				r.work(list,flag);
				break;
			case "3": // 퇴근
				r.out(list,flag);
				break;
			case "4":
				return;
			}
		}
	}
}
