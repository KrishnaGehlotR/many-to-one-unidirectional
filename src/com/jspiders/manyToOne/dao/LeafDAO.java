package com.jspiders.manyToOne.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jspiders.hibernate.util.HibernateUtil;
import com.jspiders.manyToOne.dto.LeafDTO;

public class LeafDAO {

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public void saveLeaf(LeafDTO leafDTO) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(leafDTO);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public LeafDTO getLeafById(int pk) {
		LeafDTO leafDTO = null;
		try (Session session = factory.openSession();) {
			leafDTO = session.get(LeafDTO.class, new Integer(pk));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return leafDTO;
	}
}
