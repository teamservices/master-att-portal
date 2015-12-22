package com.att.services;

import com.att.dao.PageDao;
import com.att.domain.Classification;
import com.att.domain.Domains;
import com.att.domain.FunctionalArea;
import com.att.domain.Platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PageServiceImpl implements PageService {

	@Autowired
	PageDao pageDao;

	@Override
	public List<Classification> getClassyList() {
		return pageDao.getClassyList();
	}

	@Override
	public List<FunctionalArea> getAreasList(String id) {
		return pageDao.getAreasList(id);
	}

	@Override
	public List<Platform> getPlatformList(String id) {
		return pageDao.getPlatformList(id);
	}

	@Override
	public List<Domains> getDomainsList(String id, String pId) {
		return pageDao.getDomainsList(id, pId);
	}

}
