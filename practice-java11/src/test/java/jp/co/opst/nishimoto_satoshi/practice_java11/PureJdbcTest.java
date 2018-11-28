package jp.co.opst.nishimoto_satoshi.practice_java11;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PureJdbcTest {

	private static final String CONNECTION_URL = "jdbc:h2:./h2/test";

	private static Connection connection;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		connection = DriverManager.getConnection(CONNECTION_URL, "sa", "");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		connection.close();
	}

	@Test
	void test() throws Exception {
		try (var statement = connection.createStatement()) {
			try (var resultSet = statement.executeQuery("SELECT * FROM ITEMS")) {
				while (resultSet.next()) {
					var id = resultSet.getInt("ID");
					var name = resultSet.getString("NAME");
					var price = resultSet.getBigDecimal("PRICE");
					log.info(String.format("[%03d] %20s : %10.2f", id, name, price));
				}
			}
		}
	}
}
