package kosa.video;

import java.util.ArrayList;
import java.util.List;

public class VideoMain2 {
	// main()이 갖고 있는 클래스 결과
	
	// 회원 아이디: aaa
	// 회원 이름: 홍길동
	// 회원 주소: 동탄
	// 회원이 대여한 비디오 번호: 1
	// 회원이 대여한 비디오 제목: 트랜스포머3
	// 회원이 대여한 비디오 주인공 : 서봉수
	
	// 회원의 아이디 : bbb
	// 회원의 이름 : 김철수
	// 회원의 주소 : 서울
	// 회원이 대여한 비디오 번호 : 2
	// 회원이 대여한 비디오 제목 : 쿵푸팬더2  
	// 회원이 대여한 비디오 주인공 :지성민
	// 회원의 보너스 포인트 적립 : 10 
	public static void main(String[] args) {
//		List<Video> videoList = new ArrayList<Video>();
//		List<GeneralMember> generalMemList = new ArrayList<GeneralMember>();
//		List<SpecialMember> specialMemList = new ArrayList<SpecialMember>();
		
		// 2023.05.10 수정
		List<Video> videoList = new ArrayList<Video>();
		videoList.add(new Video(1,"트랜스포머3","서봉수"));
		videoList.add(new Video(2,"쿵푸팬더","지성민"));
		videoList.add(new Video(3,"탑건2","톰크루즈"));
		videoList.add(new Video(4,"존윅4","키아누리브스"));
	
		List<GeneralMember> generalMemList = new ArrayList<GeneralMember>();
		
		// ▽이건 왜 안돼....
		// ★아하!★=> 특별회원을 특별관리하려면 애초에 형변환 안하면 되는 거고,
		// 특별회원 일반회원 구분없이 한 리스트에 넣어서 관리하고 싶은 거면, 
		// generalMemList를 선언하고 그 안에 내용만 add할 때 섞어서 초기화 하면 되잖아?
//		List<GeneralMember> specialMemList = new ArrayList<SpecialMember>(); 
		
		// 2023.05.10 수정2
		GeneralMember[] memberArray = {new GeneralMember("aaa", "홍길동", "동탄"), new SpecialMember("bbb", "김철수", "서울")};
		
		memberArray[0].rental(videoList.get(0));
		memberArray[0].rental(videoList.get(2));
		
		memberArray[1].rental(videoList.get(1));
		memberArray[1].rental(videoList.get(3));
		
		for(int i=0; i<2; i++) {
			memberArray[i].print();
		}
		
		memberArray[0].print();
		memberArray[1].print();	//<-강제 캐스팅 안해도 이미 부모 클래스에 있는 메소드이기 때문에,
		// △ 자식클래스에서 오버라이딩(재정의)한 새 기능(보너스포인트 출력)대로 나온다. 
		// (단, 보너스포인트 '변수'는 다이렉트로 접근 불가한 것...)
		((SpecialMember)memberArray[1]).giveGift();
		// △ giveGift메소드는 부모클래스에는 없는 메소드이기 때문에, 강제캐스팅 하지 않고는 접근/사용할 수 없다.
		
//		generalMemList.add(new GeneralMember("aaa", "홍길동", "동탄"));
//		specialMemList.add(new SpecialMember("bbb", "김철수", "서울"));
//
//		generalMemList.get(0).rental(videoList.get(0));
//		generalMemList.get(0).rental(videoList.get(2));
//		
//		specialMemList.get(0).rental(videoList.get(1));
//		specialMemList.get(0).rental(videoList.get(3));
//		
//		generalMemList.get(0).print();
//		specialMemList.get(0).print();
	}

}
