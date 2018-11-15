package jp.co.opst.nishimoto_satoshi.study_java11.java10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 286: Local-Variable Type Inference.
 */
class Jep286 {

// フィールドでは使用不可。
//	var field = "foo";

	@Test
	void test() throws Exception {
		var list = List.of("foo", "bar");
		list.forEach(System.out::println);

		// 再代入も可能。ただし個人的には、ループ構文以外での再代入は、あまりやりたくない。
		list = new ArrayList<>();

		// 初期値で推論された型にキャストできない値を再代入することは不可能。
		// list = new HashMap<String, String>();

		// ジェネリクスが推論できない場合はObjectとみなされる。この場合はHashMap<Object, Object>。
		var map = new HashMap<>();
		System.out.println(map);

		// 初期値にnullを指定することはできない。
		// var value = null;

		// ループ構文での使用も可能。
		for (var item : List.of(1, 2, 3)) {
			System.out.println(item);
		}
	}
}
