package day2;

public class Ex212 {
	public static void main(String[] args) {

//		for (int i = 1; i <= 8; i++) {
//			//i++, i=i+1, i+=1 다 가능하지만 가독성을 위해서 i++을 거의 사용함
//			System.out.print(i + " ");
//		}
		for (int i = 7; i >= 1; i = i - 3) {
			// i++, i=i+1, i+=1 다 가능하지만 가독성을 위해서 i++을 거의 사용함
			System.out.print(i + " ");// 7,4,1
		}
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int c = i * j;
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}
