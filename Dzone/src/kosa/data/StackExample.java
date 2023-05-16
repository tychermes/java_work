package kosa.data;

import java.util.Scanner;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// 키보드로부터 수학 수식을 입력 받는다
		// ((2+3)+10) -> 괄호가 정확하게 일치하는지 불일치하는지 판단 (두개 넣으면 두개 닫혀야 함)
		// ex: 괄호 2개 열었는데 1개 닫았으면 "불일치" 출력

		Scanner sc = new Scanner(System.in);
		String[] strArray;

		System.out.print("수식 입력: ");
		strArray = sc.nextLine().trim().split("");

		int count = 0;

		// push 할 '때' 판단 --- 최상단 데이터를 얻는 stack.peek() 사용했는데.. 굳이 이럴 필요 있나 싶어...
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < strArray.length; i++) {
			stack.push(strArray[i]);
			if (stack.peek().equals("(")) {
				count++;
			} else if (stack.peek().equals(")")) {
				count--;
			}
		}
		System.out.println("최상단 데이터: " + stack.peek());
		System.out.println((count == 0) ? "일치" : "불일치");

		// pop 할 '때' 판단
		int open = 0, close = 0; // 변수 두 개 선언할 필요 없이, int answer=0; 해놓고,
		// while문 안에서 괄호 열 때 answer++, 괄호 닫을 때 answer-- 하고서, 최종적으로도 0이면 일치.
		while (!stack.isEmpty()) {
			String str = stack.pop();
			if (str.equals("(")) {
				open++;
			} else if (str.equals(")")) {
				close++;
			}
		}
		System.out.println((open == close) ? "일치" : "불일치");

		
		// T's solution : 직접 push, pop '하면서' 비어있는 지로 판단 ========================
		try {
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i].equals("(")) {
					stack.push(strArray[i]);
				} else if (strArray[i].equals(")")) {
					stack.pop(); // 3개가 들어있는데, 4개를 뽑으려고 하면 예외 발생.
				}
			}
			System.out.println((stack.isEmpty()) ? "일치" : "불일치");
		} catch (Exception e) {
			System.out.println("불일치");
		}

	}

}
