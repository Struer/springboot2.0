package stream;

import java.util.stream.IntStream;

public class StreamDemo1 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		// 使用stream的内部迭代
		// map就是中间操作（返回stream的操作）,看返回类型，如果返回是stream就是中间操作，否则就是终止操作
		// sum就是终止操作
		//int sum3 = IntStream.of(nums).map(i->i*2).sum();
		int sum3 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
		System.out.println("结果为：" + sum3);
		//惰性求值
		System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
		IntStream.of(nums).map(StreamDemo1::doubleNum);//这样就不会调用map(StreamDemo1::doubleNum)
	}
	public static int doubleNum(int i) {
		System.out.println(i + "执行了乘以2");
		return i * 2;
	}
}
