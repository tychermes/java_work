package kosa.miniproject;

import java.util.Calendar;
import java.util.List;

public class In extends Record {
	
	public In(int month, int date, int timeHour, int timeMinute, int whether) {
		super(month, date, timeHour, timeMinute, whether);
		// TODO Auto-generated constructor stub
	}

	public In() {}
	
	@Override
	public void show() {
		String result = ((this.getMonth()+1)+"월 "+this.getDate()+"일 :"+"출근시간 : " + this.getTimeHour() + "시" + this.getTimeMinute() + "분");
		if (this.getTimeHour() >= 9 && this.getTimeMinute() > 0) {
			System.out.print(result + "<지각>");
		} else {
			System.out.print(result);
		}
	}
	

}

