package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * コレクション・フレームワークの新APIを試します。
 */
public class CollectionTest {

	@Test
	public void testCollectionToArray() {
		var actual = List.of("foo", "bar", "bax").toArray(String[]::new);
		assertArrayEquals(new String[] {"foo", "bar", "bax"}, actual);
	}
}
