package kosa.mission;

import java.util.Scanner;

public class Mission08 {
	// 전역변수(모든 메서드에서 사용 가능)
	static int count = 0;
	static Scanner sc;

	// 추가 메서드 add() 과일 추가 (CallByReference)
	public static void add(String[] arr) {
		System.out.print("추가할 과일 입력: ");
		String fruit;
		fruit = sc.nextLine();
		arr[count++] = fruit;
		System.out.println("count:" + count);
	}

	// 출력 메서드 print() 과일 목록 출력
	public static void print(String[] arr) {
		System.out.print("추가된 과일: ");
		for (int i = 0; i < count; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	
	// 해당 과일이 몇 번째 위치하는지 검색
	public static void search(String[] arr) {
		System.out.print("검색할 과일: ");
		String fruit = sc.nextLine();
		int index = -1;	// 일부러 초기값을 -1로.
		for(int i=0; i<count; i++) {
			if(fruit.equals(arr[i])) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("해당 과일이 존재하지 않습니다.");
		} else {
			System.out.println(arr[index]+"가 "+(index+1)+"번째에 있습니다.");
		}
	}
	
	public static void main(String[] args) {
		// 메뉴를 선택해서 해당 메뉴의 명령문을 실행하자.
		// 1.추가 2.출력 3.검색 4.종료
		// 4번을 선택하기 전까지 계속 프로그램이 반복되고, 4번 선택 시 종료.
		// 입력: 1
		// 추가 선택됨
		sc = new Scanner(System.in);
		boolean flag = true;
		String input;
		String arr[] = new String[Byte.MAX_VALUE];

		// 내 방법 (루프 위쪽에 label을 설정하여 'break 라벨이름;' 하는 방법도 있음)
		while (flag) {
			System.out.println("1.추가 2.출력 3.검색 4.종료");
			System.out.print("입력: ");
			input = sc.nextLine();

			switch (input.trim()) {
			case "1":
				add(arr);
				break;
			case "2":
				print(arr);
				break;
			case "3":
				search(arr);
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}
		}

//		
//		// 교수님 방법!!!
//		while(true) {
//			System.out.println("1.추가 2.출력 3.검색 4.종료");
//			System.out.print("입력: ");
//			input = sc.nextLine();
//			
//			switch (input.trim()) {
//			case "1":
//				System.out.println("추가 선택됨.");
//				break;
//			case "2":
//				System.out.println("출력 선택됨.");
//				break;
//			case "3":
//				System.out.println("검색 선택됨.");
//				break;
//			case "4":
//				System.out.println("프로그램을 종료합니다.");
//				return;	// break;대신에 main()을 완전 종료하는 return을 쓰는 방법도 있음!
//			default:
//				System.out.println("잘못 입력했습니다.");
//				break;
//			}			
//		}
	}

}
