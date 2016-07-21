package com.qiye.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.qiye.dao.UserDao;
import com.qiye.entity.News;
import com.qiye.entity.User;
/*、@controller 控制器（注入服务）
2、@service 服务（注入dao）
3、@repository dao（实现dao访问）
4、@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）*/
@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	
	public User getByName(String name) {
		User user = null;
		Session session =this.getHibernateTemplate().getSessionFactory().openSession();
		
		session.beginTransaction();
		Query query = session.createQuery("from User u where u.name = ?");
		query.setString(0, name);
		if(query.list().size()>0){
			user = (User) query.list().get(0);
		}
		session.getTransaction().commit();
		session.close();
		
		return user;
	}

	
	public List<String> listAllEmail() {
		Session session =this.getHibernateTemplate().getSessionFactory().openSession();
		
		session.beginTransaction();
		Query query = session.createQuery("select distinct(email) from User u");
		
		List<String> mails =query.list();
		session.getTransaction().commit();
		session.close();
			
		return mails;
	}


}
