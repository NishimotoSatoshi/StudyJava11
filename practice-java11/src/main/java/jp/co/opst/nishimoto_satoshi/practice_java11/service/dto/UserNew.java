package jp.co.opst.nishimoto_satoshi.practice_java11.service.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Users;
import lombok.Data;

@ApiModel("新規ユーザー情報")
@Data
public class UserNew implements Serializable {

	@NotNull
	@Size(min = 1, max = 255)
	@ApiModelProperty(value = "ユーザー名", position = 1)
	private String name;

	@NotNull
	@ApiModelProperty(value = "誕生日", position = 2)
	private Date birthday;

	public Users toEntity() {
		Users entity = new Users();
		entity.setName(name);
		entity.setBirthday(birthday);
		return entity;
	}
}
