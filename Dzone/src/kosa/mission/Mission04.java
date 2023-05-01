package kosa.mission;

import java.util.Scanner;

public class Mission04 {

	public static void main(String[] args) {
		// 로그인 예제를 구현해보자.
		// id, pw를 키보드로부터 입력 받음
		// id, pw가 모두 일치=> "로그인 성공" 메시지 출력.
		// id가 불일치=> "해당 아이디가 존재하지 않습니다" 메시지 출력.
		// pw가 불일치=> "비밀번호가 일치하지 않습니다" 메시지 출력.
		
		String m_id = "kosa";
		String m_pass = "1234";
		
		// 이 아래부터 내가 만들기.
		String input_id, input_pass;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요: ");
		input_id = sc.nextLine();

		System.out.println("비밀번호를 입력하세요: ");
		input_pass = sc.nextLine();
		
		if (input_id.trim().equals(m_id)) {//trim()은 양사이드의 공백문자를 제거.
			if(input_pass.trim().equals(m_pass)) {
				System.out.println("로그인 성공.");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}			
		} else {
			System.out.println("해당 아이디가 존재하지 않습니다.");
		}
		
		// 교수님 풀이 (교수님처럼 && 사용해도 되고, 나처럼 중첩 if문만 사용해도 되고.)
//		if (input_id.equals(m_id) && input_pass.equals(m_pass)) {
//			System.out.println("로그인 성공.");
//		} else {
//			if(!input_id.equals(m_id)) {
//				System.out.println("해당 아이디가 존재하지 않습니다.");
//			} else {
//				System.out.println("비밀번호가 일치하지 않습니다.");
//			}			
//		}
		
		sc.close();
	}
}
