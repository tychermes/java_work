package kosa.io;

import java.io.Serializable;

import kosa.video.Video;

	// implements Serializable 해주는 것만으로 객체 직렬화 대상이 됨.
public class Member implements Serializable { 
	private String name;
	private Video video;

	public Member() {}
	
	public Member(String name) {
		super();
		this.name = name;
	}

	public Member(String name, Video video) {
		super();
		this.name = name;
		this.video = video;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}

	// Getter & Setter ===================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
