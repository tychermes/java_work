package kosa.io;

import java.io.File;

public class FileExample2 {

	// 해당하는 디렉토리 안에 또 디렉토리가 있을 때에 그안의 목록들까지 계속 출력되도록.
	static int level;
	public static void show(File file) {
		File[] list = file.listFiles();
		for(File f : list) {
			for(int i=0; i<level; i++) {
				System.out.print("\t");
			}
			if(f.isDirectory()) {
				System.out.println("<DIR> "+f.getName());
				show(f); // 재귀함수 호출
			} else {
				System.out.print("\t");
				System.out.println(f.getName());
			}
		}
		level++;
	}
	
//	// T's solution
//	public static void show(File file) { 
//		File[] list = file.listFiles();
//		for(int i=0; i<list.length; i++) {
//			if(list[i].isDirectory()) {
//				System.out.println("\t<DIR> "+list[i].getName());
//				show(list[i]);
//			} else {
//				System.out.println("\t"+list[i].getName());
//			}
//		}
//	}
	
	public static void main(String[] args) {
		String path = "C:\\Douzone\\git\\java_work\\Dzone\\src"; 
		// 위의 절대 경로를 파일 클래스로 표현하기
		File f = new File(path);
		show(f);
	}
}
