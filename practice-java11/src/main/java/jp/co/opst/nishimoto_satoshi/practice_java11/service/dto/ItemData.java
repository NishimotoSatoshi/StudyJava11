package jp.co.opst.nishimoto_satoshi.practice_java11.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.BiConsumer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import jp.co.opst.nishimoto_satoshi.practice_java11.domain.entity.Items;
import lombok.Data;

@ApiModel("商品情報")
@Data
public class ItemData implements Serializable {

	public static enum Column {
		name(Items::setName),
		price((entity, value) -> entity.setPrice(new BigDecimal(value)));

		private final BiConsumer<Items, String> patcher;

		private Column(BiConsumer<Items, String> patcher) {
			this.patcher = patcher;
		}

		public Items patch(Items entity, String value) {
			patcher.accept(entity, value);
			return entity;
		}
	}

	public static ItemData of(Items entity) {
		ItemData data = new ItemData();
		data.id = entity.getId();
		data.name = entity.getName();
		data.price = entity.getPrice();
		return data;
	}

	@NotNull
	@Min(1)
	@ApiModelProperty(value = "商品ID", position = 1, accessMode = AccessMode.READ_ONLY, readOnly = true)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 255)
	@ApiModelProperty(value = "商品名", position = 2)
	private String name;

	@NotNull
	@Min(0)
	@Max(10000000)
	@ApiModelProperty(value = "価格", position = 3)
	private BigDecimal price;

	public Items toEntity() {
		Items entity = new Items();
		entity.setId(id);
		entity.setName(name);
		entity.setPrice(price);
		return entity;
	}
}
