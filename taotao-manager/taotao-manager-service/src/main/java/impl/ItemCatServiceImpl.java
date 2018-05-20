package impl;

import java.util.ArrayList;
import java.util.List;

import common.pojo.EasyUITreeNode;
import mapper.TbItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbItemCat;
import pojo.TbItemCatExample;
import service.ItemCatService;


@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) throws Exception {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		TbItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询条件
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);
		//装换成树形列表
		List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
		for(TbItemCat tbItemCat:tbItemCatList){
			//创建一个节点对象
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

}
