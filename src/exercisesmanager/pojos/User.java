package exercisesmanager.pojos;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pif.utils.annotation.PifExcludeForUpdate;

@Component
@Service
public class User {

	@PifExcludeForUpdate
	private Integer id;

	private String username;

	private String password;

	private String first_name;

	private String last_name;

	private String email;

	@PifExcludeForUpdate
	private Timestamp insert_date;

	@PifExcludeForUpdate
	private Timestamp update_date;

	@PifExcludeForUpdate
	private Timestamp delete_date;

	@PifExcludeForUpdate
	private String active;

	public User() {
		super();
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password, String first_name, String last_name, String email,
			Timestamp insert_date, Timestamp update_date, Timestamp delete_date, String active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.insert_date = insert_date;
		this.update_date = update_date;
		this.delete_date = delete_date;
		this.active = active;
	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.first_name = user.getFirst_name();
		this.last_name = user.getLast_name();
		this.email = user.getEmail();
		this.insert_date = user.getInsert_date();
		this.update_date = user.getUpdate_date();
		this.delete_date = user.getDelete_date();
		this.active = user.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	public Timestamp getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(Timestamp delete_date) {
		this.delete_date = delete_date;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
