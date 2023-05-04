package kosa.assignment;

public class Assignment0504_1 {

	public static void main(String[] args) {
		
		int n = 5;
	
		//===============================================
		System.out.println("1-1)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%5s", i*n + (j+1));
			}
			System.out.println();
		}
		System.out.println();

		//===============================================
		System.out.println("1-2)");
		for(int i=n; i>0; i--) {
			for(int j=0; j<n; j++) {
				System.out.printf("%5s", i*(n-1) + j+1);
			}
			System.out.println();
		}
		System.out.println();
		
		//===============================================
		System.out.println("1-3)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%5s", (2*i*n) + 2*j+1);
			}
			System.out.println();
		}
		System.out.println();
		
		//===============================================
		System.out.println("1-4)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.printf("%5s", j+1);
			}
			System.out.println();
		}
		System.out.println();
		
		//===============================================
		System.out.println("1-5)");
		int m = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.printf("%5s", ++m);	// m을 안쓰고 i와 j의 관계만으로 풀 순 없을까?
			}
			System.out.println();
		}
		System.out.println();
		
		//===============================================
		System.out.println("1-6)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.printf("%5s", j+1);
			}
			System.out.println();
		}
		System.out.println();
		
		//=============================================================
		m = 0;
		System.out.println("1-7)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.printf("%5s", ++m); // m을 안쓰고 i와 j의 관계만으로 풀 순 없을까?-2
			}
			System.out.println();
		}
		System.out.println();
		
		//=============================================================
		System.out.println("1-8)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%5s", i+1+j);
			}
			System.out.println();
		}
		System.out.println();
		
		//=============================================================
		System.out.println("1-9)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j<n-i) {
					System.out.printf("%5s", i+1+j);
				} else {
					System.out.printf("%5s", i+1+j-5);	// 왜 i+1+j-4가 아닐까???
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//=============================================================
		System.out.println("1-10)");
		m = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j<n-i-1) {
					System.out.printf("%5s", " ");
				} else {
					System.out.printf("%5s", ++m); // m을 안쓰고 i와 j의 관계만으로 풀 순 없을까?-3
				}
			}
			System.out.println();
		}
		System.out.println();
	
	}

}
