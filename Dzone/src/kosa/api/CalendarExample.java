package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {

	public static void main(String[] args) {
		// 현재시간 뽑기
		GregorianCalendar gc = new GregorianCalendar();
		// ▽ 이렇게 해도 됨.
		Calendar gc2 = Calendar.getInstance();
		System.out.println(gc);
		System.out.println(gc2);

		String now = gc.get(Calendar.YEAR)+"년 "
				+ gc.get(Calendar.MONTH+1)+"월 "
				+ gc.get(Calendar.DATE)+"일  "
				+ gc.get(Calendar.HOUR)+"시 "
				+ gc.get(Calendar.MINUTE)+"분 ";
		System.out.println("현재 시간: "+now);
		
		String future = gc.get(Calendar.YEAR)+"년 "
				+ gc.get(Calendar.MONTH+1)+"월 "
				+ gc.get(Calendar.DATE)+"일  "
				+ gc.get(Calendar.HOUR)+"시 "
				+ gc.get(Calendar.MINUTE)+"분 ";
		gc.add(Calendar.DATE, 100); // 100일 후 계산
		System.out.println("100일 후: "+future);
		
		gc.set(2022, 12-1, 24); // MONTH는 0~11이므로. 2022년 12월 24일에서~
		gc.add(Calendar.DATE, 200); // 200일 후 계산.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(gc.getTime());	
		// format()에 집어넣을 Date 객체가 없으므로, Calendar객체의 getTime()으로 Date객체를 반환해줌.
		System.out.println(str);

		// 2023 ~ 2030년까지 자신의 생일이 무슨 요일?
		char week[] = {'일', '월', '화', '수', '목', '금', '토'};
		for(int i=2023; i<=2030; i++) {
			gc.set(i, 3-1, 19); // 3월 19일
			char c = week[gc.get(Calendar.DAY_OF_WEEK)-1];	// DAY_OF_WEEK는 일요일이 1부터 시작
			System.out.println(i+"년의 생일은 "+c+"요일 입니다.");
		}
		
	}

}
