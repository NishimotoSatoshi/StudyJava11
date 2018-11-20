package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LangTest {

	@Test
	public void testStringRepeat() {
		assertEquals("abcabcabc", "abc".repeat(3));
	}

	@Test
	public void testBlank() {
		assertTrue("".isBlank());
		assertTrue(" ".isBlank());
		assertTrue("　 ".isBlank());
		assertTrue("\t".isBlank());
		assertTrue("\r".isBlank());
		assertTrue("\n".isBlank());
	}

	@Test
	public void testStringStrip() {
		assertEquals("ABC", " 　\t\r\nABC\n\r\t　 ".strip());
	}

	@Test
	public void testStringStripLeading() {
		assertEquals("ABC\n\r\t　 ", " 　\t\r\nABC\n\r\t　 ".stripLeading());
	}

	@Test
	public void testStringStripTrailing() {
		assertEquals(" 　\t\r\nABC", " 　\t\r\nABC\n\r\t　 ".stripTrailing());
	}

	@Test
	public void testStringLines() {
		var actual = "foo\r\nbar\r\nbaz\r\n".lines().anyMatch("bar"::equals);
		assertTrue(actual);
	}

	@Test
	public void testCharacterToString() {
		assertEquals("A", Character.toString(65));
	}
}
