package service;


import common.pojo.EasyUIDataGrideResult;
import pojo.TbItem;

public interface ItemService {
	public TbItem queryTbItemById(Long id) throws Exception;
	
	public EasyUIDataGrideResult getItemList(int page, int rows) throws Exception;

}
