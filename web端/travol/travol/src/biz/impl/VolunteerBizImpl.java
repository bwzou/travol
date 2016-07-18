package biz.impl;

import java.sql.Date;
import java.util.List;

import po.Volunteer;
import vo.PageBean;
import dao.VolunteerDao;
import dao.impl.VolunteerDaoImpl;
import biz.VolunteerBiz;


public class VolunteerBizImpl implements VolunteerBiz {

	private VolunteerDao volunteerDao =new VolunteerDaoImpl();
	@Override
	public Volunteer userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return volunteerDao.findByVolByUsernameAndPassword(username, password);
	}

	@Override
	public List<Volunteer> getAllVolunteer() {
		// TODO Auto-generated method stub
		return volunteerDao.findAll();
	}

	@Override
	public List<Volunteer> getVolunteerByCondition(String city, String scenic,
			String gender, String joinDate) {
		// TODO Auto-generated method stub
		return volunteerDao.findByCityScenicGenderTime(city, scenic, gender, joinDate);
	}

	@Override
	public boolean updateById(int id, Volunteer volunteer) {
		// TODO Auto-generated method stu
		return volunteerDao.updateVolunteerById(id,volunteer);
	}

	@Override
	public boolean changePasswordById(int id, String password) {
		// TODO Auto-generated method stub
		Volunteer volunteer=volunteerDao.findById(id);
		volunteer.setPassword(password);
		volunteerDao.updateVolunteerById(id,volunteer);
		return true;
	}

	@Override
	public String registUser(String username, String email,String password) {
		// TODO Auto-generated method stub
		boolean flag1=(new VolunteerDaoImpl().findByUsername(username) == null);
		boolean flag2=(new VolunteerDaoImpl().findByEmail(email) == null);
		if(!flag1)
			return "用户名已存在";
		if(!flag2)
			return "邮箱已被注册";
		Volunteer volunteer=new Volunteer();
		volunteer.setUsername(username);
		volunteer.setEmail(email);
		volunteer.setPassword(password);
		
		java.util.Date udate=new java.util.Date();
		Date jion_date=new Date(udate.getTime());
		volunteer.setJoinDate(jion_date);
		
		volunteer.setServiceTimes(0);
		volunteer.setRating(0f);
		
		volunteerDao.insertVolunteer(volunteer);
		 return "success";
	}
	
	@Override
	public PageBean getVolunteerByPage(int pagesize, int currpage) {
		// TODO Auto-generated method stub
		int rowcount = volunteerDao.getVolunteerCount();
		int pagecount = rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
		List<Volunteer> data = volunteerDao.findVolunteerByPage(pagesize, currpage);
		PageBean pageBean = new PageBean();
		pageBean.setPagesize(pagesize);
		pageBean.setRowcount(rowcount);
		pageBean.setPagecount(pagecount);
		pageBean.setCurrpage(currpage);
		pageBean.setData(data);
		return pageBean;
	}
}
