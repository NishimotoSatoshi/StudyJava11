package jp.co.opst.nishimoto_satoshi.practice_java11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.opst.nishimoto_satoshi.practice_java11.domain.ItemsRepository;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
class DatabaseTest {

	private final ItemsRepository itemsRepository;

	private final UsersRepository usersRepository;

	@BeforeEach
	public void setUp(TestInfo info) {
		info.getTestMethod()
			.map(e -> String.format("testing %s.%s...", e.getDeclaringClass().getSimpleName(), e.getName()))
			.ifPresent(log::info);
	}

	@Test
	public void testItems() throws Exception{
		itemsRepository.findAll()
			.stream()
			.map(Object::toString)
			.forEach(log::info);
	}

	@Test
	public void testUsers() throws Exception{
		usersRepository.findAll()
			.stream()
			.map(Object::toString)
			.forEach(log::info);
	}
}
