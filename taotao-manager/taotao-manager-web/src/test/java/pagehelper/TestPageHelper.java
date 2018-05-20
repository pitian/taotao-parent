package pagehelper;

import java.util.List;

import mapper.TbItemMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import pojo.TbItem;
import pojo.TbItemExample;


public class TestPageHelper {
	@Test
	public void testPageHelper() throws Exception{
		//1.获得mapper 代理对象
		//初始化spring 容器
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		SqlSessionFactory sessionFactory = (SqlSessionFactory) application.getBean("sqlSession");
//		TbItem tbItem = sessionFactory.openSession().getMapper(TbItem.class);
		TbItemMapper tbItemMapper = application.getBean(TbItemMapper.class);
		//2.设置分页
		PageHelper.startPage(1, 30);
		//3.执行查询
		TbItemExample example = new TbItemExample();//查询所有的
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//4.分页后的结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("totao:" + total);
		int pages = pageInfo.getPages();
		System.out.println("pages:" + pages);
		int pageSize = pageInfo.getPageSize();
		System.out.println("pageSize" + pageSize);
	}

}
