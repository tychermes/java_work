package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	// 현재 시간 구하는 API 여러 개 중 하나

	public static void main(String[] args) {
		Date now = new Date();
		String str = now.toString();
		System.out.println(str);

		// MM이 month고 mm은 분 인가봄..
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String str2 = sdf.format(now);
		System.out.println(str2);
	}

}
