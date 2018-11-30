package jp.co.opst.nishimoto_satoshi.practice_java11.service.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.function.BiConsumer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Users;
import lombok.Data;

@ApiModel("ユーザー情報")
@Data
public class UserData implements Serializable {

	public static enum Column {
		name(Users::setName),
		birthday((entity, value) -> entity.setBirthday(Date.valueOf(value)));

		private final BiConsumer<Users, String> patcher;

		private Column(BiConsumer<Users, String> patcher) {
			this.patcher = patcher;
		}

		public Users patch(Users entity, String value) {
			patcher.accept(entity, value);
			return entity;
		}
	}

	public static UserData of(Users entity) {
		UserData data = new UserData();
		data.id = entity.getId();
		data.name = entity.getName();
		data.birthday = entity.getBirthday();
		return data;
	}

	@NotNull
	@Min(1)
	@ApiModelProperty(value = "ユーザーID", position = 1, accessMode = AccessMode.READ_ONLY, readOnly = true)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 255)
	@ApiModelProperty(value = "ユーザー名", position = 2)
	private String name;

	@NotNull
	@ApiModelProperty(value = "誕生日", position = 3)
	private Date birthday;

	public Users toEntity() {
		Users entity = new Users();
		entity.setId(id);
		entity.setName(name);
		entity.setBirthday(birthday);
		return entity;
	}
}
