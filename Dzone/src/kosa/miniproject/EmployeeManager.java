package kosa.miniproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;



public class Manager {

	List<Employee> rEmp = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	
	public void searchEmpInfo(String name) {
		System.out.println("=========================");
		

		for (Employee empInfo : rEmp) {
			if (empInfo.getName().equals(name)) {
				System.out.println("사번: " + empInfo.getEmpNo());
				System.out.println("이름: " + empInfo.getName());
				System.out.println("주민번호: " + empInfo.getSocialNo());
				System.out.println("직책: " + empInfo.getPosition());
				System.out.println("부서: " + empInfo.getDept());
				System.out.println("전화번호: " + empInfo.getPhoneNo());
				System.out.println("아이디: " + empInfo.getId());
				System.out.println("비밀번호: " + empInfo.getPw());
			}
		}
	}
	
	
	public void updatePosition(String position) {
		for (Employee empInfo : rEmp) {
			if (empInfo.getPosition().equals(position)) {
				System.out.println("수정 전 직책 :" + empInfo.getPosition());
				System.out.print("수정할 직책 :");
				empInfo.setPosition(sc.nextLine());
				break;
			} else {
				System.out.println("존재하지 않는 직책입니다.");
			}
		}
		System.out.println("정보가 수정되었습니다.");
	}
	
	public void updatePhoneNo(String phoneNo) {
		for (Employee empInfo : rEmp) {
			if (empInfo.getPhoneNo().equals(phoneNo)) {
				System.out.println("수정 전 전화번호 :" + empInfo.getPhoneNo());
				System.out.print("수정할 전화번호 :");
				empInfo.setPhoneNo(sc.nextLine());
				break;
			} else {
				System.out.println("존재하지 않는 번호입니다.");
			}
		}
		System.out.println("번호가 수정되었습니다.");
	}

	

	public void deleteEmpInfo(String empNo) {
		for (Employee empInfo : rEmp) {
			if (empInfo.getEmpNo().equals(empNo)) {
				System.out.println("삭제할 이름이 " + empInfo.getName() + "이(가) 맞습니까?");
				System.out.println("맞으면 1, 틀리면 2를 입력하세요.");
				System.out.print("입력: ");
				String num = sc.nextLine();
				
				switch (num) {
				case "1":
					rEmp.remove(empInfo);
					System.out.println("삭제가 완료되었습니다.");
					return;
				case "2":
					System.out.println("처음으로 돌아갑니다.");
					return;
				}
			}
		}
	}
}
	
	


