package com.yzx.elec.service;

import com.yzx.elec.web.form.ElecTextForm;


public interface IElecTextService {
	public static final String SERVICE_NAME = "com.yzx.dao.service.impl.ElecTextServiceImpl2";

	void save(ElecTextForm elecTextForm);
}
