package kosa.miniproject;

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Approval implements Serializable {

	// 공개 범위 지정
	private String range; 	// 공개 범위 
	public static final String PUBLIC="PUBLIC";	//모두에게 공개
	public static final String PRIVATE="PRIVATE";	//전사문서함에 있더라도 PRIVATE면 관련자만 열람 가능

	// 상태 지정
	private String status;
	public static final String WAITING="대기";		// 결재 대기 상태
	public static final String INPROGRESS="진행중";	// 결재가 진행 중인 상태(inChargeList의 사원 객체들이 결재를 시작한 상태)
	public static final String COMPLETE="완료";		// 결재 완료 : 승인 또는 반려 가 된 상태
	
	// 결재 양식(카테고리) 지정
	private String category;
	public static final String PROPOSAL = "기안서"; // 진행하고자 하는 사안에 대해서 설명을 하고 검토 후 허락을 바라는 서류. 사업이나 활동 계획의 초안 (품의서보다 포괄적 내용 보고)
	public static final String REPORT = "품의서"; // 품의서는 허락을 득하기 위한 서류.(품의서는 지출승낙)(이미 사용한 경비/이미 진행된 사항 보고 및 허락 포함)
	public static final String SICK_LEAVE = "병가신청서";
	public static final String ANNUAL_LEAVE = "연차신청서";
	public static final String EARLY_LEAVE = "조퇴신청서";
	public static final String EXPENSE = "지출결의서"; // 회사 내 지출이 예상되는 비용을 사전에 승인 요청 (지출결의서는 승낙한 대금지불)
	
	// 보존 기한 지정
	private Date submitDate; // 올린 날짜
	private Date limitDate;	// 결재 문서 보존 연한
	
//	private List<Employee> inChargeList = new ArrayList<Employee>();
	private Employee drafter, approver;  //기안자, 결재자, 
	private String contents;
	// 일반 필드
	private int no;				// 결재 번호
	
	// 생성자 ========================================================================
	public Approval() {}

	// 기안자, 결재자만.
	public Approval(Date submitDate, Date limitDate, String category,
			Employee drafter, Employee approver, String contents, int no) {
		this.range = PRIVATE;
		this.status = WAITING;		
		this.submitDate = submitDate;
		this.limitDate = limitDate;
		this.category = category;
		this.drafter = drafter;
		this.approver = approver;
		this.contents = contents;
		this.no = no;
	}
	// Method =========================================================
	public void write() {
		
	}
	// 결재 기안 1개 요약 읽어오기 // ApprovalBox에서 리스트 출력 할 때 필요함.
	public void readOutline() {
		System.out.println("------------------------------------------------------------");
		System.out.println("카테고리: " + getCategory());
		System.out.println("결재자: " + getApprover().getDept() + " 부서 " + getApprover().getName() + " "
				+ getApprover().getPosition());
		System.out.println("결재 마감일: " + getLimitDate().toString());
		System.out.println("결재 내용: " + getContents().toString());
		System.out.println("------------------------------------------------------------");
	}
	
	// Getter & Setter ====================================================
	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

//	public List<Employee> getInChargeList() {
//		return inChargeList;
//	}
//
//	public void setInChargeList(List<Employee> inChargeList) {
//		this.inChargeList = inChargeList;
//	}

	public Employee getDrafter() {
		return drafter;
	}

	public void setDrafter(Employee drafter) {
		this.drafter = drafter;
	}

	public Employee getApprover() {
		return approver;
	}

	public void setApprover(Employee approver) {
		this.approver = approver;
	}

//	public Employee getAgreeer() {
//		return agreeer;
//	}
//
//	public void setAgreeer(Employee agreeer) {
//		this.agreeer = agreeer;
//	}
//
//	public Employee getCc() {
//		return cc;
//	}
//
//	public void setCc(Employee cc) {
//		this.cc = cc;
//	}
//
//	public Employee getExecutor() {
//		return executor;
//	}
//
//	public void setExecutor(Employee executor) {
//		this.executor = executor;
//	}

//	public String getUseFrequently() {
//		return useFrequently;
//	}
//
//	public void setUseFrequently(String useFrequently) {
//		this.useFrequently = useFrequently;
//	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public File getFormattedAppr() {
//		return formattedAppr;
//	}
//
//	public void setFormattedAppr(File formattedAppr) {
//		this.formattedAppr = formattedAppr;
//	}
//
//	public File getAttachedFile() {
//		return attachedFile;
//	}
//
//	public void setAttachedFile(File attachedFile) {
//		this.attachedFile = attachedFile;
//	}

	public static String getPublic() {
		return PUBLIC;
	}

	public static String getPrivate() {
		return PRIVATE;
	}

	public static String getWaiting() {
		return WAITING;
	}

	public static String getInprogress() {
		return INPROGRESS;
	}

	public static String getComplete() {
		return COMPLETE;
	}
	
	@Override
	public String toString() {
		return "결재 ["+ "결재 번호: " +no +", 공개 범위: " + range + ", 상태: " + status + ", 결재 양식: " + category + ", 제출일: "
				+ submitDate + ", 결재 기한: " + limitDate + ", 기안자:" + drafter.toString() + ", 결재자: " + approver.toString() + "]";
	}
	
	
}
