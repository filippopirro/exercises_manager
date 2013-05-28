package exercisesmanager.dao.implementors;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import pif.io.database.dml.InsertInto;
import pif.io.database.dml.Select;
import pif.io.database.dml.Set;
import pif.io.database.dml.Update;
import pif.io.database.dml.Where;
import exercisesmanager.dao.UserDao;
import exercisesmanager.pojos.User;

@Transactional(rollbackFor = { Exception.class })
public class UserDaoImpl implements UserDao {

	protected final Log logger = LogFactory.getLog(getClass());
	private static DataSourceTransactionManager transactionManager;
	private static DataSource dataSource;

	// private static JdbcTemplate jdbcTemplate;

	public UserDaoImpl() {
		super();
	}

	@Autowired
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		UserDaoImpl.transactionManager = transactionManager;
		dataSource = UserDaoImpl.transactionManager.getDataSource();
		// jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> selectAll() throws Exception {
		Select query = new Select(User.class);
		logger.info(query.getSqlStatement());
		query.execute(dataSource.getConnection());
		List<User> users = (List<User>) query.getAllRows();
		return users;
	}

	@Override
	public User selectById(Integer id) throws Exception {
		User user = selectById(new User(id));
		return user;
	}

	@Override
	public User selectById(User user) throws Exception {
		Select select = new Select(user.getClass(), user.getClass().getSimpleName().toLowerCase() + "_v", "id", user.getId());
		logger.info(select.getSqlStatement());
		select.execute(dataSource.getConnection());
		User userResult = (User) select.getFirstRow();
		return userResult;
	}

	public User selectByUsername(String username) throws Exception {
		Select select = new Select("*", "", "user");
		Where whereClause = new Where("username", username);
		select.setWhereClause(whereClause);
		logger.info(select.getSqlStatement());
		select.execute(dataSource.getConnection());
		User userResult = (User) select.getFirstRow();
		return userResult;
	}

	public User selectByCredentials(User user) throws Exception {
		Select select = new Select(user.getClass(), user.getClass().getSimpleName().toLowerCase() + "_v", "username",
				user.getUsername(), "password", user.getPassword());
		logger.info(select.getSqlStatement());
		select.execute(dataSource.getConnection());
		User userResult = (User) select.getFirstRow();
		return userResult;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		deleteById(new User(id));
	}

	@Override
	public void deleteById(User user) throws Exception {
		Set setClause = new Set("active", "N");
		Where whereClause = new Where("id", user.getId());
		Update dml = new Update(User.class.getSimpleName().toLowerCase(), setClause, whereClause);
		logger.info(dml.getSqlStatement());
		dml.execute(dataSource.getConnection());
	}

	@Override
	public void insert(User user) throws Exception {
		InsertInto query = new InsertInto(user);
		logger.info(query.getSqlStatement());
		query.execute(dataSource.getConnection());
	}

	@Override
	public void updateById(User user) throws Exception {
		String tableName = User.class.getSimpleName().toLowerCase();
		Set setClause = new Set(user);
		Where whereClause = new Where("id", user.getId());
		Update dml = new Update(tableName, setClause, whereClause);
		logger.info(dml.getSqlStatement());
		dml.execute(dataSource.getConnection());

	}

}
