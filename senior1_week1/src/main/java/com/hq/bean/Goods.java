package com.hq.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Goods {
    private Integer id;
    @NotEmpty(message="商品名称不能为空")
    private String goodsName;
    private String englishName;
    private Integer goodsSize;
    private String goodsMoney;
    @NotNull(message="商品数量必填")
    private Integer goodsNumber;
    private String goodsTaglib;
    private String goodsPic;
    private Integer display;
    @Valid
    private GoodsBrand goodsBrand;
    @Valid
    private GoodsType goodsType;


    public Goods() {
        super();
        // TODO Auto-generated constructor stub
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}


	public Integer getGoodsSize() {
		return goodsSize;
	}


	public void setGoodsSize(Integer goodsSize) {
		this.goodsSize = goodsSize;
	}


	public String getGoodsMoney() {
		return goodsMoney;
	}


	public void setGoodsMoney(String goodsMoney) {
		this.goodsMoney = goodsMoney;
	}


	public Integer getGoodsNumber() {
		return goodsNumber;
	}


	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}


	public String getGoodsTaglib() {
		return goodsTaglib;
	}


	public void setGoodsTaglib(String goodsTaglib) {
		this.goodsTaglib = goodsTaglib;
	}


	public String getGoodsPic() {
		return goodsPic;
	}


	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}


	public Integer getDisplay() {
		return display;
	}


	public void setDisplay(Integer display) {
		this.display = display;
	}


	public GoodsBrand getGoodsBrand() {
		return goodsBrand;
	}


	public void setGoodsBrand(GoodsBrand goodsBrand) {
		this.goodsBrand = goodsBrand;
	}


	public GoodsType getGoodsType() {
		return goodsType;
	}


	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}


	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", englishName=" + englishName + ", goodsSize="
				+ goodsSize + ", goodsMoney=" + goodsMoney + ", goodsNumber=" + goodsNumber + ", goodsTaglib="
				+ goodsTaglib + ", goodsPic=" + goodsPic + ", display=" + display + ", goodsBrand=" + goodsBrand
				+ ", goodsType=" + goodsType + "]";
	}


	public Goods(Integer id, String goodsName, String englishName, Integer goodsSize, String goodsMoney,
			Integer goodsNumber, String goodsTaglib, String goodsPic, Integer display, GoodsBrand goodsBrand,
			GoodsType goodsType) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.englishName = englishName;
		this.goodsSize = goodsSize;
		this.goodsMoney = goodsMoney;
		this.goodsNumber = goodsNumber;
		this.goodsTaglib = goodsTaglib;
		this.goodsPic = goodsPic;
		this.display = display;
		this.goodsBrand = goodsBrand;
		this.goodsType = goodsType;
	}

    


}
