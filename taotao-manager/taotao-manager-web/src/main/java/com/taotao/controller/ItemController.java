package com.taotao.controller;

import com.taotao.pojo.TbItem;
import common.pojo.EasyUIDataGrideResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public EasyUIDataGrideResult getItemList(Integer page, Integer rows) throws Exception{
		EasyUIDataGrideResult result = itemService.getItemList(page, rows);
		return result;
	}
}
