package javaEssential;

import java.util.*;

public class ScannerEx2 {

	public static void main(String[] args) {
		System.out.println("�̸�, ����, ����, ü��, ���� ���θ� ��ĭ���� �и��Ͽ� �Է��ϼ���.");

		Scanner sc = new Scanner(System.in);
		String name = sc.next();// ���ڿ� ��ū �б�
		System.out.println("����� �̸��� " + name + "�Դϴ�.");

		String city = sc.next();// ���ڿ� ��ū �б�

		System.out.println("����� ��� ���ô� " + city + "�Դϴ�.");

		int age = sc.nextInt();// ���� ��ū �б�
		System.out.println("����� ���̴� " + age + "�Դϴ�.");

		double weight = sc.nextDouble();// �Ǽ� ��ū �б�
		System.out.println("����� �����Դ� " + weight + "�Դϴ�.");

		boolean single = sc.nextBoolean();// �� ��ū �б�
		System.out.println("����� ���ſ��δ� " + single + "�Դϴ�.");

		sc.close();

	}

}
