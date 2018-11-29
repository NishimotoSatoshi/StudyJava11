package jp.co.opst.nishimoto_satoshi.practice_java11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.co.opst.nishimoto_satoshi.practice_java11.controller.error.IdNotFound;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Items;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/items")
@Api(tags = "ITEMS")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemsController {

	private final ItemsRepository itemsRepository;

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("商品IDに該当する商品を取得します。")
	public Items get(
			@PathVariable("id") @ApiParam("商品ID") Integer id) {

		return itemsRepository.findById(id).orElseThrow(IdNotFound::new);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("全商品を取得します。")
	public List<Items> get() {
		return itemsRepository.findAll();
	}
}
