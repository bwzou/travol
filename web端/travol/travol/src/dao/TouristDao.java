package dao;

import java.util.List;

import po.Tourist;




public interface TouristDao {

	public abstract void save(Tourist transientInstance);
	
	public abstract boolean insertTourist(Tourist tourist);

	public abstract void delete(Tourist persistentInstance);
	
	public abstract boolean updateTouristById(int id, Tourist tourist);

	public abstract Tourist findById(Integer id);
	
	public abstract Tourist findByEmail(String email);

	public abstract Tourist findByUsername(String username);

	public abstract List findByName(String name);

	public abstract List findByGender(String gender);

	public abstract List findAll();

	public abstract Tourist findTouByUsernameAndPassword(String username,
			String password);
	
	//根据这个来分页
		List<Tourist> findTouristByPage(int pagesize,int currpage);
		
		int getTouristCount();

}