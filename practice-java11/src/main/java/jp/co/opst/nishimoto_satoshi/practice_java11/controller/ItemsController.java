package jp.co.opst.nishimoto_satoshi.practice_java11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.ItemsService;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.ItemData;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.ItemNew;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/items")
@Api(tags = "ITEMS")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemsController {

	private final ItemsService itemsService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("全商品を取得します。")
	public List<ItemData> get() {
		return itemsService.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("商品IDに該当する商品を取得します。")
	public ItemData get(
			@ApiParam("商品ID") @PathVariable("id") Integer id) {

		return itemsService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("商品を登録します。")
	public ItemData post(ItemNew item) {
		try {
			return itemsService.insert(item);
		} finally {
			itemsService.flush();
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("商品を更新します。")
	public ItemData put(ItemData item) {
		try {
			return itemsService.update(item);
		} finally {
			itemsService.flush();
		}
	}

	@PatchMapping("{id}/{column}/{value}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "商品のカラムを変更します。")
	public void patch(
			@ApiParam("商品ID") @PathVariable("id") Integer id,
			@ApiParam("カラム") @PathVariable("column") ItemData.Column column,
			@ApiParam("値") @PathVariable("value") String value) {

		try {
			itemsService.update(id, column, value);
		} finally {
			itemsService.flush();
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("商品を削除します。")
	public void delete(
			@ApiParam("商品ID") @PathVariable("id") Integer id) {

		itemsService.deleteById(id);
	}
}
