package com.hq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hq.bean.Goods;
import com.hq.service.GoodsService;
import com.hq.util.FileUploadUtil;

@Controller
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("list.do")
	public String list(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage,String mohu1
			,Double price_start,Double price_end,Integer mohu2,String typeId) {
		// typeId 可能是  1,2,3,4
		System.out.println(typeId);
		Map map=new HashMap();
		map.put("mohu1", mohu1);
		map.put("price_start", price_start);
		map.put("price_end", price_end);
		map.put("mohu2", mohu2);
		map.put("typeId", typeId);
		PageHelper.startPage(cpage,5);
		List list=goodsService.list(map);
		PageInfo pi=new PageInfo(list);
		
		// 在这里加载品牌的列表
		List brandList=goodsService.brandList();
		model.addAttribute("brandList",brandList);
		model.addAttribute("list", list);
		model.addAttribute("pi",pi);
		model.addAttribute("map", map);
		return "list";
	}
	
	@RequestMapping("typeList.do")
	@ResponseBody
	public Object typeList() {
		List list=goodsService.typeList();
		return list;
	}
	
	@RequestMapping("toadd.do")
	public String toAdd(Model model) {
		Goods goods=new Goods();
		model.addAttribute("goods", goods);
		List brandList = goodsService.brandList();
		List typeList = goodsService.typeList();
		
		model.addAttribute("brandList", brandList);
		model.addAttribute("typeList",typeList);
		return "add";
	}
	
	@RequestMapping("add.do")
	public String add(@Valid @ModelAttribute("goods")Goods goods,BindingResult br,Model model,
			MultipartFile file,HttpServletRequest request) {
		if(br.hasErrors()) {
			model.addAttribute("goods", goods);
			List brandList = goodsService.brandList();
			List typeList = goodsService.typeList();
			model.addAttribute("brandList", brandList);
			model.addAttribute("typeList",typeList);
			return "add";
		}else {
			System.out.println(file);
			//1:文件上传
			// 如果不上传图片不会报错
			if(file!=null&&file.getOriginalFilename().length()>0) {
				String load = FileUploadUtil.load(request.getSession(), file, "upload");
				goods.setGoodsPic("upload/"+load);
			}
			int i=goodsService.add(goods);
			return "redirect:list.do";
		}
	}
	@RequestMapping("toupd.do")
	public String toupd(Integer id,Model model) {
		Goods goods=goodsService.getGoodsById(id);
		List brandList = goodsService.brandList();
		List typeList = goodsService.typeList();
		model.addAttribute("brandList", brandList);
		model.addAttribute("typeList",typeList);
		model.addAttribute("goods", goods);
		return "upd";
	}
	@RequestMapping("upd.do")
	public String upd(Goods goods,MultipartFile file,HttpServletRequest request) {
		if(file!=null&&file.getOriginalFilename().length()>0) {
			String load = FileUploadUtil.load(request.getSession(), file, "upload");
			goods.setGoodsPic("upload/"+load);
		}
		int i=goodsService.upd(goods);
		return "redirect:list.do";
	}
	@RequestMapping("del.do")
	@ResponseBody
	public Object del(Integer id) {
		int i=goodsService.del(id);
		return i;
	}
	@RequestMapping("dels.do")
	@ResponseBody
	public Object dels(String ids) {
		int i=goodsService.dels(ids);
		return i;
	}
}
