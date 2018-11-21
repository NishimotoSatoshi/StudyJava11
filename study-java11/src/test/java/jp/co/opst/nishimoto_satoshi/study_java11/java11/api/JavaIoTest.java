package jp.co.opst.nishimoto_satoshi.study_java11.java11.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
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
}
