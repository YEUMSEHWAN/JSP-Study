package javaEssential;

import java.util.*;

public class ArithemticOperatior {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է��� �ּ��� : ");

		int time = sc.nextInt(); // ���� �Է�
		int second = time % 60; // 60 ���� ���� �������� ��
		int minute = (time / 60) % 60; // 60���� ���� ���� �ٽ� 60���� ���� �������� ��
		int hour = (time / 60) / 60; // 60���� ���� ���� �ٽ� 60���� ���� ���� �ð�

		System.out.println(time + "�ʴ� ");
		System.out.println(hour + "�ð�, ");
		System.out.println(minute + "��, ");
		System.out.println(second + "�� �Դϴ�. ");

		sc.close();// Scanner �� ��� ����..//�������α׷����� Scanner�� �ݴ� �ڵ尡 ������ ������ �ÿ� ���(Warning)�� �߻�..
	}

}
