package kosa.assignment;

public class Assignment0504_2 {

	public static void main(String[] args) {
		
		int n = 5;
		
		//====================================
		System.out.println("2-1)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		//====================================
		System.out.println("2-2)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		//====================================
		System.out.println("2-3)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j<n-1-i) {
					System.out.print("-");	
				} else {
					System.out.print("*");					
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//====================================
		System.out.println("2-4)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n-1; j++) {
				// j가 0~8까지면 9번 돈다는 건데 왜 j가 0~10까지가 되어도 되는지 모르겠다...
				// =>그렇게 풀면 틀림! 어딘가에 공백이 하나 더 껴있다는 거임.
				// j가 0~8까지 9번 돌게끔 하는게 맞는 것 같다...
				if((j<n-1-i) || (j>n-1+i)) {
					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//==========================================================
		System.out.println("2-5)");
		for(int i=0; i<2*n-1; i++) {
			for(int j=0; j<2*n-1; j++) {
				if((i<(2*n-1)/2) && (j<(2*n-1)/2-i || j>(2*n-1)/2+i)) {
					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
				} else if((i>(2*n-1)/2) && (j<i-(2*n-1)/2 || j>i+(2*n-1)/2)) {
					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();

		//★인덱스 이해 잘 안됨============================================
		// 마름모는.... for를 다시 짜서 한 번 더 돌리면 되는 거였다... 
		// 그렇게 한다고 해서 실행시간이 더 늘어나지도 않는다.... 
		// 왜냐면 애초에 루프가 2n*2n번 도나 2n*(n+n)번 도나 똑같잖아...
		// 괜히 고집해서 코딩 시간도 훨씬 늘었잖아... 그래서 머리가 나쁘면 머리가 더 고생해.......
		System.out.println("2-5) for문을 약 2n*(n+n)번 돌려서 해결");
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n-1; j++) {
				if((j<n-1-i) || (j>n-1+i)) {
					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<2*n-1; j++) {
				if(j<=n-1-i || j>=n-1+i) { // ★이건 왜 범위에 =이 포함될까?
					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		//====================================
		System.out.println("2-6)");
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*(2*n-1); j++) {
				//TODO: 여기서부터 다시~~~
//				if() {
//					System.out.print("-");	// 나중에 공백문자로 바꿔주면 됨.
//				} else {
//					System.out.print("*");
//				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		
	}
}
