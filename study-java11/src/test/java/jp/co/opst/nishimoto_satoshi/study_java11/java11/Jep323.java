package jp.co.opst.nishimoto_satoshi.study_java11.java11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.ToIntBiFunction;

import org.junit.jupiter.api.Test;

/**
 * 323: Local-Variable Syntax for Lambda Parameters.
 */
class Jep323 {

	@Test
	void test() {
		ToIntBiFunction<List<String>, String> tested = (var l, var e) -> l.indexOf(e);
		assertEquals(1, tested.applyAsInt(List.of("foo",  "bar", "baz"), "bar"));
	}
}
