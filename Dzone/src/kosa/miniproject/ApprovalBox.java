package kosa.miniproject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// 결재
public class ApprovalBox {
	private static int apprCount; // 결재 번호가 될 카운터
	// ▽ 내가 결재를 올렸거나 결재를 해야 하는 문서 또는 최근 결재가 완료된 문서
	public static List<Approval> apprList = new ArrayList<Approval>(); // 결재 리스트
//	private List<Approval> deptApprList = new ArrayList<Approval>(); // 부서 결재 리스트
//	private List<Approval> companyApprList = new ArrayList<Approval>(); // 전사 문서함? 전사 공문 발송함??
	// 전사 문서함은 일단 결재 시스템은 아님! 구현 안해도 되는 것.
	// 전사 문서함 관리자는 사이트 어드민에서 지정할 수 있습니다. 전사 문서함 관리자 외 사용자에게는 이동이나 삭제 버튼이 보이지 않음.
//	private List<Approval> ccApprList = new ArrayList<Approval>(); // 참조열람 결재 리스트// 참조자도 결국 같은 부서..

	private String keyword; // 필요시 검색어를 입력하여 문서 검색 가능

	public ApprovalBox() {
		do {
			System.out.println("1.결재 요청   2.결재요청함 확인   3.결재대기함 확인   4. (q.이전)");
			System.out.print("입력:");
			Scanner sc = new Scanner(System.in);
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				submitAppr();
				break;
			case "2":
				showRequestList();
				break;
			case "3":
				showApprList();
				break;
			case "4":
				deleteAppr();
				break;
			case "q":
			case "Q":
				System.out.println("이전으로 돌아갑니다.");
				return;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		} while (true);

	}

	// Method ====================================================================
	// 결재 요청 리스트 보기
	public void showRequestList() {
		for (Approval appr : apprList) {
			System.out.println("showRequestList");
			appr.readOutline(); // 본인이 결재자 포지션인 결재 정보만 리스트 출력
		}
		show();
	}
	
	// 결재 리스트 보기
	public void showApprList() {
		for (Approval appr : apprList) {
			if (appr.getApprover().getEmpNo().equals(ClientMain.me.getEmpNo())) {
				System.out.println("showApprList");
				appr.readOutline(); // 본인이 결재자 포지션인 결재 정보만 리스트 출력
			}
		}
		show();
	}
	
	// 결재 하나 보기
	public void show() {
		boolean flag = false;
		do {
			System.out.println("확인할 결재 번호를 입력하세요. (q.이전)");
			System.out.print("입력: ");
			Scanner sc = new Scanner(System.in);
			String apprNo = sc.nextLine().trim();
			if(apprNo.equals("q") || apprNo.equals("Q")) {
				return;
			}
			for (Approval appr : apprList) {
				if(appr.getNo()==((int)(Integer.parseInt(apprNo)))) {
					appr.readOutline();
					flag = true;
				}
			}
			if(!flag) {
				System.out.println("결재 번호가 정확하지 않습니다.");
				continue;
			}
		} while (true);
	}

	public void deleteAppr() {
		boolean flag = false;
		do {
			System.out.println("삭제할 결재 번호를 입력하세요. (q.이전)");
			System.out.print("입력: ");
			Scanner sc = new Scanner(System.in);
			String apprNo = sc.nextLine().trim();
			if(apprNo.equals("q") || apprNo.equals("Q")) {
				return;
			}
			for (Approval appr : apprList) {
				if(appr.getNo()==((int)(Integer.parseInt(apprNo)))) {
					apprList.remove(appr);
					flag = true;
				}
			}
			if(!flag) {
				System.out.println("결재 번호가 정확하지 않습니다.");
				continue;
			}
		} while (true);
	}

//	// downloadList() : 문서함의 결재 문서 목록을 csv 형태로 다운로드 : 개인 문서함, 부서 문서함, 전사 문서함.
//	public void downloadList() {
//
//	}
//
//	// download() : 문서함의 결재 문서를 html 형태로 다운로드 : 기안(요청) 문서함, 수신 문서함.
//	public void download() {
//
//	}
//
//	// 문서함의 결재 문서들에서 검색하는 기능. (실행 시간이 오래 걸릴 듯..?)
//	// 카테고리 제목, 문서 제목, 문서 내용, 기간, 첨부파일명, 기안자명 -에서 검색어와 맞는 항목이 있으면 결과로 보여줌
//	public void search() {
//
//	}

