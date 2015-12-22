package com.att.dao;

import com.att.domain.Classification;
import com.att.domain.Domains;
import com.att.domain.FunctionalArea;
import com.att.domain.Platform;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PageDaoImpl implements PageDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Classification> getClassyList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Classification> cList = session.createQuery("from Classification").list();
		session.close();
		return cList;
	}

	@Override
	public List<FunctionalArea> getAreasList(String id) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<FunctionalArea> aList = session.createQuery("from FunctionalArea where c_id=" + id).list();
		session.close();
		return aList;
	}

	@Override
	public List<Platform> getPlatformList(String id) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Platform> pList = session.createQuery("from Platform").list();
		session.close();
		return pList;

	}

	@Override
	public List<Domains> getDomainsList(String id, String pId) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Domains> dList = session.createQuery("from Domains where c_id=" + id + "and p_id=" + pId).list();
		session.close();
		return dList;

	}

}
