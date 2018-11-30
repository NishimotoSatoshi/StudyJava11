package jp.co.opst.nishimoto_satoshi.practice_java11.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import jp.co.opst.nishimoto_satoshi.practice_java11.domain.UsersRepository;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.UserData;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.UserNew;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.error.IdNotFound;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsersService {

	private final UsersRepository usersRepository;

	public void flush() {
		usersRepository.flush();
	}

	public List<UserData> findAll() {
		return usersRepository.findAll()
				.stream()
				.map(UserData::of)
				.collect(Collectors.toList());
	}

	public UserData findById(Integer id) {
		return usersRepository.findById(id)
				.map(UserData::of)
				.orElseThrow(IdNotFound::new);
	}

	public UserData insert(UserNew item) {
		return Optional.of(item)
				.map(UserNew::toEntity)
				.map(usersRepository::save)
				.map(UserData::of)
				.get();
	}

	public UserData update(UserData item) {
		if (!usersRepository.existsById(item.getId())) {
			throw new IdNotFound();
		}

		return Optional.of(item)
				.map(UserData::toEntity)
				.map(usersRepository::save)
				.map(UserData::of)
				.get();
	}

	public UserData update(Integer id, UserData.Column column, String value) {
		return usersRepository.findById(id)
				.map(e -> column.patch(e, value))
				.map(usersRepository::save)
				.map(UserData::of)
				.orElseThrow(IdNotFound::new);
	}

	public void deleteById(Integer id) {
		try {
			usersRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new IdNotFound();
		}
	}
}
