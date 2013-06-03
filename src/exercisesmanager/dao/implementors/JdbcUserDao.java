package exercisesmanager.dao.implementors;

import exercisesmanager.pojos.User;
import exercisesmanager.dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;



public class JdbcUserDao extends NamedParameterJdbcDaoSupport implements UserDao{

	public static final String selectAllSql="select id,username,password,first_name,last_name,email,active from user_v";
	public static final String selectByIdSql="select id,username,password,first_name,last_name,email,active from user_v where id=?"; 
	public static final String selectByUsernameSql="select id,username,password,first_name,last_name,email,active from user_v where username=?";
	public static final String selectByCredentialsSql="select id,username,password,first_name,last_name,email,active from user_v where username=:username and password=:password";
	public static final String deleteByIdSql="update user set active='N', date=:deletedate where id=:id";
	public static final String insertSql="insert into user(username,password,first_name,last_name,email,active) values(:username,:password,:first_name,:last_name,:email,:active)";
	public static final String updateByIdSql="update user set username=:username, password=:password, first_name=:first_name, last_name=:last_name, email=:email where id=:id";
	
	
	
	public List<User> selectAll() {
		ParameterizedRowMapper<User> rM = new ParameterizedRowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getString("active"));
				return user;
			}
		};
		return getJdbcTemplate().query(selectAllSql, rM);
	}

	public User selectById(Integer id) {
		ParameterizedRowMapper<User> rM = new ParameterizedRowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getString("active"));
				return user;
			}
		};
		return getJdbcTemplate().queryForObject(selectByIdSql, rM, id);
	}

	public User selectById(User user) {
		return selectById(user.getId());
	}
	
	public User selectByUsername(String username) {
		ParameterizedRowMapper<User> rM = new ParameterizedRowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getString("active"));
				return user;
			}
		};
		return getJdbcTemplate().queryForObject(selectByUsernameSql, rM, username);
	}
	
	public User selectByCredentials(User user) {
		ParameterizedRowMapper<User> rM = new ParameterizedRowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getString("active"));
				return user;
			}
		};
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		return getNamedParameterJdbcTemplate().queryForObject(selectByCredentialsSql,params,rM);
	}

	public void deleteById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		getNamedParameterJdbcTemplate().update(deleteByIdSql,params);
	}

	public void deleteById(User user) {
		deleteById(user.getId());
	}

	public void insert(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("first_name", user.getFirst_name());
		params.put("last_name", user.getLast_name());
		params.put("email", user.getEmail());
		params.put("active", "Y");
		getNamedParameterJdbcTemplate().update(deleteByIdSql,params);
	}

	public void updateById(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", user.getId());
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("first_name", user.getFirst_name());
		params.put("last_name", user.getLast_name());
		params.put("email", user.getEmail());
		getNamedParameterJdbcTemplate().update(updateByIdSql,params);
	}

}
