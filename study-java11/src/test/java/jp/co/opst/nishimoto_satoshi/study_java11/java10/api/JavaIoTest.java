package jp.co.opst.nishimoto_satoshi.study_java11.java10.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;

/**
 * java.ioの新APIを試します。
 */
public class JavaIoTest {

	private static final Charset MS932 = Charset.forName("MS932");
	private static final Charset UTF8 = Charset.forName("UTF-8");

	/**
	 * Reader::transferTo.
	 *
	 * <p>
	 * ReaderからWriterに値を移送するのが簡単になりました。
	 * </p>
	 *
	 * @throws Exception
	 */
	@Test
	public void testReaderTransferTo() throws Exception {
		var reader = new StringReader("foo");
		var writer = new StringWriter();

		reader.transferTo(writer);
		assertEquals("foo", writer.toString());
	}

	/**
	 * ByteArrayOutputStream::toString.
	 *
	 * <p>
	 * 引数にCharsetが指定できるようになりました。
	 * </p>
	 */
	@Test
	public void testByteArrayOutputStreamToString() {
		var out = new ByteArrayOutputStream();
		out.writeBytes("あいうえお".getBytes(MS932));

		assertEquals("あいうえお", out.toString(MS932));
		assertNotEquals("あいうえお", out.toString(UTF8));
	}

	/**
	 * PrintStream::new.
	 *
	 * <p>
	 * 引数にCharsetが指定できるようになりました。
	 * </p>
	 */
	@Test
	public void testPrintStreamNew() {
		var out = new ByteArrayOutputStream();

		try (var stream = new PrintStream(out, true, MS932)) {
			stream.print("あいうえお");
			assertFalse(stream.checkError());
		}

		assertEquals("あいうえお", out.toString(MS932));
		assertNotEquals("あいうえお", out.toString(UTF8));
	}

	/**
	 * PrintWriter::new.
	 *
	 * <p>
	 * 引数にCharsetが指定できるようになりました。
	 * </p>
	 */
	@Test
	public void testPrintWriterNew() {
		var out = new ByteArrayOutputStream();

		try (var writer = new PrintWriter(out, true, MS932)) {
			writer.print("あいうえお");
			assertFalse(writer.checkError());
		}

		assertEquals("あいうえお", out.toString(MS932));
		assertNotEquals("あいうえお", out.toString(UTF8));
	}
}
