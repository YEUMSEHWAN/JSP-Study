package javaEssential;
import java.util.*;

public class WhileSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0, n = 0;//count�� �ԷµǴ� ���� ����
		double sum = 0;//sum�� ��
		
		System.out.println("������ �Է��ϰ� �������� 0�� �Է��ϼ���.");
		while((n = sc.nextInt()) != 0) { //0�� �ԷµǸ� while�� ���
			sum = sum + n;
			count++;
			
			
		}
		System.out.print("���� ������ " + count + "���̸� ");
		System.out.println("����� " + sum/count + "�Դϴ�.");
		sc.close();
		

	}

}
