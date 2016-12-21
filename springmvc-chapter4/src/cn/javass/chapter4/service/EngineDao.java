package cn.javass.chapter4.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.javass.chapter4.model.EngineModel;

public class EngineDao extends JdbcDaoSupport  implements EngineDaoImp{
	
	//private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(EngineModel model) {
		// TODO Auto-generated method stub
		String sql = "insert into engine(name, state, info)  values(?,?,?)";
		 this.getJdbcTemplate().update(sql, model.getEnginename(), model.getEnginestate(),model.getEngineInfo());
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		String sql = "delete from engine where name=?";
		 this.getJdbcTemplate().update(sql, name);
	}

	@Override
	public void update(EngineModel model) {
		// TODO Auto-generated method stub
		 String sql = "update engine set state=?,info=? where name=?";
		 this.getJdbcTemplate().update(sql, model.getEnginestate(), model.getEngineInfo(),model.getEnginename());
	}

	@SuppressWarnings("unchecked")
	@Override
	public EngineModel select(String name) {
		// TODO Auto-generated method stub
		String sql="select * from engine where name=?";
		//return this.getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(EngineModel.class),name);
		return this.getJdbcTemplate().queryForObject(sql, new EngineMapper(),name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<EngineModel> find() {
		// TODO Auto-generated method stub
		String sql="select * from engine";
		return this.getJdbcTemplate().query(sql, new EngineMapper());
	}
    
	/*
	 * 
	 * 使用rowMapper 19行用到， 因为query方法不能直接放回一个数组，所以我们只能通过rowMapper赋值给uservo;
	 * 
	 * RowMapper可以将数据中的每一行封装成用户定义的类，在数据库查询中，如果返回的类型是用户自定义的类型则需要包装
	 */
	private static final class EngineMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			EngineModel model = new EngineModel();
			model.setEnginename(rs.getString("name"));
			model.setEnginestate(rs.getString("state"));
			model.setEngineInfo(rs.getString("info"));
			return model;
		}
		
	
	}
	/*
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public Collection<EngineModel> search(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		String searchtext = '%' + name + '%';
		String sql="select * from engine where name like '" + searchtext + "'";
		return this.getJdbcTemplate().query(sql, new EngineMapper());
		//return null;
	}
	
}
