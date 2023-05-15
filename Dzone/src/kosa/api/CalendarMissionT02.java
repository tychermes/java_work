package kosa.api;

import java.util.Calendar;

public class CalendarMissionT02 {
	// 2023년 5월 달력 만들기
	// <2023년 5월>
	// 일	월	화	수	목	금	토
	//		1	2	3	4	5	6
	// 7	8	9	10	11	12	13
	public static void main(String[] args) {
		Calendar gc = Calendar.getInstance();
		gc.set(2023,5-1,1); // 2023년 5월 1일
		int week = gc.get(Calendar.DAY_OF_WEEK); // 1~7(일~토) 반환.
		
		System.out.println(" <2023년 5월> ");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i=1; i<=week; i++) {	// 중첩for를 쓰나, 이렇게 for를 한개씩 나눠쓰나, 후자가 더 보기도 편함!
			System.out.print("\t");
		}

		int n = gc.getActualMaximum(Calendar.DATE);
		for(int i=1; i<=n; i++) {
			System.out.print(i+"\t");
			if((week+(i-1))%7 == 0) {// 난 직관적으로 (week+(i-1))==7 이라고밖에 생각이 안났는데...
				// TODO: mod(%) 사용 방법을 공부해야겠다..!!
				System.out.println(); // 개행
			}
		}
		
		
		
	}
}
