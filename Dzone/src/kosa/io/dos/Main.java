package kosa.io.dos;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// T's: 정규표현식
//		FileSystem fileSystem = new FileSystem();//
//		String moveSuperReg = "^cd(\\p{Space})?\\.\\.$";
//		String moveDirReg = "^cd(\\p{Space}.+$";
//		String mkdirReg = "^mkdir(\\p{Space}.+$";
//		String cpReg = "^cp(\\p{Space}.+$";
//		
//		System.out.print(fileSystem.getPresentDirFile().getPath());
//		System.out.print(">");
		
		Scanner sc = new Scanner(System.in);
		File wd = new File("C:/Mission/");

		String[] inputs;
		String pwd;
		do {
			pwd = wd.getAbsolutePath();
			System.out.print(pwd+">");
			inputs = sc.nextLine().trim().split(" +"); //<-공백 여러 개 입력해도 정상처리 하도록 정규표현식 처리
			// TODO: split가 정확히 어떻게 동작하는지 △확인하고 싶음 
			// (명령어와 옵션 중간에 공백을 많이 넣어줬더니 공백이 다 줄지는 않아서.)
			// => 정규표현식으로 가능! split(" ")을 split(" +")로만 바꾸어주어도 해결됨.
			
			// split(" ")을 했더니 cd ..은 cdChild()를 호출하는 문제를 해결. 
			if(inputs[1].equals("..")) { //<-위 코드를 정규표현식으로 수정후, 인덱스 [inputs.length-1]해줄 필요X
				inputs[0] += "..";
			}
			
			switch (inputs[0]) {
			case "ls":
				Function.ls(wd);
				break;
			case "cd":
				wd = Function.cdChild(wd, inputs[1]);
				break;
//			case "cd(\\s)*..": // ..이라는 자식폴더가 만들어짐. 처음부터 정규표현식 썼어야 이게 가능함.
			case "cd..":
				wd = Function.cdParent(wd);
				break;
			case "mkdir":
				Function.mkdir(wd, inputs[1]);
				break;
			case "cp":
				Function.cp(new File(inputs[1]), wd);
				break;
			case "q":
			case "Q":
				return;
			default:
				break;
			}
		} while (true); // !inputs[0].equals("q")

	}

}
