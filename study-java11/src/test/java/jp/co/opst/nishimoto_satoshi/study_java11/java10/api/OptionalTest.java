package jp.co.opst.nishimoto_satoshi.study_java11.java10.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * Optionalの新APIを試します。
 */
public class OptionalTest {

	/**
	 * Optional::orElseThrow.
	 *
	 * <p>
	 * 引数のないorElseThrowが実装されました。
	 * 実質、getと同じ振る舞いをしますが、
	 * 例外が発生する可能性が明記されたこのメソッドを使用すべきという意見があるようです。
	 * </p>
	 */
	@Test
	public void testOptionalOrElseThrow() {
		assertEquals("foo", Optional.of("foo").orElseThrow());
		assertThrows(NoSuchElementException.class, () -> Optional.empty().orElseThrow());
	}
}
