package kosa.api;

import java.util.Calendar;

public class CalendarMission02 {

	public static void main(String[] args) {
		// 2023년 5월 달력 만들기
		// <2023년 5월>
		// 일	월	화	수	목	금	토
		//		1	2	3	4	5	6
		// 7	8	9	10	11	12	13
	
		Calendar gc = Calendar.getInstance();
		int n = gc.getActualMaximum(Calendar.DATE);	
		// △ 2월이면 28~29반환, 3월이면 31반환, 4월이면 30 반환.

		// 5월 1일의 날짜와 요일은
		gc.set(2023, 5-1, 1);
		int firstDayOfWeek = gc.get(Calendar.DAY_OF_WEEK)-1;

		System.out.println(" <2023년 5월> ");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		int[][] calendar = new int[5][7];
		int k=1;
		for(int i=0; i<5 && k<=n; i++) {
			for(int j=0; j<7 && k<=n; j++) {
				if(i==0 && j<firstDayOfWeek) {
					System.out.print("\t");	
					// 교수님 솔루션에 비해 나는 중첩for,if를 너무 많이 써서 복잡하고 어지러운 코드가 되는 것 같음	
				} else {
					calendar[i][j] = k++;
					System.out.print(calendar[i][j]+"\t");
				}
			}
			System.out.println();
		}
		// 정말 한 칸 한 칸씩 맞춰서 했다........
	}

}
