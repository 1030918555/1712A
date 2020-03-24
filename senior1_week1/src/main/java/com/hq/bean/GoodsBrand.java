package com.hq.bean;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class GoodsBrand {
	@NotNull(message="必选")
    private Integer id;
    private String brandName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "GoodsBrand [id=" + id + ", brandName=" + brandName + "]";
	}
	public GoodsBrand(Integer id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}
	public GoodsBrand() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
