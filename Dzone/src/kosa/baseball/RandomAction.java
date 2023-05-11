// =============== GameMain에서 람다식으로 변경하여 전부 주석처리 함 =================
//package kosa.baseball;
//
//public class RandomAction implements Action {
//	
//	private String[] random;
//	
//	public RandomAction() {
//		super();
//		this.random = new String[LENGTH];
//	}
//	
//	@Override
//	public void act() {
//		System.out.print("난수: ");
//		for(int i=0; i<random.length; i++) {
//			random[i] = String.valueOf((int)(Math.random()*9)+1);
//			// ▽ 중복 되거나 0이면 다시 난수 생성
//			for (int j=0; j<i; j++) {
////				while(random[i].equals(random[j]) || random[i].equals("0")) { 
//				// △ 이렇게 하면 왜 0이 나올까? => 알고보니 첫번째 칸에 0이 나온 거였음. 
//				// 첫번째에 0이 나오면 아예 해당 for루프에 들어가지도 않으니까...!
//				while(random[i].equals(random[j])) {
//					random[i] = String.valueOf((int)(Math.random()*9)+1);
//				}
//			}
//			System.out.print(random[i]);
//		}
//		System.out.println();
//	}
//
//	// Getter & Setter ===========================
//	public String[] getRandom() {
//		return random;
//	}
////
////	public void setRandom(String[] random) {
////		this.random = random;
////	}
//
//}
