package kosa.oop;

public class Board {
/*
 * 상태: 글번호, 글제목, 글작성자, 글내용
 * 기능: 1개의 글 정보를 출력
 */
	int no;
	String title;
	String writer;
	String content;
	
	public Board() {}

	public Board(int no, String title, String writer, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public void printPost() {
		System.out.println("___________________________________________________________");
		System.out.printf("%-4d %-25s \t\t\t\t %-5s \n", no, title, writer);
		System.out.println("-----------------------------------------------------------");
		System.out.println(content);
	}

}
