package jp.co.opst.nishimoto_satoshi.study_java11.java10.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * コレクション・フレームワークの新APIを試します。
 */
public class CollectionTest {

	/**
	 * List::copyOf.
	 *
	 * <p>
	 * リストを不変リストとしてコピーできるようになりました。
	 * リストのスナップショットを作成するのに利用できそうです。
	 * </p>
	 */
	@Test
	public void testListCopyOf() {
		var original = new ArrayList<String>();
		original.add("foo");
		original.add("bar");

		// オリジナルからコピーを作成します。
		var copied = List.copyOf(original);
		assertEquals(original, copied);

		// 作成したコピーは不変なので変更ができません。
		assertThrows(UnsupportedOperationException.class, () -> copied.add("baz"));

		// オリジナルに要素を追加しても、コピーには反映されません。
		original.add("baz");
		assertNotEquals(original, copied);
	}

	/**
	 * Set::copyOf.
	 *
	 * <p>
	 * セットを不変セットとしてコピーできるようになりました。
	 * セットのスナップショットを作成するのに利用できそうです。
	 * </p>
	 */
	@Test
	public void testSetCopyOf() {
		var original = new HashSet<String>();
		original.add("foo");
		original.add("bar");

		// オリジナルからコピーを作成します。
		var copied = Set.copyOf(original);
		assertEquals(original, copied);

		// 作成したコピーは不変なので変更ができません。
		assertThrows(UnsupportedOperationException.class, () -> copied.add("baz"));

		// オリジナルに要素を追加しても、コピーには反映されません。
		original.add("baz");
		assertNotEquals(original, copied);
	}

	/**
	 * Map::copyOf.
	 *
	 * <p>
	 * マップを不変マップとしてコピーできるようになりました。
	 * マップのスナップショットを作成するのに利用できそうです。
	 * </p>
	 */
	@Test
	public void testMapCopyOf() {
		var original = new HashMap<String, Integer>();
		original.put("foo", 1);
		original.put("bar", 2);

		// オリジナルからコピーを作成します。
		var copied = Map.copyOf(original);
		assertEquals(original, copied);

		// 作成したコピーは不変なので変更ができません。
		assertThrows(UnsupportedOperationException.class, () -> copied.put("bar", 3));

		// オリジナルに要素を追加しても、コピーには反映されません。
		original.put("baz", 3);
		assertNotEquals(original, copied);
	}
}
