package exercisesmanager.pojos;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pif.utils.annotation.PifExcludeForUpdate;

@Component
@Service
public class ActivityType {

	@PifExcludeForUpdate
	private Integer id;
	
	private String name;

	@PifExcludeForUpdate
	private Timestamp insert_date;

	@PifExcludeForUpdate
	private Timestamp update_date;

	@PifExcludeForUpdate
	private Timestamp delete_date;

	@PifExcludeForUpdate
	private String active;

	public ActivityType() {
		super();
	}

	public ActivityType(Integer id) {
		super();
		this.id = id;
	}

	public ActivityType(Integer id, String name, Timestamp insert_date, String active) {
		super();
		this.id = id;
		this.name = name;
		this.insert_date = insert_date;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "ActivityType [id=" + id + ", name=" + name + "]";
	}

}
