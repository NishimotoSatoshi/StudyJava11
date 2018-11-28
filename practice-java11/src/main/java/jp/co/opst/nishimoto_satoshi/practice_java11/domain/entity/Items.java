package jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@ApiModel("商品台帳")
@Data
public class Items implements Serializable {

	@Id
	@Min(1)
	@ApiModelProperty(value = "商品ID", allowableValues = "range[1, infinity]")
	private Integer id;

	@NotNull
	@Min(1)
	@Max(256)
	@ApiModelProperty(value = "商品名", allowableValues = "range[1, 256]")
	private String name;

	@NotNull
	@Min(0)
	@Max(10000000)
	@ApiModelProperty(value = "価格", allowableValues = "range[0, 10000000)")
	private BigDecimal price;
}
