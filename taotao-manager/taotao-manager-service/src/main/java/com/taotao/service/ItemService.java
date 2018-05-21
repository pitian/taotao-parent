package com.taotao.service;


import com.taotao.pojo.TbItem;
import common.pojo.EasyUIDataGrideResult;

public interface ItemService {
	public TbItem queryTbItemById(Long id) throws Exception;
	
	public EasyUIDataGrideResult getItemList(int page, int rows) throws Exception;

}
