package com.suis.logistics.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.City;
import com.suis.logistics.repository.common.RegionDao;

@Component
public class RegionServiceImpl implements RegionService {
	@Resource
	RegionDao regionDao;

	@Override
	public List<City> getCitiesByName(String name) {
		return regionDao.getCitiesByName(name);
	}
}
