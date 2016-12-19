package cn.javass.chapter4.model;

public class EngineModel {
	
   
	
	
	private String  enginestate;
	
	private String enginename;
	
	private String engineInfo;
	

	public String getEnginename() {
		return enginename;
	}

	public void setEnginename(String name) {
		this.enginename = name;
	}
	
	public String getEngineInfo() {
		return engineInfo;
	}
	
	public void setEngineInfo(String info) {
		this.engineInfo = info;
	}

	public void setEnginestate(String state) {
		this.enginestate = state;
	}
	
	public String getEnginestate() {
		return enginestate;
	}



	@Override
	public String toString() {
		return "UserModel [username=" + enginename + ", engineInfo=" + engineInfo
				+ ", state=" + enginestate  + "]";
	}
}
