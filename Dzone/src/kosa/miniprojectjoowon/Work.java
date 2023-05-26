package kosa.miniprojectjoowon;

import java.util.Calendar;
import java.util.List;

public class Work extends Record {
	public Work(int month,int date, int timeHour, int timeMinute) {
		super(month,date,timeHour,timeMinute);
	}public Work() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		String result = ((this.getMonth()+1)+"월 "+this.getDate()+"일 :"+"출근시간 : " + this.getTimeHour() + "시" + this.getTimeMinute() + "분");
		if (this.getTimeHour() >= 9 && this.getTimeMinute() > 0) {
			System.out.print(result + "<지각>");
		} else {
			System.out.print(result);
		}
	}
	

}
