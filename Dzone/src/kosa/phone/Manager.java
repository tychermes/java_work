package kosa.phone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kosa.io.Member;

// 비지니스 로직
public class Manager {
	private List<PhoneInfo> phoneList;

	public Manager() {
		super();
		phoneList = new ArrayList<PhoneInfo>();
	}

	// static이 아니므로, main()에서 그냥 사용할 수 없다. 멤버메소드는 객체를 생성해야만 그때 메모리에 올라가게 된다.
	public void addPhoneInfo() {
		System.out.print("이름을 입력하세요: ");
		String name = DataInput.sc.nextLine().trim();
		System.out.print("전화번호를 입력하세요: ");
		String phoneNo = DataInput.sc.nextLine().trim();
		System.out.print("생년월일을 입력하세요: ");
		String birth = DataInput.sc.nextLine().trim();
		// 2023.05.10 수정. // 2023.05.17 수정.
		// 처음에 메뉴가 나와서 1.일반 2.대학 3.직장 나눠서 저장하고 싶다면!
		boolean flag = true;
		while (flag) {
			System.out.println("저장할 카테고리를 선택하세요: ");
			System.out.print("1.일반   2.대학   3.직장: ");
			String category = DataInput.sc.nextLine().trim();	
			// switch 안의 내용을 int로 바꾸면, "ㄱ" 등 문자열로 잘못 입력되었을 때, NumberFormatException 이 발생하는데,
			// 괜히 그럴 필요 없이 조건을 String 받도록 하면 되잖아....
			switch (category) {
			case "1":
				phoneList.add(new PhoneInfo(name, phoneNo, birth));
				flag = false;
				break;
			case "2":
				System.out.print("전공을 입력하세요: ");
				String major = DataInput.sc.nextLine().trim();
				System.out.print("학번을 입력하세요: ");
				String year = DataInput.sc.nextLine().trim();
				phoneList.add(new University(name, phoneNo, birth, major, year));
				flag = false;
				break;
			case "3":
				System.out.print("부서를 입력하세요: ");
				String department = DataInput.sc.nextLine().trim();
				System.out.print("직급을 입력하세요: ");
				String position = DataInput.sc.nextLine().trim();
				phoneList.add(new Company(name, phoneNo, birth, department, position));
				flag = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	public void listPhoneInfo() {
		// 향상된 for문을 손코딩하라고 하면 못할 것 같음... 왼쪽 오른쪽 인자 잘 기억하자.
		// 1.일반 2.대학 3.직장
		System.out.println("출력할 카테고리를 선택하세요: ");
		System.out.print("1.일반   2.대학   3.직장   4.전체 : ");
		String category = DataInput.sc.nextLine().trim();
		boolean flag = true;
		while (flag) {
			switch (category) {
			case "1":
				for (PhoneInfo pInfo : phoneList) {
					if (pInfo instanceof Company || pInfo instanceof University) {
					} else {
						pInfo.print();
					}
				}
				flag = false;
				break;
			case "2":
				for (PhoneInfo pInfo : phoneList) {
					if (pInfo instanceof University) {
						pInfo.print();
					}
				}
				flag = false;
				break;
			case "3":
				for (PhoneInfo pInfo : phoneList) {
					if (pInfo instanceof Company) {
						pInfo.print();
					}
				}
				flag = false;
				break;
			case "4":
				for (PhoneInfo pInfo : phoneList) {
					pInfo.print(); // TODO: 다형성!!!!!!!!!!!!!!!!!!
					// 모두 PhoneInfo 데이터타입임에도 불구하고,
					// 각자가 가진 print()메소드의 내용에 따라 3줄~5줄을 프린트하게 된다.
				}
				flag = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}

	}

	// 배열로 할 때에는, flag대신에 idx = -1하고서, for문 if안에서 idx에 증가하는 i값을 넣어준다.
	// 나중에도 여전히 -1이라면 끝까지 검색하지 못한 것. 따라서 "존재하지 않습니다" 메시지 출력.
	public void searchPhoneInfo() {
		System.out.print("검색할 전화번호부의 이름을 입력하세요: ");
		String searchName = DataInput.sc.nextLine().trim();

		boolean flag = false;
		for (PhoneInfo pInfo : phoneList) {
			if (pInfo.getName().contains(searchName)) {
				pInfo.print();
				flag = true;// (일치하는 이름을 찾았다는 것을 for 바깥에서도 기억하도록)
				break;
			}
		}
		if (!flag) {
			System.out.println("찾으시는 이름이 없습니다.");
		}
	}

	public void modifyPhoneInfo() {
		System.out.print("수정할 전화번호부의 이름을 입력하세요: ");
		String modifyName = DataInput.sc.nextLine().trim();

		boolean flag = false;
		for (PhoneInfo pInfo : phoneList) {
			if (pInfo.getName().contains(modifyName)) {
				pInfo.modify();
				flag = true;// (일치하는 이름을 찾았다는 것을 for 바깥에서도 기억하도록)
				break;
			}
		}
		if (!flag) {
			System.out.println("찾으시는 이름이 없습니다.");
		}
	}

	public void removePhoneInfo() {
		System.out.print("삭제할 전화번호부의 이름을 입력하세요: ");
		String removeName = DataInput.sc.nextLine().trim();

		boolean flag = false;
		for (PhoneInfo pInfo : phoneList) {
			if (pInfo.getName().contains(removeName)) {
				phoneList.remove(pInfo);
				flag = true; // (일치하는 이름을 찾았다는 것을 for 바깥에서도 기억하도록)
				break; // 브레이크 꼭! 중요! 없으면 특히 remove()시 오류를 일으킴.
				// △없으면 ConcurrentModificationException 예외...
			}
		}
		if (!flag) {
			System.out.println("찾으시는 이름이 없습니다.");
		}
	}

	public void sortPhoneInfo() {
		String input;
		System.out.println("1.이름 오름차순   2.생년월일 오름차순   3.전화번호 오름차순   4.뒤로 가기");
		System.out.print("정렬 기준을 선택하세요: ");
		input = DataInput.sc.nextLine().trim();
		switch (input) {
		case "1":
			sortByAscWithName();
			break;
		case "2":
			sortByAscWithBirth();
			break;
		case "3":
			sortByAscWithPhoneNo();
			break;
		case "4":

			break;
		default:
			System.err.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	// 객체 직렬화 메소드(저장)
	public void savePhoneInfo() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object_list.txt"));
			oos.writeObject(phoneList);
			System.out.println("저장 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 객체 역직렬화 메소드(불러오기)
	public void loadPhoneInfo() {
		// this.phoneList = null; // 현재 메모리 상의 객체는 kill..<-하지마 그런 연락처 앱이 어딨어!
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("object_list.txt"));
			this.phoneList.addAll((List)ois.readObject()); 
			//List<PhoneInfo>클래스 (또는 그냥 List클래스)로 △  캐스팅 필요
			System.out.println("불러오기 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Sort Method ======================== ▽아래 코드들이 너무 길어서 람다식으로 하면 좋을텐데...
	public void sortByAscWithName() {
		Collections.sort(phoneList);
		// 내가 PhoneInfo 안의 compare()를 name기준우로 오름차순 정렬하도록 오버라이딩 해놓았기 때문에 제대로 잘 정렬됨.
		// 아래 정렬기준들(Birth, PhoneNo)들과 조금 차별이라는 느낌이 들면.. 여기에도 익명내부클래스로 오버라이딩 구현하면 됨.
	}

	public void sortByAscWithBirth() {
		Collections.sort(phoneList, new Comparator<PhoneInfo>() {

			@Override
			public int compare(PhoneInfo o1, PhoneInfo o2) {
				// 이름을 기준으로 오름차순
				// String: 앞쪽문자열.compareTo(뒷쪽문자열)
				if (o1.getBirth().compareTo(o2.getBirth()) > 0) {
					// △리턴: a value greater than 0 if this string is lexicographically greater than
					// the string argument.
					return 1; // 자리를 변경하라.
				} else if (o1.getBirth().compareTo(o2.getBirth()) < 0) {
					// △리턴: a value less than 0 if this string is lexicographically less than the
					// string argument
					return -1; // 그대로 두어라.
				} // compareTo()가 0을 리턴하는 경우: the value 0 if the argument string is equal to this
					// string
				return 0;
				// return o1.getBirth().compareTo(o2.getBirth()); // 그냥 이렇게 해도 (리턴 값이 똑같기 때문에) 무방함
			}
		});
	}

	public void sortByAscWithPhoneNo() {
		Collections.sort(phoneList, new Comparator<PhoneInfo>() {

			@Override
			public int compare(PhoneInfo o1, PhoneInfo o2) {
				// 이름을 기준으로 오름차순
				// String: 앞쪽문자열.compareTo(뒷쪽문자열)
				if (o1.getPhoneNo().compareTo(o2.getPhoneNo()) > 0) {
					// △리턴: a value greater than 0 if this string is lexicographically greater than
					// the string argument.
					return 1; // 자리를 변경하라.
				} else if (o1.getPhoneNo().compareTo(o2.getPhoneNo()) < 0) {
					// △리턴: a value less than 0 if this string is lexicographically less than the
					// string argument
					return -1; // 그대로 두어라.
				} // compareTo()가 0을 리턴하는 경우: the value 0 if the argument string is equal to this
					// string
				return 0;
				// return o1.getPhoneNo().compareTo(o2.getPhoneNo()); // 그냥 이렇게 해도 (리턴 값이 똑같기 때문에) 무방함
			}
		});
	}

	// Getter & Setter =========================
	public List<PhoneInfo> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneInfo> phoneList) {
		this.phoneList = phoneList;
	}

}
