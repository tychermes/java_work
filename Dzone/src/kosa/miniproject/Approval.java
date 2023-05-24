package kosa.miniproject;

import java.util.ArrayList;
import java.util.List;

// 결재
public class Approval {
	// ▽ 내가 결재를 올렸거나 결재를 해야 하는 문서 또는 최근 결재가 완료된 문서
	private static List<Approval> personalApprList = new ArrayList<Approval>(); // 결재 리스트
	private static List<Approval> deptApprList = new ArrayList<Approval>(); // 부서 결재 리스트
	private static List<Approval> companyApprList = new ArrayList<Approval>(); // 전사 결재 리스트
	
	private boolean isAttached;	// 첨부 파일 존재 여부 -> 결재함 리스트에서부터 미리 볼 수 있도록.
	private int range; // 공개 범위
//	private static final int 
	
	private String useFrequently; // 자주 쓰는 양식 목록
	private String keyword; // 검색어를 입력하여 문서 검색 가능
	
	private static final int COMPLETE=0;
	private int no;
	private int status;
	private String category;
	
	
	
	
	
}
