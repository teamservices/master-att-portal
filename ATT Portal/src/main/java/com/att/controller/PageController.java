package com.att.controller;

import com.att.domain.FunctionalArea;
import com.att.domain.Platform;
import com.att.services.PageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	@Autowired
	PageService pageService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String servicesListPage(Model model) {
		model.addAttribute("catagory", pageService.getClassyList());
		return "services";
	}

	@RequestMapping(value = "/getFnAreas", method = RequestMethod.GET)
	public @ResponseBody List<FunctionalArea> getFnAreasList(@RequestParam("id") String id) {
		return pageService.getAreasList(id);
	}

	@RequestMapping(value = "/getPlatforms", method = RequestMethod.GET)
	public @ResponseBody List<Platform> getPlatformList(@RequestParam("id") String id) {
		return pageService.getPlatformList(id);
	}

	// @RequestMapping(value = "/getDomains", method = RequestMethod.GET)
	// public @ResponseBody List<Domains> getDomainsList(@RequestParam("id")
	// String id) {
	// return pageService.getDomainsList(id, pId);
	// }



}
