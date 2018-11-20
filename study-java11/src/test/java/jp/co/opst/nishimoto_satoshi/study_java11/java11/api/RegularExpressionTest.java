package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class RegularExpressionTest {

	@Test
	public void testPatternAsMatchPredicate() {
		var filter = Pattern.compile("ab").asMatchPredicate();
		var actual = Stream.of("abc", "ab").filter(filter).toArray(String[]::new);
		assertArrayEquals(new String[] {"ab"}, actual);
	}
}
