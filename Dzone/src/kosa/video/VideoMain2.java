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
		
		List<Video> videoList = new ArrayList<Video>();
		List<GeneralMember> generalMemList = new ArrayList<GeneralMember>();
		List<SpecialMember> specialMemList = new ArrayList<SpecialMember>();
		
		videoList.add(new Video(1,"트랜스포머3","서봉수"));
		videoList.add(new Video(2,"쿵푸팬더","지성민"));
		videoList.add(new Video(3,"탑건2","톰크루즈"));
		videoList.add(new Video(4,"존윅4","키아누리브스"));
		
		generalMemList.add(new GeneralMember("aaa", "홍길동", "동탄"));
		specialMemList.add(new SpecialMember("bbb", "김철수", "서울"));

		generalMemList.get(0).rental(videoList.get(0));
		generalMemList.get(0).rental(videoList.get(2));
		
		specialMemList.get(0).rental(videoList.get(1));
		specialMemList.get(0).rental(videoList.get(3));
		
		generalMemList.get(0).print();
		specialMemList.get(0).print();
	}

}
