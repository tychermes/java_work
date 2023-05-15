package kosa.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExample02 {

	public static void main(String[] args) {
		String data[] = {
				"bat", "bba", "bbg", "24bonus",
				"CA", "ca", "c2322", "car",
				"7date", "dic42", "dir34aaa", "a"
		};
		
		// 내가 만드는 예제 =================================================
		// MyEx 1. c로 시작하는 알파벳 문자열들을 찾기.(대소문자 구분x)
		Pattern p = Pattern.compile("(?i)c[a-z]*"); 
		for(int i=0; i<data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches()) {
				System.out.print(data[i]+", ");
			}
		} System.out.println();
		
		// MyEx 2. 첫글자 제외하고, 숫자가 포함된 문자열들을 찾기
		Pattern p2 = Pattern.compile("^[^0-9]+[0-9]+.*"); 
		// .* 아무거나 여러개 있든지, 하나도 없든지('아무거나'일 때는 굳이 뒤에 $를 붙여줄 필요가 없음...)
		for(int i=0; i<data.length; i++) {
			Matcher m = p2.matcher(data[i]);
			if(m.matches()) {
				System.out.print(data[i]+", ");
			}
		} System.out.println();
		
		// MyEx 3. 동일한 문자 중복이 포함된 문자열들을 찾기
//		Pattern p3 = Pattern.compile("[\\w]{2,}+"); 
//		for(int i=0; i<data.length; i++) {
//			Matcher m = p3.matcher(data[i]);
//			if(m.matches()) {
//				System.out.print(data[i]+", ");
//			}
//		}
		
		// 다시 수업 ==========================================
		String source = "ab?cd?ef?gh";
		String regex = "(\\w*)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);

		while(matcher.find()) {
			System.out.print(matcher.group()+", "); // 첫 번째, 두 번째, 세 번째 그룹을 찾아서 출력
		}System.out.println();
		
		// 전화번호 두개만 그룹으로 뽑기
		String source2 = "HP: 010-1111-1111, HOME: 02-222-2222";

		// String regex2 = "\\d{2,3}-\\d{3,4}-\\d{4}";	// 보윤이랑 교수님 답
		// △ 역슬래쉬 안하고 슬래쉬 해버림 ㅠㅠ 그러니까 답이 안나오지.
		String regex2 = "\\d+-\\d+-\\d+"; // 내 답.(근데 사실 위에꺼가 완전 전화번호 형식이 맞지)
		
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(source2);

		while(matcher2.find()) {
			System.out.print(matcher2.group()+", ");
		}
		System.out.println();
			
//		String[] group = source.splite(regex); // 이건 몬데 하다말음...

	}

}
