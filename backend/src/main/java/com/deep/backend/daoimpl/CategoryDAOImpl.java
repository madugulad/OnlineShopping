package com.deep.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deep.backend.dao.CategoryDAO;
import com.deep.backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	static List<Category> categories = new ArrayList<Category>();
	
	@Autowired
	private SessionFactory factory;
	
	
	
	@Override
	public List<Category> list() {
		String selectQuery = "FROM Category WHERE active = :active";
		Query q = factory.getCurrentSession().createQuery(selectQuery);
		q.setParameter("active", true);
		
		return q.getResultList();
	}
	
	
	@Override
	public Category getCategory(int id) {
		
		return factory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	
	
	@Override
	public boolean add(Category category) {
		try {
			factory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean update(Category category) {
		try {
			factory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(int id) {
		
		try {
			Category ct = getCategory(id);
			ct.setActive(false);
			factory.getCurrentSession().update(ct);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
