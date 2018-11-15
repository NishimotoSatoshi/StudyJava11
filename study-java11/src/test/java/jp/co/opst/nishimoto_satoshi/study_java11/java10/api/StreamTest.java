package jp.co.opst.nishimoto_satoshi.study_java11.java10.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * Stream APIの新APIを試します。
 */
public class StreamTest {

	/**
	 * Collectors::toUnmodifiableList.
	 *
	 * <p>
	 * Streamから不変リストを簡単に作成できるようになりました。
	 * </p>
	 */
	@Test
	public void testCollectorstoUnmodifiableList() {
		var list = Stream.of("foo", "bar").collect(Collectors.toUnmodifiableList());

		assertEquals(List.of("foo", "bar"), list);
		assertThrows(UnsupportedOperationException.class, () -> list.add("baz"));
	}

	/**
	 * Collectors::toUnmodifiableSet.
	 *
	 * <p>
	 * Streamから不変セットを簡単に作成できるようになりました。
	 * </p>
	 */
	@Test
	public void testCollectorstoUnmodifiableSet() {
		var set = Stream.of("foo", "bar").collect(Collectors.toUnmodifiableSet());

		assertEquals(Set.of("foo", "bar"), set);
		assertThrows(UnsupportedOperationException.class, () -> set.add("baz"));
	}

	/**
	 * Collectors::toUnmodifiableMap.
	 *
	 * <p>
	 * Streamから不変マップを簡単に作成できるようになりました。
	 * </p>
	 */
	@Test
	public void testCollectorstoUnmodifiableMap() {
		var map = Stream.of(Integer.class, String.class)
				.collect(Collectors.toUnmodifiableMap(Class::getSimpleName, Function.identity()));

		assertEquals(Map.of("Integer", Integer.class, "String", String.class), map);
		assertThrows(UnsupportedOperationException.class, () -> map.put("Boolean", Boolean.class));
	}
}
