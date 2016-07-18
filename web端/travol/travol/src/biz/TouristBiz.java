package biz;

import java.util.List;

import po.Tourist;
import vo.PageBean;

public interface TouristBiz {

	Tourist userLogin(String username, String password);

	List<Tourist> getAllTourist();

	boolean updateById(int id, Tourist volunteer);

	boolean changePasswordById(int id, String password);

	String registUser(String username, String email, String password);

    //分页查找
  	 PageBean getTouristByPage(int pagesize,int currpage);
}
