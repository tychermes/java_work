package kosa.data;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class SortExample {

	public static void main(String[] args) {
		// sort(자료구조)
		// 기본 정렬 기준: Comparable => compareTo() 오버라이딩 내용.
		// 정렬 기준 변경: Comparator => compare() 오버라이딩 내용.

		Random ran = new Random();
		// TreeSet<Integer> set = new TreeSet<Integer>(); // 디폴트 생성자로 생성
		TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() { 
			// Comparator를 받는 생성자로 생성 => "정렬 기준을 변경하겠다" 라는 의미

			@Override
			public int compare(Integer o1, Integer o2) {
				// 내림차순으로 정렬기준 변경
				if(o1 < o2) {
					return 1; // 자리를 변경하라.
				} else if(o1 > o2) {
					return -1; // 그대로 두어라.
				}
				return 0;
			}
			
		}); // 디폴트 생성자로 생성
		
		for(int i=0; set.size()<6; i++) { // set.size()<6에 유의!
			set.add(ran.nextInt(45)+1);
		}
		System.out.println(set);
	}

}
