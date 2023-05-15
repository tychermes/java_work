package kosa.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class ListExample {
	// 1~45 중복되지 않는 로또번호 6개를 출력하자.
	public static void main(String[] args) {

		
		// 1.배열로 구현
		int[] array = new int[6];
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*45) + 1; // 난수 생성
			for(int j=0; j<i; j++) {
				if(array[i]==array[j]) {
					// 중복 발생, 다시 난수 생성
					array[i] = (int)(Math.random()*45) + 1;
					continue; // 일단 인덱스 j++하지 않고 위로 돌아가서 다시 비교하도록.
					//i = i-1; // 교수님은 윗 두줄 안쓰고 i=i-1;만 하셨음.(이게 더 스마트한 듯)
				}
			}
			System.out.print(array[i]+", ");
		} System.out.println();
		
		// 2.List 구현(contains(정수)) 
		List<Integer> intList = new ArrayList<Integer>();
//		//내 솔루션.
//		// for(Integer ran : intList) { //←아직 array가 초기화 된 것이 아니기 때문에, for문 진입X.
//		for(int i=0; i<6; i++) { //←조건에 intList.size()하면 0 반환하여 for문 진입X.
//			intList.add((int)(Math.random()*45) + 1);
//			if(intList.contains(intList.get(i))) continue;
//		}
//		System.out.println(intList.toString());
		
		// T's: 랜덤 객체 생성.
		Random r = new Random();
		// T's: 
		while(true) {
			int n = r.nextInt(45) + 1; // 0~44까지(45이전까지) 정수 중 하나 반환, +1
			if(intList.contains(n)) {
				continue;
			} else {
				intList.add(n);
			}
			if(intList.size()==6) break;
		}
		System.out.println(intList.toString());
		
		// 3.Set 구현 (TreeSet) => 애초에 중복 허용X
		TreeSet<Integer> intSet = new TreeSet<Integer>();
		for(int i=0; i<6; i++) { 
		// for(int i=0; set.size()<6; i++) { //으로 해주어도, 중복되지 않는 값이 6개 들어가있다 라는 뜻이 됨.
			int ran = (int)(Math.random()*45) + 1;
			intSet.add(ran);
			// System.out.print(ran+", "); // Set은 순서가 없으므로, 일단 그냥 ran변수에 집어넣고 프린트 하겠음. 
		} 
		System.out.println(intSet.toString()); // △ 그러지 말고 그냥 toString()해.. TreeSet은 오더가 있어...
		

	}

}
