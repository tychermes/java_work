package kosa.video;

public class SpecialMember extends GeneralMember {
	private int bonusPoint = 0;

	public SpecialMember() {}
	
	// 회원가입만
	public SpecialMember(String id, String name, String address) {
		super(id, name, address);
	}

	void rental(Video video) {
		super.rental(video);
		this.bonusPoint += 10;	// 비디오 대여시 10포인트씩 더 줌
	}
	
	void print() {
		super.print(); // super는 부모 객체인데,  써도 되고 안써도 잘 실행 됨.
		System.out.println("------------------------------");
		System.out.println("회원의 누적 포인트 : "+bonusPoint);
	}
	
//	// 회원가입과 동시에 비디오 대여
//	public SpecialMember(String id, String name, String address, Video video, int bonusPoint) {
//		super(id, name, address, video);
//		this.bonusPoint = bonusPoint;
//	}	
}
