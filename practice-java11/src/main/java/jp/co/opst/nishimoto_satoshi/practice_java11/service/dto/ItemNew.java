package jp.co.opst.nishimoto_satoshi.practice_java11.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Items;
import lombok.Data;

@ApiModel("新規商品情報")
@Data
public class ItemNew implements Serializable {

	@NotNull
	@Size(min = 1, max = 255)
	@ApiModelProperty(value = "商品名", position = 1)
	private String name;

	@NotNull
	@Min(0)
	@Max(10000000)
	@ApiModelProperty(value = "価格", position = 2)
	private BigDecimal price;

	public Items toEntity() {
		Items entity = new Items();
		entity.setName(name);
		entity.setPrice(price);
		return entity;
	}
}
