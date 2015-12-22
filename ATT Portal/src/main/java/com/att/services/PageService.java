package com.att.services;

import com.att.domain.Classification;
import com.att.domain.Domains;
import com.att.domain.FunctionalArea;
import com.att.domain.Platform;

import java.util.List;

public interface PageService {

	public List<Classification> getClassyList();

	public List<FunctionalArea> getAreasList(String id);

	public List<Platform> getPlatformList(String id);

	public List<Domains> getDomainsList(String id, String pId);
}
