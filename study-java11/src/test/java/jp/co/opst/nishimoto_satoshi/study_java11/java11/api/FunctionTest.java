package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class FunctionTest {

	@Test
	public void testPredicateNot() {
		var actual = Stream.of("foo", "", "bar", "", "baz")
				.filter(Predicate.not(String::isEmpty))
				.count();

		assertEquals(3, actual);
	}
}
