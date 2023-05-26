package kosa.miniprojectminjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kosa.miniproject.Manager;
import kosa.miniproject.DBMember;
import kosa.phone.DataInput;
import kosa.phone.PhoneInfo;

public class Main {
	
	public static List<DBMember> realMemberList = new ArrayList<DBMember>();
	static Manager manager = new Manager();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		realMemberList.add(new DBMember("1","박민준","890530","사원","개발"));
		realMemberList.add(new DBMember("2","장래호","901205","주임","인사"));
		realMemberList.add(new DBMember("3","윤현웅","890510","대리","영업"));
		realMemberList.add(new DBMember("4","박종찬","890326","과장","개발"));
		realMemberList.add(new DBMember("5","신동하","890712","사원","영업"));
	
		
	}
}
