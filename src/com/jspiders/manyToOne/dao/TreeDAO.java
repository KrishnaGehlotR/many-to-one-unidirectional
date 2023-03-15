package com.jspiders.manyToOne.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jspiders.hibernate.util.HibernateUtil;
import com.jspiders.manyToOne.dto.TreeDTO;
import com.jspiders.manyToOne.dto.TreeDTO;

public class TreeDAO {

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public void saveTree(TreeDTO treeDTO) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(treeDTO);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public TreeDTO getTreeById(int pk) {
		TreeDTO treeDTO = null;
		try (Session session = factory.openSession();) {
			treeDTO = session.get(TreeDTO.class, new Integer(pk));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return treeDTO;
	}
}
