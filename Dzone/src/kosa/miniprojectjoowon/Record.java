package kosa.miniprojectjoowon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Record {
	private int date;
	private int timeHour;
	private int timeMinute;
	private int month;
	static int work = 0;
	static int late = 0;
	Calendar gc = Calendar.getInstance(); // 현재시간 체크 기능
	public Record(int month, int date, int timeHour, int timeMinute) {
		super();
		this.month = month;
		this.date = date;
		this.timeHour = timeHour;
		this.timeMinute = timeMinute;
	}

	public Record() {
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTimeHour() {
		return timeHour;
	}

	public void setTimeHour(int timeHour) {
		this.timeHour = timeHour;
	}

	public int getTimeMinute() {
		return timeMinute;
	}

	public void setTimeMinute(int timeMinute) {
		this.timeMinute = timeMinute;
	}


	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public void abstractWork(List<Record> list) {
		String str = "";
		for(int i = 0 ; i<list.size();i++) {
			if(list.get(i).getMonth()==gc.get(Calendar.MONTH)) {
				if(list.get(i) instanceof Out ) {
					if(list.get(i).getTimeHour()>=9&&list.get(i).getTimeMinute()>0) {
						late++;
					}
					work++;
				}
			}
		}
		str =(gc.get(Calendar.MONTH)+1)+"월 "+ "출근 : " + work + "번 지각 : " + late + "번";
		System.out.println(str);
	}

	public void showAll(List<Record> list) {
		Iterator<Record> it = list.iterator();
		int s_month = gc.get(Calendar.MONTH);
		for(int i = 0 ; i <30; i++) {
			while (it.hasNext()) {
				Record r = it.next();
				if(date == i) {
					if(r instanceof Work) {
						r.show();
					}
					if (r instanceof Out) {
						r.show();
					}
				}
			}
		}
	}
	

	public void show() {	}
	
	public  int work(List<Record> list, int flag) {
		if(list.get(list.size()-1).getDate() == gc.get(Calendar.DATE)) { //맨 마지막 정보가 오늘 날짜랑 같을 때
			if(flag == -1) {
				System.out.println("이미 출근기록이 있습니다!");
				flag =1;
			}else {
				System.out.println("이미 퇴근기록이 있습니다!");
			}
		}else {
			if(flag == 1) {
				list.add(new Work(gc.get(Calendar.MONTH),gc.get(Calendar.DATE), gc.get(Calendar.HOUR_OF_DAY), gc.get(Calendar.MINUTE)));
				System.out.println(gc.get(Calendar.HOUR_OF_DAY) + "시에 출근하셨습니다.");
				if (gc.get(Calendar.HOUR_OF_DAY) >= 9 && gc.get(Calendar.MINUTE) > 0) {
					System.out.println("지각입니다.");
					late++;
					flag = -1;
				}
			}else {
				System.out.println("이미 출근했습니다!");
			}
		}
		return flag;
	}
	

	public int  out(List<Record> list,int flag) {
		if(flag != -1) {
			if(list.get(list.size()-1).getDate() == gc.get(Calendar.DATE)) { //맨 마지막 정보가 오늘 날짜랑 같을 때
				if(flag == 1) {// 출근일은 존재 할 경우
					list.add(new Out(gc.get(Calendar.MONTH),gc.get(Calendar.DATE), gc.get(Calendar.HOUR_OF_DAY), gc.get(Calendar.MINUTE)));
					System.out.println(gc.get(Calendar.HOUR_OF_DAY) + "시에 퇴근하셨습니다.");
					flag = -1;
				}else {
					System.out.println("이미 퇴근기록이 있습니다!");
				}
			}else {
				if(flag == -1) {
					list.add(new Out(gc.get(Calendar.MONTH),gc.get(Calendar.DATE), gc.get(Calendar.HOUR_OF_DAY), gc.get(Calendar.MINUTE)));
					System.out.println(gc.get(Calendar.HOUR_OF_DAY) + "시에 퇴근하셨습니다.");
					flag = 1;
				}else {
					System.out.println("출근 먼저 해주세요!");
				}
			}
		}
		return flag;
	}
}
