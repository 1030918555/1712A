package com.hq.dao;

import java.util.List;
import java.util.Map;

import com.hq.bean.Goods;

public interface GoodsDAO {

	List list(Map map);

	List brandList();

	List typeList();

	int add(Goods goods);

	Goods getGoodsById(Integer id);

	int upd(Goods goods);

	int del(Integer id);

	int dels(String ids);

}
