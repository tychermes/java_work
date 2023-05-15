package kosa.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ListMission {

	public static void main(String[] args) {
		// List 자료구조를 활용하여 키보드로부터 문자열을 입력받아 처리하자.
		// 1.데이터 추가   2.데이터 삭제   3.데이터 출력(for문, iterator 두 가지 방식으로.)
		
		LinkedList<String> strList = new LinkedList<String>();
		// 링크드리스트 역시 배열리스트처럼 순서가 있어서, 순서대로 출력 가능
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		int index = -1;
		do {
			System.out.println("1.데이터 추가   2.데이터 삭제   3.데이터 출력   4.프로그램 종료");
			System.out.print("메뉴를 입력하세요:");
			input = sc.nextLine().trim();
			switch (input) {
			case "1":
				System.out.print("추가할 문자열 데이터를 입력하세요:");
				strList.add(sc.nextLine().trim());
				break;
			case "2":
//				System.out.print("삭제할 문자열 데이터를 입력하세요:");
//				strList.remove(sc.nextLine().trim()); // 내 방법: 오브젝트로 삭제.. 근데 의문이 있음..
//				//remove()메서드는 △ 내부적으로 비교를 equals로 하는 건지..? 어떻게 잘 찾아서 삭제 했네..궁금하네...
				// 주원's: "제네릭을 String으로 선언해줘서 내부의 비교 메소드도 String의 equals를 쓰는 것 같다"고 함
				// T's: 오브젝트를 가진 인덱스를 구해서 그 인덱스를 remove의 인자로 넣어 삭제.
				System.out.print("삭제할 인덱스를 입력하세요:");
				index = strList.indexOf(sc.nextLine().trim()); // T's:인
				if (index != -1) {
					strList.remove(index);
				}				
				break;
			case "3":	// 여기서 for문과 iterator 두 가지 방법 구현해보기
				System.out.println(strList.toString()); 
				// △ 사실 이렇게 하면 출력은 되는데 각각의 객체를 반환해 가져오지는 못하니까.
				System.out.print("for문 사용하는 방법: ");
				for(int i=0; i<strList.size(); i++) {
					System.out.print(strList.get(i)+", ");
				} System.out.println();
				
				System.out.print("iterator 사용하는 방법: ");
				Iterator<String> iter = strList.iterator();
				while(iter.hasNext()) {
					System.out.print(iter.next()+", ");
				} System.out.println();
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
				break;
			} // end switch
			
		} while(!input.equals("4"));

	} // end main

}
