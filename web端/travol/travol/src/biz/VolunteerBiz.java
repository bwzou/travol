package biz;

import java.sql.Date;
import java.util.List;

import po.Volunteer;
import vo.PageBean;

public interface VolunteerBiz {
	
	Volunteer userLogin(String username,String password);
	
	 List<Volunteer> getAllVolunteer();
	
	 List<Volunteer> getVolunteerByCondition(String city, String scenic,String gender, String joinDate);
	 
	 boolean updateById(int id, Volunteer volunteer);
	 
	 boolean changePasswordById(int id,String password);
	 
	 String registUser(String username,String email,String password);
	 
	//分页查找
	PageBean getVolunteerByPage(int pagesize,int currpage);
}
