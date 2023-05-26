package kosa.miniproject;

import java.util.List;

public class Out extends Record {

	public Out() {
		super();
	}



	public Out(int month, int date, int timeHour, int timeMinute, int whether) {
		super(month, date, timeHour, timeMinute, whether);
		// TODO Auto-generated constructor stub
	}



	public void show() {
		// TODO Auto-generated method stub
		String result = (" 퇴근시간 : " + this.getTimeHour() + "시" + this.getTimeMinute() + "분");
		if (this.getTimeHour() == 18 && this.getTimeMinute()==0) {
			System.out.println(result);
		}
		else if(this.getTimeHour() >= 18&& this.getTimeMinute()>=0) {
			System.out.println(result + "<야근>");
		}else {
			System.out.println(result);
		}
	}
}
