package javaEssential;
import java.util.*;
public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("�̸��� �Է� �� enter�� �����ּ���.");
		String name = sc.next();//���ڿ� ��ū���� �б�		
		System.out.println("���̸� �Է� �� enter�� �����ּ���.");
		int age = sc.nextInt();
		
		
		System.out.println("�¾ �⵵�� �ۼ��� �ּ���");
		int year = sc.nextInt();
		System.out.println("�¾ ���� �ۼ��� �ּ���");
		int month = sc.nextInt();
		System.out.println("�¾ ���� �ۼ��� �ּ���");
		int day = sc.nextInt();
		System.out.println("����� �ַ��Դϱ� Ŀ���Դϱ�? �ַ� : 0, Ŀ�� : 1 ");
		int single = sc.nextInt();
		if(single == 1) {
			System.out.println("�̸� : " + name);
			System.out.println("���� : " + age);
			System.out.println("������� : " + year + "�� " + month + "�� " + day + "��");
			System.out.println("����� Ŀ���̱���!");
		}
		else if(single == 0){
			System.out.println("�̸� : " + name);
			System.out.println("���� : " + age);
			System.out.println("������� : " + year + "�� " + month + "�� " + day + "��");
			System.out.println("����..�ַνñ���...�̾�...");
		}
		else {
			System.out.println("0 �Ǵ� 1�� �Է��϶�� ���ݾ�..�Ѥ�");
			System.out.println("ó������ �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
		}
		
		
	}

}
