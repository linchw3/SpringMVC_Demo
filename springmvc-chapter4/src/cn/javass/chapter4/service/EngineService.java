package cn.javass.chapter4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.javass.chapter4.model.EngineModel;

public class EngineService {

	//实际应该存数据库
	private Map<String, EngineModel> userDB = new HashMap<String, EngineModel>(); 
	
	public void create(EngineModel engine) {
		if(userDB.containsKey(engine.getEnginename())) {
			throw new RuntimeException(String.format("%s用户已经存在", engine.getEnginename()));
		}
		userDB.put(engine.getEnginename(), engine);
		System.out.println(userDB.size());
	}
	
	public void update(EngineModel engine) {
		if(!userDB.containsKey(engine.getEnginename())) {
			throw new RuntimeException(String.format("%s用户不存在", engine.getEnginename()));
		}
		userDB.put(engine.getEnginename(), engine);
	}
	
	public void delete(EngineModel engine) {
		if(!userDB.containsKey(engine.getEnginename())) {
			throw new RuntimeException(String.format("%s用户不存在",engine.getEnginename()));
		}
		userDB.remove(engine.getEnginename());
	}
	
	public EngineModel get(String username) {
		return userDB.get(username);
	}
	
	public List<EngineModel> list() {
		return new ArrayList<EngineModel>(userDB.values());
	}
	
}
