package cn.com.demo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import cn.com.demo.mybatis.dao.IDmModulDAO;
import cn.com.demo.mybatis.dao.IDmPowerItemDAO;

public class DAOFactroy {
//	@Autowired
//	@Qualifier("sqlSessionFactory")
//	private  SqlSessionFactory sqlSessionFactory;
//	public  Object createDao(Class cl){
//		Object obj = null;
//		SqlSession session = sqlSessionFactory.openSession();
//		obj = session.getMapper(cl);
//		return obj;
//	}
//	@Bean(name ="powerItemDao")
//	public IDmPowerItemDAO getPowerItemDao(){
//		IDmPowerItemDAO powerItemDao = (IDmPowerItemDAO) createDao(IDmPowerItemDAO.class);
//		return powerItemDao;
//	}
//	@Bean(name ="modulDao")
//	public IDmModulDAO getModulDao(){
//		IDmModulDAO modulDao = (IDmModulDAO) createDao(IDmModulDAO.class);
//		return modulDao;
//	}
}
