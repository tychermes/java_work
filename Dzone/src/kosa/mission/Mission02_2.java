package kosa.mission;

public class Mission02_2 {
	public static void main(String[] args) {
		// 성적관리 프로그램에서 여러명의 성적을 구현해 보자.
		// 번호		국어		영어		수학		과학		총점		평균
		//	1		90		80		70		80		240		80
		//	2		50		40		60		70		150		50
		//	3		60		70		80		90		210		700
		//========================================================
		// 과목총점:	200		190		110		240
		// 과목평균:	66		63		70		80
		// int[][] score = {{90,80,70,80}, {50,40,60,70}, {60,70,80,90}}
		
		//행0~2, 열0~3
		int[][] score = {
			{90, 80, 70, 80}, 
			{50, 40, 60, 70}, 
			{60, 70, 80, 90}
		};
		
		// 과목 총점,과목 평균은 '세로 합': 각 과목인덱스[i]의 각 [j]번째 원소끼리의 합,평균
		int subTotal[] = {0, 0, 0, 0};	// 이건 유일하게 배열 생성 꼭 필요!
		// subTotal[]만 따로 선언하는 이유: 이것만 for문 다 끝나고 나서 밖에서 출력 해줘야 하기 때문!
		// int korTotal=0; engTotal=0, matTotal=0, scienceTotal=0; 배열아니어도 됨!!		
		// 아래 과목평균도 따로 배열 생성 필요 없이 subTotal/score[0].length하면 됨
		int subAvg[] = {0, 0, 0, 0};

		// 학생 총점,학생 평균은 '가로 합': 각 학생인덱스[j]의 각 [i]번째 원소끼리의 합,평균
		// 사실 학생 총점, 학생 평균 배열을 선언할 필요는 없다. for문 블록 안에서 그때그때 sum하고 avg계산하면 됨.
		int stdTotal[] = {0, 0, 0};
		int stdAvg[] = {0, 0, 0}; //학생 평균도 따로 배열 생성 필요 없이 stdTotal/score.length하면 됨
		
		System.out.println("번호\t국어\t영어\t수학\t과학\t총점\t평균");
		// 배열의 원소들을 포맷에 맞춰서 프린트 할 겸, 과목총점,과목평균,학생총점,학생평균도 여기서 구해본다.
		for(int i=0; i<score.length; i++) {	// 한 학생의 성적 레코드 탐색 시작
			System.out.print((i+1)+"\t");	// 학생번호 출력
			for(int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j]+"\t");
				// 안쪽 for문에서 학생총점(가로합)과 과목총점(세로합)을 구한다.
				stdTotal[i] += score[i][j];	// 학생총점(가로합)
				subTotal[j] += score[i][j]; // 과목총점(세로합)
			}
			System.out.print(stdTotal[i]+"\t");
			// 이 부분이 살짝 이해가 안됨... 왜 되는지??
			stdAvg[i] = stdTotal[i]/score[0].length; // 학생평균(가로평균)
			// ★ 여기에 과목평균 subAvg[i] = (subTotal[i]/score.length);을 집어넣으면 안될까??
			System.out.print(stdAvg[i]+"\t");
			System.out.println();
		}
		System.out.println("=========================================================");
		System.out.print("과목총점:\t");
		//★여기 for 조건에 score[i].length 하면 왜 안될까??? -> 아ㅇㅋ.. i=0으로 초기화 해놓고 왜 그래..?
		// => 잉 근데... [0]번째 배열의 length나 [1],[2],[3]번째 배열의 length나 다 똑같은데... 
		// => 조건식은 루핑할때마다 변화하면 안되기 때문인가?
		for(int i=0; i<score[0].length; i++) {	
			System.out.print(subTotal[i]+"\t");
		}
		System.out.println();
		
		System.out.print("과목평균:\t");
		for(int i=0; i<score[0].length; i++) {
			subAvg[i] = (subTotal[i]/score.length); // 과목평균(세로평균)
			System.out.print(subAvg[i]+"\t");
		}
		System.out.println();
	}
}
