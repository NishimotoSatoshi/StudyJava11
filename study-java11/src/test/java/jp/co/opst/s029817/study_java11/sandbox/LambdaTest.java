package jp.co.opst.s029817.study_java11.sandbox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.ToIntFunction;

import org.junit.jupiter.api.Test;

/**
 * ラムダ式に関するテストです。
 */
class LambdaTest {

	/**
	 * ラムダ式内で var が使用できるようになりました。
	 */
	@Test
	void test_var_in_lambda() {
		ToIntFunction<String> tested = e -> {
			var list = List.of("foo",  "bar", "baz");
			return list.indexOf(e);
		};

		assertEquals(0, tested.applyAsInt("foo"));
		assertEquals(1, tested.applyAsInt("bar"));
		assertEquals(2, tested.applyAsInt("baz"));
		assertEquals(-1, tested.applyAsInt("hoge"));
	}
}
