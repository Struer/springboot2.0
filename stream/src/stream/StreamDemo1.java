package stream;

import java.util.stream.IntStream;

public class StreamDemo1 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		// ʹ��stream���ڲ�����
		// map�����м����������stream�Ĳ�����,���������ͣ����������stream�����м���������������ֹ����
		// sum������ֹ����
		//int sum3 = IntStream.of(nums).map(i->i*2).sum();
		int sum3 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
		System.out.println("���Ϊ��" + sum3);
		//������ֵ
		System.out.println("������ֵ������ֹû�е��õ�����£��м��������ִ��");
		IntStream.of(nums).map(StreamDemo1::doubleNum);//�����Ͳ������map(StreamDemo1::doubleNum)
	}
	public static int doubleNum(int i) {
		System.out.println(i + "ִ���˳���2");
		return i * 2;
	}
}
