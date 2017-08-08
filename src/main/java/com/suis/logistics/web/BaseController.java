package com.suis.logistics.web;

import javax.annotation.Resource;

import com.suis.logistics.common.ConverterUtil;

public abstract class BaseController {
	@Resource
	protected ConverterUtil converterUtil;
}
