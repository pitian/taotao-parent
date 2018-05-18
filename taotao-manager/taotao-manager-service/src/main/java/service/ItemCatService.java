package service;

import java.util.List;

import main.java.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	
	public List<EasyUITreeNode> getItemCatList(long parentId)throws Exception;

}
