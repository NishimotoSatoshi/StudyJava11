package jp.co.opst.nishimoto_satoshi.practice_java11.controller;

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
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Users;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@Api(tags = "USERS")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsresController {

	private final UsersRepository usersRepository;

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("ユーザーIDに該当するユーザーを取得します。")
	public Users get(
			@PathVariable("id") @ApiParam("ユーザーID") Integer id) {

		return usersRepository.findById(id).orElseThrow(IdNotFound::new);
	}
}
