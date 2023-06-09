package kosa.io;

import java.io.File;
import java.util.GregorianCalendar;

public class FileExample {

	public static void main(String[] args) {
		
		String fileName1 = ".";
		String fileName2 = "C:\\Douzone\\git\\java_work\\Dzone";
		String fileName3 = "c:\\douzone\\git\\java_work\\Dzone"; 
		// 자바 디렉토리 대소문자 상관 있다고 나오는데 실제로 해보니까 상관없이 다 잘되네...
		
		File file = new File(fileName3);
		
		File[] arr = file.listFiles();
		for(File f : arr) {
			if(f.isFile()) {
				System.out.printf("%-20s %7d\t", f.getName(), f.length());
				
			} else {
				System.out.printf("%-20s    <DIR>\t", f.getName());
			}
			long time = f.lastModified();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTimeInMillis(time);
			System.out.printf("%1$tF %1$tT %n", calendar);
			
		}
	}

}
