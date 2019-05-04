package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 */
public class VarDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//在lambda中表达式可以访问list，但是list实际上编译器会帮我们加上final
		//list = new ArrayList<>(); //这样就会编译错误，因为是final的不能修改
		Consumer<String> consumer = s -> System.out.println(s + list);
		consumer.accept("1211");
	}

}
