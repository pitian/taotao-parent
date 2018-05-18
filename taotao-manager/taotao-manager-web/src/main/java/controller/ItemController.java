package com.taotao.controller;

import java.util.List;

import main.java.common.pojo.EasyUIDataGrideResult;
import main.java.common.pojo.EasyUITreeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.internal.ws.processor.model.ModelVisitor;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemCatService;
import com.taotao.service.ItemService;

/**
 * 商品查询
 * @author pitian
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) throws Exception{
		TbItem tbItem = itemService.queryTbItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGrideResult getItemList(Integer page,Integer rows) throws Exception{
		EasyUIDataGrideResult result = itemService.getItemList(page, rows);
		return result;
	}
}
