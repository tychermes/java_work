package kosa.api;

import java.util.Scanner;

public class RegularExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		String str = sc.nextLine();

		// abc 문자열 포함 여부를 체크.
		if(str.matches(".*abc.*")) {// 임의의 문자열 .(무조건1개)가 <-없거나 여러개 반복 *

			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}

		// 오로지 숫자만 3자리 인지 판단 => 역슬래쉬는 하나만 쓰는게 아니고 2개 => \\
		// ^[0-9]*$^[0-9]*$^[0-9]*$ 이거는 왜 비매칭 뜰까? 
		// ^0$ 보윤: 이건 된다고 함.
		// => 각 반복 사이를 *로 이어주면 또 숫자를 포함한 문자가 되기는 하는데. 쓸모없긴 함...
		// if(str.matches("\\d\\d\\d")) { // 내 방법
		if(str.matches("\\d{3}")) {	// 교수님 방법: {}는 앞의 문자가 반복되는 횟수
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}

		// 알파벳, 숫자만 5자리 이상
		// if(str.matches("[a-zA-Z0-9]+{5}")) { // 내 방법
		if(str.matches("[\\w]{5,}")) { // 교수님 방법
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}
		
		// 한글만 3~5자리
		if(str.matches("^[가-힣]*${3,5}")) { // 교수님 방법
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}

		// 미션: 이메일에 검증
		// dolsam77@nate.com => "매칭"
		// 32dolsam77@nate.com => "비매칭"
		// dolsam77nate.com => "비매칭"
		// dolsam77@nate.comcom => "비매칭" // 근데 이렇게 하면 com이나 net같은 거만 되고 co.kr도 안됨...
		// if(str.matches("^[a-zA-Z]+[a-zA-Z0-9]*@([a-zA-Z0-9]+(.[a-zA-Z]{3}$)")) { //
		// co.kr 안됨
		// if( str.matches("^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,3}$") ) {
		// // co.kr 도 됨.
		if (str.matches("^[\\d]\\w+@\\w+\\.\\w{2,3}$")) { // 교수님 방법 TODO: 왜 대괄호가 들어가고 안들어가고 차이가 있지??
			// 괄호()안의 .은 실제 문자 .인듯. 괄호 밖으로 빼려면 이렇게 \\. 역슬래쉬 두개 쳐줘야 함.
			// 마지막 괄호안에 있는 . 이 표현식.인지, 아니면 실제 문자열.인지? △
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}

		// 일반파일, 이미지파일 구별. 대소문자 구분없이 하는 방법=> (?i)
		// abc.jpg, abc.gif, abc.PNG => 이미지 파일 // abc.txt => 일반 파일
		// if (str.matches("^\\w+\\.([jpg]|[gif]|[png]|[JPG]|[GIF]|[PNG])$")) { // 내 방법: 실패 ㅋ..
		if (str.matches("^\\S+\\.(?i)(jpg|gif|png)$")) { 
			// △ 설명: ^\\S => 첫글자가 공백문자만 '아니면'(\\s는 공백문자, 대문자 쓰면 Not이므로)
			System.out.println("이미지 파일");
		} else {
			System.out.println("일반 파일");
		}
		
		// 정규표현식 지원 메소드 연습
		String message = "SW 개발자 처우와 근무여건 432선진국 수준으로 개선324해야 【서울=뉴시스】김형섭 기자 = 박근혜 대통령은 23일 소프트웨어(SW) 중심사회를 실현하기 위해서는 SW의 가치를 제대로 인정하는 데서 출발해야 한다고 말했다. 박 대통령은 이날 오전 판교 테크노밸리에서 열린 'SW 중심사회 실현 전략보고회'에서 우리나라가 IT 강국으로 지속 발전하기 위해서는 SW 분야의 경쟁력 확보가 시급한 과제라며 이같이 밝혔다. 박 대통령은 시장에서 SW의 가치를 제대로 인정하지 않아 SW 기업들의 수익성이 악화되고, 우수한 인재가 유입되지 않는 악순환의 고리를 끊어야 한다며 공공부문의 SW 제값주기 노력이 민간으로 확산돼 창의성과 노력이 온전히 보답 받는 환경을 조성해 나가도록 노력할 것이라고 약속했다.  이어 그동안 공공 정보화사업이 오히려 민간 SW 시장을 위축시킨다는 지적이 있었는데 민간의 기술과 산업발전을 위한 마중물 역할을 해야 할 정부가 오히려 민간시장을 위축시키는 일이 있어서는 안 될 것이라며 민간시장에 미치는 영향을 사전에 평가하는 등 공공 정보화사업 추진절차를 개선할 필요가 있다고 진단했다.  박 대통령은 또 SW 개발자의 처우와 근무여건도 선진국 수준으로 개선할 필요가 있다며 SW 개발자가 '꿈의 직업'이 돼 최고의 인재들이 유입되고 이들이 SW 산업 발전을 이끌어가고, 그래서 소프트웨어 개발자들의 처우가 더욱 개선되는 선순환 구조를 만들어 나가야 하겠다고 강조했다.  특히 자라나는 미래세대에 대한 SW 교육이 무엇보다 중요하다며 SW 중심사회의 주역이 될 미래 세대가 '컴퓨터적 사고'를 기본소양으로 갖출 수 있도록 초·중등학교에서부터 SW교육을 강화해야 한다고 말했다.";
		
		// replaceAll()메소드를 사용하여, "SW" 라는 문자열을 "소프트웨어"로 치환하기
		String result1 = message.replaceAll("SW", "소프트웨어");
		System.out.println(result1);  // 인자1:정규표현식. 인자2:치환할 문자.
		
		// 문자열 안의 숫자를 모두 제거
		String result2 = message.replaceAll("[0-9]", ""); // [0-9] 또는 \\d도 가능.
		System.out.println(result2);
		
	}

}
