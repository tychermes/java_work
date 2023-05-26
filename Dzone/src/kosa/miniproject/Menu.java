package kosa.miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

	private static boolean loginFlag = false;
	List<Employee> realEmpList = new ArrayList<Employee>();
	public static List<DBMember> realMemberList = new ArrayList<DBMember>();
	Scanner sc = new Scanner(System.in);
	
	public Menu() {
	}

	public void listMemberMenu(ClientMain client) {
		loginFlag = false;
		do {
			System.out.println("1.로그인   2.회원가입   (q.종료)");
			System.out.print("입력:");
			Scanner sc = new Scanner(System.in);
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				if (ClientMain.me == null) {
					ClientMain.me = Util.login(ClientMain.empList);
					if (ClientMain.me != null) {
						loginFlag = true;
						System.out.println("로그인 성공");
						break;
					} else {
						System.out.println("로그인 실패");
					}
				} else {
					System.out.println("이미 로그인 되어 있습니다.");
				}
				break;
			case "2":
				if (ClientMain.me == null) {
					ClientMain.me = Util.join(); // 별도 로그인 절차 없이 자동 로그인
					ClientMain.me.registrate(ClientMain.empList);
					client.updateEmpList();
					loginFlag = true;
					System.out.println("로그인 성공");
					break;
				} else {
					System.out.println("이미 로그인 되어 있습니다.");
				}
				break;
			case "q":
			case "Q":
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}
		} while (!loginFlag);

	}

	public void listGroupwareMenu(ClientMain client) {
		loginFlag = false;
		if (ClientMain.me.getDept().equals("관리") || ClientMain.me.getDept().equals("인사")) {
			ClientMain.me.setPermission("관리");	//관리부, 인사부서 직원은 관리자 모드로 메뉴 진입
			do {
				System.out.println("1.전자결재   2.근태관리   3.사원관리   (q.종료)");
				System.out.print("입력:");
				Scanner sc = new Scanner(System.in);
				String menu = sc.nextLine();

				switch (menu) {
				case "1":
					ApprovalBox apprBox = new ApprovalBox();
					break;
				case "2":
					WorkTable workTable = new WorkTable();
					workTable.showMenu();
					break;
				case "3":
					showEmpMenu();
					break;
				case "q":
				case "Q":
					System.out.println("프로그램 종료.");
					return;
				default:
					System.out.println("잘못 입력했습니다.");
					break;
				}
			} while (!loginFlag);
		} else {	// 일반 권한으로 메뉴 진입
			ClientMain.me.setPermission("일반");
			do {
				System.out.println("1.전자결재   2.근태관리   (q.종료)");
				System.out.print("입력:");
				Scanner sc = new Scanner(System.in);
				String menu = sc.nextLine();

				switch (menu) {
				case "1":
					ApprovalBox apprBox = new ApprovalBox();
					break;
				case "2":
					WorkTable workTable = new WorkTable();
					workTable.showMenu();
					break;
				case "q":
				case "Q":
					System.out.println("프로그램 종료.");
					return;
				default:
					System.out.println("잘못 입력했습니다.");
					break;
				}
			} while (!loginFlag);
		}
	}
	
	public void showEmpMenu() {
		ClientMain.empList.add(new Employee("1","박민준","890530","개발","사원"));
		ClientMain.empList.add(new Employee("2","장래호","901205","인사","주임"));
		ClientMain.empList.add(new Employee("3","윤현웅","890510","영업","대리"));
		ClientMain.empList.add(new Employee("4","박종찬","890326","개발","과장"));
		ClientMain.empList.add(new Employee("5","신동하","890712","영업","사원"));
		do {
			System.out.println("1.사원 검색   2.직책 변경   3.휴대전화번호 수정    4.사원 삭제   (q.이전)");
			System.out.print("입력:");
			Scanner sc = new Scanner(System.in);
			String menu = sc.nextLine();
			String name;
			switch (menu) {
			case "1":
				System.out.print("검색할 사원의 이름을 입력하세요");
				name = sc.nextLine();
				ClientMain.manager.searchEmpInfo(name);
				break;
			case "2":
				System.out.print("직책을 변경할 사원의 이름을 입력하세요");
				name = sc.nextLine();
				ClientMain.manager.updatePosition(name);
				break;
			case "3":
				System.out.print("휴대전화 번호를 변경할 사원의 이름을 입력하세요");
				name = sc.nextLine();
				ClientMain.manager.updatePhoneNo(name);
				break;
			case "4":
				System.out.print("삭제할 사원의 이름을 입력하세요");
				name = sc.nextLine();
				ClientMain.manager.deleteEmpInfo(name);
				break;
			case "q":
			case "Q":
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}
		} while(true);
	}
	
	
}
