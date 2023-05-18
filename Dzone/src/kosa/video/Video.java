package kosa.video;

import java.io.Serializable;
import java.util.List;

public class Video implements Serializable {
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
	
	public static void printAll(List<Video> videoList) {
		try {
			for(int i=0; i<videoList.size(); i++) {
				videoList.get(i).print();
			}
		} catch (NullPointerException e) {
			System.out.println("회원이 빌린 비디오가 존재하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	void print() {
		System.out.println("------------------------------");
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
