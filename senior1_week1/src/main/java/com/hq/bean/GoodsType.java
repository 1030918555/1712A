package com.hq.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class GoodsType{
	@NotNull(message="必选")
    private Integer id;
    private String typeName;

    public GoodsType() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", typeName=" + typeName + "]";
	}

   

}
