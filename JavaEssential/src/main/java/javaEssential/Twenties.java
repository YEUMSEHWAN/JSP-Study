package javaEssential;

import java.util.Scanner;

public class Twenties {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("���̸� �Է��Ͻÿ� : ");
		int age = sc.nextInt();// ���� �Է� �ޱ�
		if ((age >= 20) && (age < 30)) {
			System.out.println("���ʪ���20�۪Ǫ���");
			System.out.println("20��� �ູ�մϴ�~");
		} else {
			System.out.println("20�밡 �ƴմϴ�.");
		}
		sc.close();
	}

}
