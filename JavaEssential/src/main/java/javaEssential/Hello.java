package javaEssential;

public class Hello {

	public static int sum(int n, int m) { // sum �̶�� �Լ� ����.

		return n + m;// void�� �ƴϹǷ� return �� �����������.

	}

	// main() �޼ҵ忡�� ����
	public static void main(String[] args) {

		int b;
		int i = 20;
		int s;
		char a;
		//�Ǵ� int sum = i + 10; 

		s = sum(i, 10); // �޼ҵ� ȣ��
		b = sum(i,30);
		a = '?';
		System.out.println(a); // ���� '?' ��� (char)����Ÿ�� �ϳ�.
		System.out.println("Hello"); // "Hello" ���ڿ� ���(String)
		System.out.println(s); // ���� s�� �� 30��� sum(i ,10)
		System.out.println(b);

	}
	
	//�ĺ��� �̸� ��Ģ.
	
	int name; // �ĺ����� ù ��° ���ڷ� ���ڴ� ��� �Ұ���.
	char student_$ID;//'_' �Ǵ� '$' ��� ����(�ٸ� Ư�����ڴ� �Ұ���), �ڹ��� �����(if) ��� �Ұ�.
	void _$func() {} // '_' �Ǵ� '$' ��� ����(�ٸ� Ư�����ڴ� �Ұ���), false ��� �Ұ�.
	class Monster3{} // ���� ��� ����, null ��� �Ұ�.
	int WhatsYourNameMyNameIsHwan; // ������ ���� ������ ����.
	int barChart; int barchart; //�ڹٴ� ��ҹ��� ����. barchart �� barChart�� �ٸ� �̸�.
	int ����;//�ѱ� ��� ����.
	
	/* �ڹ��� �⺻ Ÿ��(basic type) 8��
	 * boolean ��Ÿ�� (1��Ʈ, true or false)
	 * char ����Ÿ�� (2����Ʈ, Unicode)
	 * byte ����Ÿ�� (1����Ʈ, -128 ~ 127)
	 * short ����Ÿ�� (2����Ʈ, -32768 ~ 32767)
	 * int ����Ÿ�� (4����Ʈ, -2^31 ~ 2^31-1)
	 * long ����Ÿ�� (8����Ʈ, -2^63 ~ 2^63-1)
	 * float �Ǽ�Ÿ�� (4����Ʈ)
	 * double �Ǽ�Ÿ�� (8����Ʈ)
	 */
	
	//***�����ڵ� : �����ڵ�� �������� ��� ���ڸ� ǥ���ϱ� ����, ���ڴ� 2����Ʈ�� ��� ǥ�� �ڵ� ü��� �����ڵ� ��ȸ�� �����Ѵ�.
	//			 �����ڵ忡�� ISO10640 ��������, �������ڵ�, ���� ���� �����ͺ��̽�, ���ڸ� ó���ϱ� ���� �˰��� ���� ���ԵǾ� �ִ�.
	
	
	//-----------------------------------------------------------
	// ���ڿ�
	String toolName = "JDK";
	
	

}
