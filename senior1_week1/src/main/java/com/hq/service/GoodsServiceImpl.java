package com.hq.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hq.bean.Goods;
import com.hq.dao.GoodsDAO;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Resource
	private GoodsDAO goodsDAO;

	@Override
	public List list(Map map) {
		// TODO Auto-generated method stub
		return goodsDAO.list(map);
	}

	@Override
	public List brandList() {
		// TODO Auto-generated method stub
		return goodsDAO.brandList();
	}

	@Override
	public List typeList() {
		// TODO Auto-generated method stub
		return goodsDAO.typeList();
	}

	@Override
	public int add(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.add(goods);
	}

	@Override
	public Goods getGoodsById(Integer id) {
		// TODO Auto-generated method stub
		return goodsDAO.getGoodsById(id);
	}

	@Override
	public int upd(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDAO.upd(goods);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return goodsDAO.del(id);
	}

	@Override
	public int dels(String ids) {
		// TODO Auto-generated method stub
		return goodsDAO.dels(ids);
	}
}
