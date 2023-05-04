package kosa.oop;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		// 여러 개의 글을 생성해서 글목록 표현하시오.
		
		int count = 0;
		Board[] boards = new Board[Short.MAX_VALUE];
//		Board[] boards = {
//				new Board(1, "첫 번째 글", "교수님", "첫 번째 글입니다."),
//				new Board(2, "두 번째 글", "반장", "두 번째 글입니다."),
//				new Board(3, "세 번째 글", "김민경", "세 번째 글입니다."),
//		};
		
		int menu;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("___________________________________________________________");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 글 작성 | 2. 게시판 출력 | 3. 프로그램 종료");
			System.out.print("입력: ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("작성자 이름을 입력하세요: ");
				String writer = sc.nextLine();
				System.out.print("글 제목을 입력하세요: ");
				String title = sc.nextLine();
				System.out.print("글 내용을 입력하세요(엔터시 입력 종료): ");
				String content = sc.nextLine();
				count++;
				boards[count] = new Board(count, title, writer, content);
				break;
			case 2:
				for(int i=0; i<count; i++) {
					boards[i].printPost();
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
				break;
			}
		}
	}

}
