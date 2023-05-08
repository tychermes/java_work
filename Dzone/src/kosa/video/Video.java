package kosa.video;

public class Video {
	// 비디오 정보 (번호, 제목, 배우)
	private int no;
	private String title;
	private String actor;
	
	public Video() {}
	
	public Video(int no, String title, String actor) {
		super();
		this.no = no;
		this.title = title;
		this.actor = actor;
	}
	
	void print() {
		System.out.println("___________________________________________________________");
		System.out.println("회원의 대여한 비디오 번호: "+this.no);
		System.out.println("회원의 대여한 비디오 제목: "+this.title);
		System.out.println("회원의 대여한 비디오 주인공: "+this.actor);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}
