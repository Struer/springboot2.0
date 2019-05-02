package lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

class MoneyDemo {
	private final int money;

	public MoneyDemo(int money) {
		this.money = money;
	}

	public void printMoney(Function<Integer, String> moneyFormat) {
		System.out.println("我的存款：" + moneyFormat.apply(this.money));
	}
}

public class MoneyDemo {

	public static void main(String[] args) {
		MoneyDemo me = new MoneyDemo(99999999);

		Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###")
				.format(i);
		
		// 函数接口链式操作
		me.printMoney(moneyFormat.andThen(s -> "人民币 " + s));
	}

}
