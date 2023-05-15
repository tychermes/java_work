package kosa.baseballTeacher;

import java.util.Arrays;

public class BaseballTeacher {
	// 난수 생성, 스트라이크/볼 체크
	private int hidden[];
	
	public BaseballTeacher() {
		hidden = new int[3];
		hidden[0] = (int)(Math.random()*9) +1; //1~9까지 사이의 난수 생성.
		
		// 난수 생성 및 중복 값 검사
		do {
			hidden[1] = (int)(Math.random()*9) +1;
			
		} while(hidden[0] == hidden[1]);
		do {
			hidden[2] = (int)(Math.random()*9) +1;
			
		} while(hidden[0] == hidden[1] || hidden[1] == hidden[2]);
		
		System.out.println("정답: "+Arrays.toString(hidden)); 
		// 내가 이걸 자꾸 hidden.toString() 이렇게 확인하려고 실수함. △
		
		
		
	}
	
	
	// 스트라이크 체크 // 같은 자리에 같은 숫자 있으면 카운트
	public int countStrike(int input[]) {
		int strike=0;
		for(int i=0; i<3; i++) {
			if(hidden[i] == input[i]) strike++;
		}
		return strike;
	}
	
	// 볼 체크가 어려운 거라고 하심.. // 서로 다른 자리에 있어도 같은 숫자 카운트
	// i일때 i+1 이나 i+2 자리에 위치한 배열원소를 비교하려면 array out of bounds exception 발생 가능성
	// => % 연산자 사용
	public int countBall(int input[]) {
		int ball = 0;
		
		for(int i=0; i<3; i++) {
			if(hidden[i] == input[(i+1)%3]) {
				ball++;	// 비교하려는 정답 위치 i와 ....TODO: 다시 이해하자!
			}
			if(hidden[i] == input[(i+2)%3]) {
				ball++;
			}
		}
		
		return ball;
	}
	
	
	

}