	// 결제 요청 기능들 ===============
	// 결제 제출(요청)
	// 결제 객체 만들기 // 내부적으로 approval.write()를 불러 파일이 생성되도록..?
	public void submitAppr() {
		String prevStr = ""; // 일단 쓰지 말기
		Scanner sc = new Scanner(System.in);
		boolean cate = false;
		boolean appr = false;
		boolean date = false;
		boolean check = false;
		boolean con = false;
		boolean flag = false;

		// Approval 생성자 인자로 들어갈 변수 선언 및 초기화
		Date submitDate = null;
		Date limitDate = null;
		String category = null;
		File formattedAppr = null;

		Employee drafter = null;
		Employee approver = null;
//		Employee agreeer = null;
//		Employee cc = null;
//		Employee executor = null;

		String contents = null;

		do {
			// 결재 양식 선택
			while (!cate) {
				cate = false;
				System.out.println("카테고리를 선택하세요.");
				System.out.println("1." + Approval.PROPOSAL + "   2." + Approval.REPORT + "   3." + Approval.SICK_LEAVE
						+ "   4." + Approval.ANNUAL_LEAVE + "   5." + Approval.EARLY_LEAVE + "   6." + Approval.EXPENSE
						+ prevStr);
				System.out.print("입력: ");
				category = sc.nextLine().trim();
				if (!(category.matches("1|2|3|4|5|6|p|P"))) {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				if (category.matches("p|P")) {
//					System.out.println("이전단계. 결재 생성 메소드 종료.");
//					return; // 결재 생성 메소드 종료 // TODO:여기 이상해..
				} else { // category 메뉴 정상 입력 받음.
					System.out.println("category 메뉴 정상 입력 받음. " + category + "번.");
					cate = true;
					break;
				}
			}
			if (!cate)
				continue;

			// 여기에서 조직도 띄우기
			showOrgChart();

			// 기안자 (본인의 사원 객체)
			drafter = ClientMain.me;

			// 결재자 선택
			while (!appr) {
				System.out.println("결재자 사번을 선택하세요." + prevStr);
				System.out.print("입력: ");
				String empNo = sc.nextLine().trim();
				if (empNo.equals(drafter.getEmpNo())) {
					System.out.println("결재자로 본인을 선택할 수 없습니다.");
					continue;
				}
				for (Employee e : ClientMain.empList) {
					if (empNo.equals(e.getEmpNo())) { // empNo가 empList에 있으면.
						System.out.println("사번이 일치하는 사원 존재: " + e.getName());
						approver = e; // 해당 결재자 사원 객체 대입
						appr = true;
						break;
					}
				}
				if (!appr) {// empNo가 empList에 없으면.
					System.out.println("사번이 일치하는 사원이 없습니다.");
					continue;
				} else {// empNo가 empList에 있으면.
					System.out.println("다음 단계로.");
				}
			}
			if (!appr)
				continue;

			Calendar cal = Calendar.getInstance();
			submitDate = cal.getTime(); // 제출일에 오늘 날짜 받아오기

			// 형식이 옳을 때 까지 계속 입력받기
			while (!date) {
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				System.out.println("결재 기한을 입력하세요. (예시:2023/05/26)" + prevStr);
				System.out.print("입력: ");
				while (sc.hasNextLine()) { // hasNextLine()은 입력값을 받는 한 true 반환. 얘도 입력을 기다림.
					try {
						String input = sc.nextLine();
						limitDate = df.parse(input);
						// 입력받은 날짜 형식을 Date객체에 반환 대입하여, 내가 지정한 형식이 아니라면 예외 발생하도록.
						if (submitDate.compareTo(limitDate) > 0) {
							// submitDate가 limitDate보다 이후 날짜이면,
							System.out.println("현재 날짜보다 이전 날짜를 입력할 수 없습니다.");
							System.out.print("입력: ");
						} else {
							date = true;
							break; // 문제 없으면 while문 탈출.
						}
					} catch (Exception e) {
						System.out.print("예시에 맞추어 다시 입력 바랍니다: ");

					}
				}
			}
			if (!date)
				continue;

			// 결제 제출 전 요약정보 출력하고 확인받기
			while (!check) {
				System.out.println("결재 내용을 입력하세요.");
				System.out.print("입력: ");
				contents = sc.nextLine().trim();
			
				System.out.println("------------------------------------------------------------");
				System.out.println("카테고리: " + category);
				System.out.println(
						"결재자: " + approver.getDept() + " 부서 " + approver.getName() + " " + approver.getPosition());
				System.out.println("결재 마감일: " + limitDate.toString());
				System.out.println("결재 내용: " + contents.toString());
				System.out.println("------------------------------------------------------------");
				System.out.println("결제를 제출하시겠습니까?(y:제출/n:수정/q:종료)");
				System.out.print("입력: ");
				String input = sc.nextLine().trim();
				if (input.matches("q|Q")) {
					System.out.println("Q입력 : createAppr() 메소드 종료.");
					return;
				} else if (input.matches("y|Y")) {
					System.out.println("Y입력.");
					check = true; // 제출
					flag = true;
				} else if (input.matches("n|N")) {
					System.out.println("N입력");
					check = false;
//					check = true; // 여기 왜 이렇게 되는지 모르겠는데 하여간 됨....왜 돼는데..?
				} else {
					System.out.println("다시 입력 바랍니다: ");
				}
			}
			if (!check)
				continue;

			// 다시 초기화
			System.out.println("플래그들 다시 초기화.");
			cate = false;
			appr = false;
			date = false;
			con = false;

		} while (!flag);

		System.out.println("큰 while 빠져나옴. createAppr() 메소드 종료. 결과 제출 여부: " + (check ? "Y" : "N"));

		// 결재 기안 객체 생성
		apprList.add(new Approval(submitDate, limitDate, category, drafter, approver, contents, apprCount++));
//		Approval approval = new Approval(submitDate, limitDate, category, drafter, approver, contents, apprCount++);
//		Approval approval = new Approval(submitDate, limitDate, category, formattedAppr, drafter, approver, apprCount++);
	}

	// 조직도 보기
	public void showOrgChart() {
		Collections.sort(ClientMain.empList, new EmpDeptComparator()); // 부서명 오름차순 정렬
		Iterator<Employee> iter = ClientMain.empList.iterator();
		System.out.println("------------------------------------------------------------");
		while (iter.hasNext()) {
			Employee e = iter.next();
			System.out.printf("부서:%-7s\t| 직책:%-7s\t| 이름:%-7s\t| 사번:%-7s \n", e.getDept(), e.getPosition(), e.getName(),
					e.getEmpNo());
		}
		System.out.println("------------------------------------------------------------");
	}

}
