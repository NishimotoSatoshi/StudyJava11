package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * Optionalの新APIを試します。
 */
public class OptionalTest {

	@Test
	public void testOptionalIsEmpty() {
		assertTrue(Optional.empty().isEmpty());
	}
}
