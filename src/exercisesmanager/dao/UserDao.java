package exercisesmanager.dao;

import exercisesmanager.pojos.User;

import java.util.List;

public interface UserDao {

	public List<User> selectAll() throws Exception;

	public User selectById(Integer id) throws Exception;

	public User selectById(User user) throws Exception;

	public User selectByUsername(String username) throws Exception;
	
	public User selectByCredentials(User user) throws Exception;

	public void deleteById(Integer id) throws Exception;

	public void deleteById(User user) throws Exception;

	public void insert(User user) throws Exception;

	public void updateById(User user) throws Exception;

}
