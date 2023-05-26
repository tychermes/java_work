package kosa.miniprojectjoowon;

import java.util.List;

public class Out extends Record {

	public Out() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Out(int month, int date, int timeHour, int timeMinute) {
		super(month, date, timeHour, timeMinute);
		// TODO Auto-generated constructor stub
	}


	public void show() {
		// TODO Auto-generated method stub
		String result = (" 퇴근시간 : " + this.getTimeHour() + "시" + this.getTimeMinute() + "분");
		System.out.println(result);
	}
}
