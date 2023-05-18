package kosa.io;

import java.io.File;

public class FileMission {

	public static void main(String[] args) {
		// 1. 바이트 스트림을 이용하여 이미지 파일을 복사해 보자.
		String source = "C:\\Douzone\\git\\java_work\\Dzone\\sample.jpg";
		String dest =  "C:\\Users\\KOSA\\Desktop\\sample.jpg";
		
		CopyUtil.copyFile(new File(source), new File(dest));
		
		
		String source2 = "C:\\Douzone\\git\\java_work\\Dzone\\src\\kosa\\mission";
		String dest2 =  "C:\\Users\\KOSA\\Desktop\\"; 
		// Desktop 안에 mission이라는 폴더를 생성해서 집어넣을 거임
		CopyUtil.copyDirectory(new File(source2), new File(dest2));
		// ▽ T's solution
		CopyUtil.copyDir(new File(source2), new File(dest2));
		
		

	}

}
