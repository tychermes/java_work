package kosa.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyUtil {

	// 디렉토리 복사(새로운 디렉토리 생성 후, 특정 디렉토리 안의 파일들을 모두 복사)
	// 파일 한 개를 복사하는 메소드를 사용. 디렉토리 속 디렉토리 안의 내용까지 모두 복사 - 재귀함수 사용.
	public static void copyDirectory(File src, File dest) {
		if (src.isDirectory()) { // 난 이걸 빼먹었는데, 굉장히 중요함! 그냥 일반파일에 이렇게 하면 안됨.
			// 왜냐면 만약 디렉토리가 아닌 일반 파일이라면 애초에 listfiles()할 수 없으므로.
			File destDir = new File(dest, src.getName());
			destDir.mkdirs(); // Desktop 안에 mission이라는 폴더를 생성해서 집어넣을 거임 (mkdir말고 mkdirs)
			File[] srcFileList = src.listFiles();
			for (File srcFile : srcFileList) {
				File newDest = new File(destDir.getAbsolutePath(), srcFile.getName());
				if (srcFile.isDirectory()) { // 디렉토리
					newDest.mkdir();
//				System.out.println(f.getName());
//				System.out.println(dest.getAbsolutePath());
					copyDirectory(srcFile, newDest);
				} else { // 일반 파일
					copyFile(srcFile, newDest);
				}
			}
		}
	}

	// T's solution
	public static void copyDir(File src, File dest) {
		if (src.isDirectory()) {
			dest.mkdirs(); // mkdir은 상위 디렉터리가 없는 경우 생성하지 못하지만,
			// mkdirs는 상위 디렉터리가 없으면 생성한다.
			File[] fileList = src.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				File sourceFile = fileList[i];
				File s_destFile = new File(dest, sourceFile.getName());
				if (sourceFile.isDirectory()) {
					copyDir(sourceFile, dest); //
				} else {
					copyFile(sourceFile, new File(dest, src.getName()));
				}
				// 지금 s_destFile을 안썼는데... 내가 뭘 잘못 받아적은 것 같은데...
			}
		}
	}

	// 바이트 값을 가진 파일 한 개를 복사하는 메소드
	public static void copyFile(File src, File dest) {

		InputStream is = null; // FileInputStream is = null; 이렇게 해주어도 됨.
		OutputStream os = null; // FileOutputStream os = null; 이렇게 해주어도 됨.
		byte[] data = new byte[1024];
		int dataLength = 0;

		try {
			// CopyExample 에서는 인자가 String(name)이어서 파일이 새로 생성됐는데,
			// 여기에서는 File을 인자로 넣어줌.▽
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);

			while (true) {
				dataLength = is.read(data); // data 배열의 크기만큼 (여기서는 1024)바이트 읽기.
				if (dataLength == -1)
					break; // 파일이 끝날 때 까지
				os.write(data, 0, dataLength); // 읽어들인 data배열에서 0~1024 전까지 만큼을 dest로 복사(출력)
			}
			System.out.println("파일 복사 완료.");
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
