package day1;
// ++와 -- :
// Ex) int num = 5;
// num++; // num의 값이 1증가
// sysout(num); // 6
public class Ex105 {
	public static void main(String[] args) {
		byte b = 126;
		System.out.println(b); //126
		b++;  // b의 값이 1증가
		System.out.println(b); //127
		b++; // b의 값이 1증가 ?
		System.out.println(b); //-128
		// 1) byte 타입의 변수로는 절대 +128을 표현할 수 없음
		// 2) [고급] 그 값이 -128이 됨
		
	}
}
