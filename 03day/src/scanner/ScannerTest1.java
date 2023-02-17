package scanner;
import java.util.*;
public class ScannerTest1 {

	public static void main(String[] args) {
		
//		키보드를 통해서 데이터를 입력받는 스캐너
		Scanner sc = new Scanner(System.in);
		
		String addr = ""; //문자열
		System.out.print("주소를 입력하세요.");
		addr = sc.nextLine();
		
		
		sc.close();
	}

}
