package dao;

import java.sql.Date;
import java.util.List;
import po.Volunteer;

public interface VolunteerDao {

	public abstract void save(Volunteer transientInstance);

	public abstract boolean insertVolunteer(Volunteer volunteer);

	public abstract boolean updateVolunteerById(int id, Volunteer volunteer);

	public abstract Volunteer findVolunteerByValue(String type, String value);

	public abstract Volunteer findById(int id);

	public abstract Volunteer findByUsername(String username);

	public abstract Volunteer findByEmail(String email);

	public abstract List findByName(String name);

	public abstract List findByGender(String gender);

	public abstract List findByIdCard(String idCard);

	public abstract List findByCity(String city);

	public abstract List findByServiceTimes(Object serviceTimes);

	public abstract List findByRating(Object rating);

	public abstract List findAll();

	/**
	 * 根据游客提交表单查询志愿者
	 * @param city，scenic，gender，time
	 * @return 符合查询条件的志愿者
	 */   
	public abstract List findByCityScenicGenderTime(String city, String scenic,
			String gender, String joinDate);

	public abstract Volunteer findByVolByUsernameAndPassword(String username,
			String password);
	//根据这个来分页
	List<Volunteer> findVolunteerByPage(int pagesize,int currpage);
			
	int getVolunteerCount();
	
}