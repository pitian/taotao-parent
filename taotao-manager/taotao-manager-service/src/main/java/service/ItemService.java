package service;

import main.java.common.pojo.EasyUIDataGrideResult;

import com.taotao.pojo.TbItem;

public interface ItemService {
	public TbItem queryTbItemById(Long id) throws Exception;
	
	public EasyUIDataGrideResult getItemList(int page, int rows) throws Exception;

}
