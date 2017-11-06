package com.deep.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deep.backend.dao.ProductDAO;
import com.deep.backend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);	
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);	
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		try {
			Product product = this.getProduct(id);
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);	
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Product getProduct(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> listProducts() {
		String selectQuery = "FROM Product WHERE active = :active";
		Query q = sessionFactory.getCurrentSession().createQuery(selectQuery);
		q.setParameter("active", true);
		return q.getResultList();
	}

}
