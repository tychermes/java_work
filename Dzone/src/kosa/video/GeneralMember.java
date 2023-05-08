package kosa.video;

import java.util.ArrayList;

public class GeneralMember {
	// 일반 회원에 대한 정보(아이디, 이름, 주소, 빌린 비디오)
	String id, name, address;
//	Video[] rentalVideoArray;
	ArrayList<Video> rentalVideoList;
	int count = 0;
	
	public GeneralMember() {}
	
	// 회원가입만
	public GeneralMember(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// 회원가입과 동시에 비디오 대여
	public GeneralMember(String id, String name, String address, Video video) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		rentalVideoList = new ArrayList<Video>();
		try {
			this.rentalVideoList.set(count++, video);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("한 회원이 3개 초과하여 비디오를 대여할 수 없습니다.");
			e.printStackTrace();
		}
	}

	// 일반 회원 내역 출력(아이디, 이름, 주소, 빌린비디오 정보)
	void print() {
		System.out.println("___________________________________________________________");
		System.out.println("회원 아이디: "+this.id);
		System.out.println("회원 이름: "+this.name);
		System.out.println("회원 주소: "+this.address);
		try {
			for(int i=0; i<count; i++) {
				this.rentalVideoList.get(i).print();
			}
		} catch (NullPointerException e) {
			System.out.println("회원이 빌린 비디오가 존재하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	// 비디오 대여
	void rental(Video video) {
		try {
			this.rentalVideoList.set(count++, video);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("한 회원이 3개 초과하여 비디오를 대여할 수 없습니다.");
			e.printStackTrace();
		}
	}
	
}
