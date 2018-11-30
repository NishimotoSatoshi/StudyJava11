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
import jp.co.opst.nishimoto_satoshi.practice_java11.service.UsersService;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.UserData;
import jp.co.opst.nishimoto_satoshi.practice_java11.service.dto.UserNew;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@Api(tags = "USERS")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsresController {

	private final UsersService usersService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("全ユーザーを取得します。")
	public List<UserData> get() {
		return usersService.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("ユーザーIDに該当するユーザーを取得します。")
	public UserData get(
			@ApiParam("ユーザーID") @PathVariable("id") Integer id) {

		return usersService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("ユーザーを登録します。")
	public UserData post(UserNew user) {
		try {
			return usersService.insert(user);
		} finally {
			usersService.flush();
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("ユーザーを更新します。")
	public UserData put(UserData user) {
		try {
			return usersService.update(user);
		} finally {
			usersService.flush();
		}
	}

	@PatchMapping("{id}/{column}/{value}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "ユーザーのカラムを変更します。")
	public void patch(
			@ApiParam("ユーザーID") @PathVariable("id") Integer id,
			@ApiParam("カラム") @PathVariable("column") UserData.Column column,
			@ApiParam("値") @PathVariable("value") String value) {

		try {
			usersService.update(id, column, value);
		} finally {
			usersService.flush();
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("ユーザーを削除します。")
	public void delete(
			@ApiParam("ユーザーID") @PathVariable("id") Integer id) {

		usersService.deleteById(id);
	}
}
