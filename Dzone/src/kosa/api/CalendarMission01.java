package kosa.api;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMission01 {

	public static void main(String[] args) {
		// 키보드로 입사일을 입력 => "0년 0개월 재직 중"
		String pattern = "yyyy/MM/dd"; // 입력도 이렇게 받자 => ex: 2022/01/01
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입사일을 입력하세요 (예시:yyyy/MM/dd): ");
		String input = sc.nextLine().trim();
		
		String[] joinDateStrings = input.split("/");
		int[] joinDateArray = new int[joinDateStrings.length];
		for(int i=0; i<joinDateStrings.length; i++) {
			joinDateArray[i] = Integer.parseInt(joinDateStrings[i]);
			System.out.print(joinDateArray[i]+"/");
		}
		System.out.println();
		
		Calendar gc = Calendar.getInstance();
		
		int nowYear = gc.get(Calendar.YEAR);
		int nowMonth = gc.get(Calendar.MONTH)+1; //0~11반환 +1
		int nowDate = gc.get(Calendar.DATE);
		
		int joinYear = Integer.parseInt(joinDateStrings[0]);
		int joinMonth = Integer.parseInt(joinDateStrings[1]);
		int joinDate = Integer.parseInt(joinDateStrings[2]);
		
		int inOfficeYear = nowYear-joinYear;
		int inOfficeMonth = nowMonth-joinMonth;
		int inOfficeDate = nowDate-joinDate;
		
		// Version1. 중첩 is-else 문을 이용한 방법
		if(inOfficeYear>=0) {
			if(inOfficeMonth>=0) {
				if(inOfficeDate>=0) {// 변화 없이 그대로.
					;	
				} else { // join한 date(일자)가 현재 date(일자)보다 더 크면(=>늦으면), 한 달에서 며칠  모자란 것이므로 inOfficeMonth를 1 빼준다.
					if(inOfficeYear==0 && inOfficeMonth==0) { // 입사일이 현재와 비교하여 '연','월'이 같고 '일'이 더 큰(늦은)경우
						System.out.println("입사일을 현재보다 이전으로 입력하실 수 없습니다.");
					} else {
						inOfficeMonth--;					
					}
				}
			} else {// join한 Month가 현재Month보다 더 크면(=>늦으면), 일 년에서 몇 달 모자란 것이므로 inOfficeYear를 1 빼준다.
				if(inOfficeDate>=0) {
					inOfficeYear--;
				} else { // join한 date(일자)가 현재 date(일자)보다 더 크면(=>늦으면), 한 달에서 며칠  모자란 것이므로 inOfficeMonth를 1 빼준다.
					inOfficeYear--;
					inOfficeMonth--; 
				}	
			}
		} else {
			System.out.println("입사일을 현재보다 이전으로 입력하실 수 없습니다.");
		}
		System.out.println(inOfficeYear+"년 "+inOfficeMonth+"개월  재직 중.");
		
		// Version2. 중첩 is-else 문을 이용한 방법
		// 1~12까지 반복: 12-입사월+현재월=재직월 
		// 1~31까지 반복: 31-입사일+현재일=재직일 <-그런데 30일인지 31일인지 어떻게 비교하지? 그게 원래 안돼서 월까지만 비교한 건가? 
		inOfficeYear = nowYear-joinYear;
		inOfficeMonth = nowMonth-joinMonth;
		inOfficeDate = nowDate-joinDate;
		
		if(inOfficeYear>=0) {
			if(inOfficeMonth>=0) {
				if(inOfficeYear==0 && inOfficeMonth==0 && inOfficeDate<0) {
					System.out.println("입사일을 현재보다 이전으로 입력하실 수 없습니다.");
					System.out.println("프로그램 종료.");
					return;
				} 
			} else {
				inOfficeMonth += 12;
			}
		} else {
			System.out.println("입사일을 현재보다 이전으로 입력하실 수 없습니다.");
			System.out.println("프로그램 종료.");
			return;
		}
		
		System.out.println(inOfficeYear+"년 "+inOfficeMonth+"개월  재직 중.");
		
	}

}
