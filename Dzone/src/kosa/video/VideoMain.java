package kosa.video;

public class VideoMain {

	//★★ Video와 GeneralMember는 서로 연관관계. 둘 중 누가 주체고 누가 대상인가? 
	// => 내생각엔 회원 객체가  주체임. 
	// => 비디오 객체에는 빌려간 회원 정보가 들어있지 않은데, 회원 객체에는 빌린 비디오 정보라는 객체가 필요하기 떄문.
	public static void main(String[] args) {
		// main()이 갖고 있는 클래스 결과
		// 회원 아이디: aaa
		// 회원 이름: 홍길동
		// 회원 주소: 동탄
		// 회원이 대여한 비디오 번호: 1
		// 회원이 대여한 비디오 제목: 트랜스포머3
		// 회원이 대여한 비디오 주인공 : 서봉수
		Video[] videoArray = new Video[100];
		videoArray[0] = new Video(1, "트랜스포머3", "서봉수");

		GeneralMember[] generalMember = new GeneralMember[100];
//		generalMember[0] = new GeneralMember("aaa", "홍길동", "동탄", videoArray[0]);
		generalMember[0] = new GeneralMember("aaa", "홍길동", "동탄"); // 회원가입만 해놓을 경우.
//		generalMember[0].print();
		
		videoArray[1] = new Video(2, "탑건2","톰크루즈");
		videoArray[2] = new Video(3, "존윅4","키아누리브스");
		generalMember[0].rental(videoArray[1]);
		generalMember[0].rental(videoArray[2]);

		generalMember[0].print();	// 홍길동 회원의 정보와 대여한 비디오들의 정보를 출력.
		
	}
}
