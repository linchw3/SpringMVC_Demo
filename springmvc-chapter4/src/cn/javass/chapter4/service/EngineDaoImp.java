package cn.javass.chapter4.service;

import java.util.Collection;
import java.util.List;

import cn.javass.chapter4.model.EngineModel;

public interface EngineDaoImp {
	public void insert(EngineModel model);
	public void delete(String name);
	public void update(EngineModel model);
	public EngineModel select(String name);
	public Collection<EngineModel> find();
	//public EngineModel selectByName(String name,String pwd);
}
