//package kosa.codingTest;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution {
//	/*
//	 * 이동포X 불이동포Y 일반알H 빈칸L X는 Y 못넘음 X는 한알 넘어야 다른 알 먹음 빈칸은 넘어간다? 테스트케이스 10개 모두 통과
//	 */
//
//	static int AnswerN; // 포가 먹을 수 있는 알의 수
//	static int N; // TODO: 판의 너비 N*N...
//
//	public static void main(String args[]) throws Exception {
//
//		// TODO: 파일 경로 고치기
//		System.setIn(new FileInputStream("C:\\Users\\KOSA\\Desktop\\sample_input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스의 수
////		int T = sc.nextInt();
////		System.out.println("T: " + T);
////		char x, y, h, l;
//		String line = "";
//		String[][] character;
//		boolean flag = true;
//	
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//			N = Integer.parseInt(br.readLine().trim());
////			System.out.println("N: " + N);
//
//			char[][] b = new char[N][N]; // TODO: board , row, column 으로 고치기.
//			character = new String[N][N];
//						
//			X x = new X();
//			List<Y> yList = new ArrayList<Y>();
//			List<H> hList = new ArrayList<H>();
//			List<L> lList = new ArrayList<L>();
//
//			for (int r = 0; r<N; r++) { // 한줄씩
//				if( (line = br.readLine()) !=null ) {
//					character[r] = line.split(" ");
////					System.out.print("공백제거:");
//					for (int c = 0; c < N; c++) {
////						System.out.print(character[r][c].toString()); // 문자열 저장
//						// 문자 하나씩 저장하면서, X,Y,H위치 저장.(L은 굳이..?)
//						b[r][c] = character[r][c].charAt(0);
////						System.out.print(b[r][c]);
//						switch (b[r][c]) { // TODO : b[r][c] = character[r][c].charAt(0)
//						case 'X':
//							x.setRow(r);
//							x.setCol(c);
////							System.out.print("x:["+r+"]["+c+"], ");
//							break;
//						case 'Y':
//							yList.add(new Y(r, c));
////							System.out.print("y:["+r+"]["+c+"], ");
//							break;
//						case 'H':
//							hList.add(new H(r, c));
////							System.out.print("h:["+r+"]["+c+"], ");
//							break;
//						default:
//							//L 정보는 저장 안함.
//							lList.add(new L(r, c));
////							System.out.print("l:["+r+"]["+c+"], ");
//							break;
//						}
//					}			
//				}
////				System.out.println(" --- for depth 3 end");
////				System.out.println();
////				System.out.println(line);
//			}
////			System.out.println(" --- for depth 2 end");
////			System.out.println();
//
//			int hNum = 0;
//			
//			// 상으로 이동
//			X initialX = x;
//			boolean isY = false;
//			boolean isNearbyH = false;
//			for (int r=x.row; r>=0 && !isY; r--) {
//				x.row--;
//				for(int c=0; c<N && !isNearbyH && !isY; c++) {
//					for(int i=0; i<yList.size()) {
//						
//					}
//					if(hList.get(r).col==x.col) {
//						if(c == 0) {
//							isNearbyH = true;
//							break;
//						} else {
//							hNum++;
//						}
//					} else if (yList.get(r).col==x.col) {
//						isY = true;
//						break;
//					}
//				}
//			}
//			// 하로 이동
//			x = initialX;
//			isY = false;
//			
//			for (int r=x.row; r<N && !isY; r++) {
//				x.row++;
//				if(yList.contains(new Y(x.row, x.col))) {
//					isY = true;
//					break;
//				} else if(hList.contains(new H(x.row, x.col))) {
////					if() {
//						hNum++;
////					}
//				}
//			}
//			// 좌로 이동
//			x = initialX;
//			isY = false;
//			for (int c=x.col; c>=0 && !isY; c--) {
//				x.col--;
//				if(yList.contains(new Y(x.row, x.col))) {
//					isY = true;
//					break;
//				} else if(hList.contains(new H(x.row, x.col))) {
//					hNum++;
//				}
//			}	
//			// 우로 이동
//			x = initialX;
//			isY = false;
//			for (int c=x.col; c < N && !isY; c++) {
//				x.col++;
//				if(yList.contains(new Y(x.row, x.col))) {
//					isY = true;
//					break;
//				} else if(hList.contains(new H(x.row, x.col))) {
//					hNum++;
//				}
//			}
//			
//			AnswerN = hNum;
//			System.out.println("#"+test_case+" "+AnswerN);
//		}
////		System.out.println(" --- for depth 1 end");
//
//	}
//	
//	
//
//}
//
//
//class X{
//	int row, col;
//	
//	public X() {}
//	public X(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public void setRow(int row) {
//		this.row = row;
//	}
//	public int getCol() {
//		return col;
//	}
//	public void setCol(int col) {
//		this.col = col;
//	}
//}
//class Y{
//	int row, col;	
//
//	public Y() {}
//	public Y(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public void setRow(int row) {
//		this.row = row;
//	}
//	public int getCol() {
//		return col;
//	}
//	public void setCol(int col) {
//		this.col = col;
//	}
//	
//}
//class H{
//	int row, col;
//	public H() {}
//	public H(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public void setRow(int row) {
//		this.row = row;
//	}
//	public int getCol() {
//		return col;
//	}
//	public void setCol(int col) {
//		this.col = col;
//	}
//	
//}
//class L{
//	int row, col;
//	public L() {}
//	public L(int row, int col) {
//		super();
//		this.row = row;
//		this.col = col;
//	}
//	public int getRow() {
//		return row;
//	}
//	public void setRow(int row) {
//		this.row = row;
//	}
//	public int getCol() {
//		return col;
//	}
//	public void setCol(int col) {
//		this.col = col;
//	}
//	
//}
//
