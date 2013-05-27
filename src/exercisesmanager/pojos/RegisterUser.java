package exercisesmanager.pojos;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class RegisterUser extends User {

	private String confirmPassword;

	public RegisterUser() {

	}

	public RegisterUser(Integer id) {
		super(id);
	}

	public RegisterUser(String username, String password) {
		super(username, password);
	}

	public RegisterUser(String username, String password, String confirmPassword) {
		super(username, password);
		this.confirmPassword = confirmPassword;
	}

	public RegisterUser(Integer id, String username, String password, String first_name, String last_name,
			String email, Timestamp insert_date, Timestamp update_date, Timestamp delete_date, String active) {
		super(id, username, password, first_name, last_name, email, insert_date, update_date, delete_date, active);
	}

	public RegisterUser(Integer id, String username, String password, String confirmPassword, String first_name,
			String last_name, String email, Timestamp insert_date, Timestamp update_date, Timestamp delete_date,
			String active) {
		super(id, username, password, first_name, last_name, email, insert_date, update_date, delete_date, active);
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "[ User=" + super.toString() + ", confirmPassword=" + confirmPassword + "]";
	}

}
