package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

@EnableRuleMigrationSupport
class JavaIoTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testPathOf() {
		var path = Path.of("src", "test", "java", "jp", "co", "opst", "nishimoto_satoshi", "study_java11", "java11", "api", "JavaIoTest.java");
		assertTrue(path.toFile().isFile());
	}

	@Test
	public void testFilesWriteStringAndReadString() throws Exception {
		var path = folder.getRoot().toPath().resolve("temp.txt");
		var text = "これはテストです。";
		var ms932 = Charset.forName("MS932");
		Files.writeString(path, text, ms932);
		assertEquals(text, Files.readString(path, ms932));
	}

	@Test
	public void testFileReaderAndFileWriterConstractor() throws Exception {
		var path = folder.getRoot().toPath().resolve("temp.txt");
		var text = "これはテストです。";
		var ms932 = Charset.forName("MS932");

		try (var out = new FileWriter(path.toString(), ms932)) {
			out.append(text);
		}

		var buffer = new StringWriter();

		try (var in = new FileReader(path.toString(), ms932)) {
			in.transferTo(buffer);
		}

		assertEquals(text, buffer.toString());
	}

	@Test
	public void testByteArrayOutputStreamWriteBytes() throws Exception {
		var expected = "あいうえお";
		var out = new ByteArrayOutputStream();
		out.writeBytes(expected.getBytes());
		assertEquals(expected, out.toString());
	}

	@Test
	public void testInputStreamReadNBytes() throws Exception {
		var expected = "あいうえお".getBytes();
		var in = new ByteArrayInputStream(expected);
		var actual = in.readNBytes(256);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testNullInputStream() throws Exception {
		try (var in = InputStream.nullInputStream()) {
			assertArrayEquals(new byte[] {}, in.readNBytes(256));
		}
	}

	@Test
	public void testNullOutputStream() throws Exception {
		try (var out = OutputStream.nullOutputStream()) {
			out.write(1);
		}
	}

	@Test
	public void testNullReader() throws Exception {
		var stream = new ByteArrayOutputStream();

		try (
			var in = Reader.nullReader();
			var out = new OutputStreamWriter(stream)
		) {
			in.transferTo(out);
		}

		assertArrayEquals(new byte[] {}, stream.toByteArray());
	}

	@Test
	public void testNullWriter() throws Exception {
		try (var out = Writer.nullWriter()) {
			out.write("foo");
		}
	}
}
