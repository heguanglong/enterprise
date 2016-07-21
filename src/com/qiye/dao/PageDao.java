package com.qiye.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PageDao extends BaseDao{
	/** *//** 
	　　 * 分页查询 
	　　 *  hql 查询的条件 
	　　 *offset 开始记录 
	　　 * length 一次查询几条记录 
	　　 * 
	　　 
	 *  <T>*/  
	public <T> List queryForPage(Class<T> entityClass,final String hql,final int offset,final int length);  /** *//** 
	　　 * 查询所有记录数 
	　　 *  hql 查询的条件 
	　　 * 总记录数 
	　　 */  
	public int getAllRowCount(String hql); 
}
