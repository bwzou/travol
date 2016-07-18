package dao;

import java.util.List;
import po.Service;


public interface ServiceDao {
    public abstract void save(Service transientInstance);
	
	public abstract boolean insertService(Service service);

	public abstract boolean deleteServiceById(int Id);
	
	public abstract boolean updateServiceById(int id, Service service);

	public abstract Service findById(Integer id);
	
	public abstract List findByTouristId(int id);            //查看游客所有的的请求服务

	public abstract List findByTouristIdAndState(int id,int state);      //做状态是一个下拉菜单   

	public abstract List findByVolunteerId(int id);            //查看游客所有的

	public abstract List findByVolunteerIdAndState(int id,int state);      //做状态是一个下拉菜单   
	
	public abstract List findByAll();
}
