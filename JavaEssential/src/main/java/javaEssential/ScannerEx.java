package javaEssential;
import java.util.*;
public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("이름을 입력 후 enter를 눌러주세요.");
		String name = sc.next();//문자열 토큰으로 읽기		
		System.out.println("나이를 입력 후 enter를 눌러주세요.");
		int age = sc.nextInt();
		
		
		System.out.println("태어난 년도를 작성해 주세요");
		int year = sc.nextInt();
		System.out.println("태어난 달을 작성해 주세요");
		int month = sc.nextInt();
		System.out.println("태어난 날을 작성해 주세요");
		int day = sc.nextInt();
		System.out.println("당신은 솔로입니까 커플입니까? 솔로 : 0, 커플 : 1 ");
		int single = sc.nextInt();
		if(single == 1) {
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("생년월일 : " + year + "년 " + month + "월 " + day + "일");
			System.out.println("당신은 커플이군요!");
		}
		else if(single == 0){
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("생년월일 : " + year + "년 " + month + "월 " + day + "일");
			System.out.println("저런..솔로시구나...미안...");
		}
		else {
			System.out.println("0 또는 1만 입력하라고 했잖아..ㅡㅡ");
			System.out.println("처음부터 다시 입력해 주시기 바랍니다.");
		}
		
		
	}

}
