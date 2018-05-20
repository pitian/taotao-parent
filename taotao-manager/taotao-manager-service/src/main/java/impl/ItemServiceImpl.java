package impl;

import java.util.List;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.pojo.EasyUIDataGrideResult;
import mapper.TbItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbItem;
import pojo.TbItemExample;
import service.ItemService;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem queryTbItemById(Long id) throws Exception {
		TbItem tbItem =null;
        TbItemExample example = new TbItemExample();
        //创建查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
		//		tbItemMapper.selectByPrimaryKey(id);
        criteria.andIdEqualTo(id);
        List<TbItem> tbItemList = tbItemMapper.selectByExample(example);
        if(tbItemList!=null&&tbItemList.size()>0){
        	tbItem = tbItemList.get(0);
        }
		return tbItem;
	}
	@Override
	public EasyUIDataGrideResult getItemList(int page, int rows)
			throws Exception {
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		List<TbItem> tbItemList = tbItemMapper.selectByExample(example);
		EasyUIDataGrideResult result = new EasyUIDataGrideResult();
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItemList);
		result.setTotal(pageInfo.getTotal());
		result.setRows(tbItemList);
		return result;
	}
	

}
