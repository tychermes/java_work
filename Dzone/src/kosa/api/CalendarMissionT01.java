package kosa.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalendarMissionT01 {

	public static void main(String[] args) {
		// 키보드로 입사일을 입력 => "0년 0개월 재직 중"
		String pattern = "yyyy/MM/dd"; // 입력도 이렇게 받자 => ex: 2022/01/01
		DateFormat df = new SimpleDateFormat(pattern);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입사일을 입력하세요 (예시:2023/05/15): ");
		Date inDate = null;
		// 계속 입력받기
		while (sc.hasNextLine()) {//hasNextLine()은 입력값을 받는 한 true 반환. 얘도 입력을 기다림.
			try {
				inDate = df.parse(sc.nextLine()); 
				// 입력받은 날짜 형식을 Date객체에 반환 대입하여, 내가 지정한 형식이 아니라면 예외 발생하도록.
				break; // 문제 없으면 while문 탈출.
			} catch (Exception e) {
				System.out.print("다시 입력 바람");
			}
		} // end while.
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate); // 입사일 // set()은 Date객체를 인자로 넣을 수 없음. setTime()메소드로 가능.
		// 지난 시간에는 Cal 객체를 Date로 변환하는 API을 알려주셨다고 함. 찾아보기. TODO: API 핵중요!!
		Calendar today = Calendar.getInstance(); // 오늘 날짜

		// 총 일수
		long day = (today.getTimeInMillis() - cal.getTimeInMillis()) / (24*60*60*1000);
		// 밀리초(1/1000초)로 반환되는 값을 하루 단위로 변환하기 위해서 24*60*60*1000을 나눠준다.
		// int m = (int)(day/30); // 조금 더 정확히 하려면 대충 30일 말고 아래 방식으로.
		int year = (int)(day/365);
		int month = (int)(day/30) % 12; // 그래 뭔가 % 연산자가 쓰일 줄 예상했는데 어떻게 쓰는지 몰랐어...
		// 월은 12진수고 입출력은 10진수이기 때문에... 예를 들어 나눠서 0.4면 더 정확하게 개월을 표시하는게 있다고 하심..그게 뭘까
		
		System.out.println("재직기간: "+year+"년 "+month+"개월 근속");
		
		
		
		System.out.println("프로그램 종료");
	} // end main.

} // end class.
