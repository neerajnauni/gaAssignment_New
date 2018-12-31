package glaucus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import glaucus.model.Number;

@Repository
public class NumberDaoImpl implements NumberDao {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void updateNumber(Number n) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(n);
		
		logger.info("Number updated successfully="+n);
	}
	
	@Override
	public Number getNumberById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Number p = (Number) session.load(Number.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
}
