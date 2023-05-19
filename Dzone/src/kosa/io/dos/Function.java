package kosa.io.dos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Function {
	
	public static void ls(File file) {
		File[] fileArray = file.listFiles();
		for(File f : fileArray) {
			if(f.isDirectory()) {
				System.out.println(f.getName()+" <DIR>");
			} else {
				System.out.println(f.getName());
			}
		}
	}
	
	public static File cdChild(File file, String name) {
		File cFile = new File(file.getAbsolutePath(), name);
		if(cFile.exists()) {
			return cFile;			
		} else {
			System.out.println("찾으시는 디렉토리가 없습니다.");
			return file;
		}
	}
	
	public static File cdParent(File file) {
		File pFile = file.getParentFile();
		if(pFile == null) {
			return file;
		} else {
			return pFile;
		}
	}
	
	public static void mkdir(File file, String name) {
		File dir = new File(file.getAbsoluteFile(), name);
		dir.mkdirs();
	}
	
	public static void cp(File src, File dst) {
		
		if(src.isDirectory()) {
			dst.mkdir();
			File[] srcList = src.listFiles();
			
			for(File srcFile : srcList) {
				if(srcFile.isDirectory()) {
					File newDst = new File(dst, srcFile.getName());
					newDst.mkdir();
					cp(srcFile, newDst);
				} else {
					cpFile(srcFile, new File(dst, srcFile.getName()));
				}
			}
			System.out.println("파일 복사 완료.");
		}
	}
	
	private static void cpFile(File src, File dst) {

		FileInputStream is = null;
		FileOutputStream os = null;
		byte[] data = new byte[1024];
		int dataLength = 0;
		
		try {
			// CopyExample 에서는 인자가 String(name)이어서 파일이 새로 생성됐는데,
			// 여기에서는 File을 인자로 넣어줌.▽
			is = new FileInputStream(src);
			os = new FileOutputStream(dst);

			while (true) {
				dataLength = is.read(data); // data 배열의 크기만큼 (여기서는 1024)바이트 읽기.
				if (dataLength == -1)
					break; // 파일이 끝날 때 까지
				os.write(data, 0, dataLength); // 읽어들인 data배열에서 0~1024 전까지 만큼을 dest로 복사(출력)
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.flush();// 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움. // TODO: 왜?왜하는데?
				// 검색해보니 OutputStream에서는 아무 일도 수행하지 않는다던데 오히려 inputStream에서 필요한 거 아니야?
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
