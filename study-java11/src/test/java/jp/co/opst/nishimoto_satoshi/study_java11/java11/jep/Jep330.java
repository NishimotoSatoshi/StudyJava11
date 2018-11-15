package jp.co.opst.nishimoto_satoshi.study_java11.java11.jep;

import java.util.List;

/**
 * 330: Launch Single-File Source-Code Programs.
 */
public class Jep330 {

	public static void main(String[] args) {
		List.of("foo", "bar", "baz").forEach(System.out::println);
	}
}
