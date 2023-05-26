package kosa.miniproject;

import java.util.Comparator;

// 조직도 출력을 위해서 부서명 오름차순으로 정렬하는 Comparator 구현 클래스
public class EmpDeptComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;

		return e1.getDept().compareTo(e2.getDept());
	}

}
