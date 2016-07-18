package biz;

import java.util.List;

import po.Service;

public interface ServiceBiz {
	public abstract boolean insertService(Service service);

	public abstract boolean  deleteServiceById(int Id);          
	
	public abstract boolean updateStateById(int id, Service service);

	public abstract Service findOneById(Integer id);
	
	public abstract List<Service> findByTouristId(int id);            //查看游客所有的的请求服务

	public abstract List<Service> findByTouristIdAndState(int id,int state);      //做状态是一个下拉菜单   

	public abstract List<Service> findByVolunteerId(int id);            //查看游客所有的

	public abstract List<Service> findByVolunteerIdAndState(int id,int state);      //做状态是一个下拉菜单 
	
	public abstract List<Service> findAllService();
}
