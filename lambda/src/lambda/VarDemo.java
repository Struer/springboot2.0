package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * ��������
 */
public class VarDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//��lambda�б��ʽ���Է���list������listʵ���ϱ�����������Ǽ���final
		//list = new ArrayList<>(); //�����ͻ���������Ϊ��final�Ĳ����޸�
		Consumer<String> consumer = s -> System.out.println(s + list);
		consumer.accept("1211");
	}

}
