package biz.impl;

import java.sql.Date;
import java.util.List;

import po.Tourist;
import vo.PageBean;
import dao.TouristDao;
import dao.impl.TouristDaoImpl;
import biz.TouristBiz;


public class TouristBizImpl implements TouristBiz {

	private TouristDao touristDao =new TouristDaoImpl();
	@Override
	public Tourist userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return touristDao.findTouByUsernameAndPassword(username, password);
	}

	@Override
	public List<Tourist> getAllTourist() {
		// TODO Auto-generated method stub
		return touristDao.findAll();
	}

	@Override
	public boolean updateById(int id, Tourist tourist) {
		// TODO Auto-generated method stub
		return touristDao.updateTouristById(id, tourist);
	}

	@Override
	public boolean changePasswordById(int id, String password) {
		// TODO Auto-generated method stub
		Tourist tourist=touristDao.findById(id);
		tourist.setPassword(password);
		touristDao.updateTouristById(id, tourist);
		return true;
	}

	@Override
	public String registUser(String username, String email, String password) {
		// TODO Auto-generated method stub
		boolean flag1=(new TouristDaoImpl().findByUsername(username) == null);
		boolean flag2=(new TouristDaoImpl().findByEmail(email) == null);
		if(!flag1)
			return "用户名已存在";
		if(!flag2)
			return "邮箱已被注册";
		Tourist tourist=new Tourist();
		tourist.setUsername(username);
		tourist.setEmail(email);
		tourist.setPassword(password);
		
		java.util.Date udate=new java.util.Date();
		Date jion_date=new Date(udate.getTime());
		tourist.setJoinDate(jion_date);
		
		touristDao.insertTourist(tourist);
		 return "success";
	}

	@Override
	public PageBean getTouristByPage(int pagesize, int currpage) {
		// TODO Auto-generated method stub
		int rowcount = touristDao.getTouristCount();
		int pagecount = rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
		List<Tourist> data = touristDao.findTouristByPage(pagesize, currpage);
		PageBean pageBean = new PageBean();
		pageBean.setPagesize(pagesize);
		pageBean.setRowcount(rowcount);
		pageBean.setPagecount(pagecount);
		pageBean.setCurrpage(currpage);
		pageBean.setData(data);
		return pageBean;
	}

}
