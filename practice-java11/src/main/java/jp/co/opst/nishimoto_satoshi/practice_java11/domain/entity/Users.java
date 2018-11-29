package jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@ApiModel("ユーザー台帳")
@Data
public class Users implements Serializable {

	@Id
	@Min(1)
	@ApiModelProperty(value = "ユーザーID", allowableValues = "range[1, infinity]")
	private Integer id;

	@NotNull
	@Min(1)
	@Max(256)
	@ApiModelProperty(value = "ユーザー名", allowableValues = "range[1, 256]")
	private String name;

	@NotNull
	@Min(0)
	@Max(255)
	@ApiModelProperty(value = "年齢", allowableValues = "range[0, 255]")
	private Integer age;
}
