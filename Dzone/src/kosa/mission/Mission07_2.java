package kosa.mission;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 성적관리 3.0
 * - 메뉴 -
 * 1. 성적 추가 
 * 2. 성적 전체 출력 // 여기까지 먼저.
 * 3. 성적 조회 
 * 4. 성적 정렬 
 * 5. 성적 수정 
 * 6. 성적 삭제
 * 7. 프로그램 종료
 * 
 * 1명의 성적(번호, 국어, 영어, 수학, 총점, 평균) => int 
 * 2차원 배열 int[10][6]; => 생성 (넉넉하게 10명, 과목4개 +총점+평균 6개 필드)
 * 
 * 성적 조회 : 번호(한 사람)를 기준으로 검색 
 * 성적 정렬 : 총점을 기준으로 오름차순 정렬 
 * 성적 수정 : 국어, 영어, 수학 점수 변경 가능 => 총점, 평균도 수정 
 * 성적 삭제 : 삭제 대상을 기준으로 뒷쪽 데이터가 앞으로 이동
 * 
 * 따로 메소드를 만들어서 해도 되고, 메인에서 다 해도 됨.
 * 두명이서 나눠서 하기보다 같이 코딩.
 */
public class Mission07_2 {
	public static Scanner sc;
	public static int count = 0;
	
	public static void insert(int record[][], int index) {
		String[] str = {"국어","영어","수학"};
		System.out.println((index+1)+"번 학생 성적 입력 >");
		// ★★★★0번쨰 필드인 record[index][0]은 사실상 학생 이름입니다★★★★★★★★★★★★★★★★
		record[index][0] = (index+1);
		for(int i=1; i<=3; i++) {
			System.out.print(str[i-1]+": "); // 국,영,수 입력 메시지 출력
			record[index][i] = sc.nextInt();
			record[index][4] += record[index][i];
		}
		record[index][5] = (record[index][4])/3;
	}
	
	public static void add(int record[][]) {
		insert(record, count++);
	}
	
	// 보윤: record 원본배열을 정렬 한 후 인덱스 새로 부여해서 출력하는 방법도.있음.
	public static void printList(int record[][]) {
		System.out.println("전체 성적 출력 >");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		for(int i=0; i<count; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(record[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void search(int record[][]) {
		System.out.print("조회를 원하는 학생 번호를 입력하세요: ");
		int index = sc.nextInt();
		System.out.println((index-1)+"번 학생 성적 조회 >");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		for(int j=0; j<6; j++) {
			System.out.print(record[index-1][j]+"\t");
		}
		System.out.println();
	}
	
	public static void sort(int record[][]) { // 총점 기준 오름차순
		System.out.println("성적 정렬(총점 기준 오름차순) >");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		// 배열의 깊은 복사(참조 아닌, 값 복사)
		int[][] order = new int[count][6];
		for(int i=0; i<count; i++) {
			for(int j=0; j<6; j++) {
				order[i][j] = record[i][j];
			}
		}
		
		// ★ 여러 배경지식들을 갖추어 각 인자의 의미를 이해하자 ★ 특히 '제네릭'의 이해가 필요함.
		Arrays.sort(order, new Comparator<int[]>() {// 1차원 배열들을 서로 옮기는 거니까 int[]을 인자로.
			// Comparator는 정렬 기준을 세우는 인터페이스.
			@Override
			public int compare(int[] o1, int[] o2) {
				// 정렬 기준 작성 => 2차원 배열 안에 1차원 배열의 첫번째 인덱스를 기준으로 오름차순 정렬
				if(o1[4] < o2[4]) {	// [4]번째 원소인 총점 끼리의 비교를 의미함
					return -1;	// 뒤에 원소가 더 큰 경우, 자리를 바꾸지 말라는 뜻으로 -1을 리턴.
				} else if(o1[4] > o2[4]) {
					return 1;	// 뒤의 원소가 더 작은 경우, 자리를 바꾸라는 뜻으로 1을 리턴.
				}
				return 0;	// 값이 같은 경우. 이 부분은 안한다고 문제되지 않음. 지워도 됨.
			}
		});	// return 1은 바꾸기, -1이나 0은 자리 바꾸지 않기.
		
		printList(order); // 정렬된 배열 order를 출력.
	}
	
	public static void modify(int[][] record) {
		System.out.print("수정을 원하는 학생 번호를 입력하세요: ");
		int index = sc.nextInt();
		insert(record, index-1);
	}
	
	public static void delete(int[][] record) {
		System.out.print("삭제를 원하는 학생 번호를 입력하세요: ");
		int index = sc.nextInt();
		for(int i=index-1; i<count; i++) { 
			for(int j=0; j<6; j++) {
				if(i == count-1) { // 마지막 인덱스라면 원소  삭제(원소 0으로 초기화)
					record[i][j] = 0;
				} else {
					//배열의 마지막 원소가 아니라면
					record[i][j] = record[i+1][j]; //이게 맞다...
				}
			}
//			record[i] = record[i+1]; // 1칸씩 Move... 여기서 이렇게 해주려고 했는데, 안바뀜.
//			// ▲ 2차원 배열 안의 1차원 배열은 주소값 가리키는 걸로 통째로 바뀌지 않음. 
//			// ★★★★★왜냐면! 2차원 배열은 사실 1차원 배열끼리 내부적으로 일렬로 이어져 있는 것이기 떄문에.★★★★★★
		}
		count--;	// 인덱스 내리기
		printList(record);
	}
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		int menu = 0;
		int[][] record = new int[10][6];
		
		while (true) {
			System.out.println(""
					+ "1.성적 추가 | "
					+ "2.성적 전체 출력 | "
					+ "3.성적 조회 | "
					+ "4.성적 정렬 | "
					+ "5.성적 수정 | "
					+ "6.성적 삭제 | "
					+ "7.프로그램 종료");
			System.out.print("입력: ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				add(record);
				break;
			case 2:
				printList(record);
				break;
			case 3:
				search(record);
				break;
			case 4:
				sort(record);
				break;
			case 5:
				modify(record);
				break;
			case 6:
				delete(record);
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("없는 메뉴 입니다.");
				break;
			}
		}

	}

}
