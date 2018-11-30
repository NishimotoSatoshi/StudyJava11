package jp.co.opst.nishimoto_satoshi.practice_java11.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import jp.co.opst.nishimoto_satoshi.practice_java11.domain.ItemsRepository;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.ItemData;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.ItemNew;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.error.IdNotFound;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemsService {

	private final ItemsRepository itemsRepository;

	public void flush() {
		itemsRepository.flush();
	}

	public List<ItemData> findAll() {
		return itemsRepository.findAll()
				.stream()
				.map(ItemData::of)
				.collect(Collectors.toList());
	}

	public ItemData findById(Integer id) {
		return itemsRepository.findById(id)
				.map(ItemData::of)
				.orElseThrow(IdNotFound::new);
	}

	public ItemData insert(ItemNew item) {
		return Optional.of(item)
				.map(ItemNew::toEntity)
				.map(itemsRepository::save)
				.map(ItemData::of)
				.get();
	}

	public ItemData update(ItemData item) {
		if (!itemsRepository.existsById(item.getId())) {
			throw new IdNotFound();
		}

		return Optional.of(item)
				.map(ItemData::toEntity)
				.map(itemsRepository::save)
				.map(ItemData::of)
				.get();
	}

	public ItemData update(Integer id, ItemData.Column column, String value) {
		return itemsRepository.findById(id)
				.map(e -> column.patch(e, value))
				.map(itemsRepository::save)
				.map(ItemData::of)
				.orElseThrow(IdNotFound::new);
	}

	public void deleteById(Integer id) {
		try {
			itemsRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new IdNotFound();
		}
	}
}
