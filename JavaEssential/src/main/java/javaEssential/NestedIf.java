package javaEssential;

import java.util.*;

public class NestedIf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �Է��ϼ���(0 ~ 100) : ");
		int score = sc.nextInt();// ���� �б�
		System.out.println("�г��� �Է��ϼ���(1~4) : ");
		int year = sc.nextInt();

		if (score >= 60) {
			if (year != 4)
				System.out.println("�հ�!"); // 4�г��� �ƴϸ� �հ�
			else if (score >= 70)
				System.out.println("�հ�!");// 4�г��� 70�� �̻��̸� �հ�
			else
				System.out.println("���հ�!");// 4�г��� 70�� �̸��̸� ���հ�
		} else // 60�� �̸��̸�
			System.out.println("���հ�!");

		sc.close();
	}

}
