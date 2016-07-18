package biz.impl;

import java.util.List;

import dao.ServiceDao;
import dao.ServiceDaoImpl;
import po.Service;
import biz.ServiceBiz;

public class ServiceBizImpl implements ServiceBiz {

	private ServiceDao serviceDao =new ServiceDaoImpl();
	@Override
	public boolean insertService(Service service) {
		// TODO Auto-generated method stub
		return serviceDao.insertService(service);
	}

	@Override
	public boolean  deleteServiceById(int Id) {
		// TODO Auto-generated method stub
		return serviceDao.deleteServiceById(Id);
	}

	@Override
	public boolean updateStateById(int id, Service service) {
		// TODO Auto-generated method stub
		return serviceDao.updateServiceById(id, service);
	}

	@Override
	public Service findOneById(Integer id) {
		// TODO Auto-generated method stub
		return serviceDao.findById(id);
	}

	@Override
	public List<Service> findByTouristId(int id) {
		// TODO Auto-generated method stub
		return serviceDao.findByTouristId(id);
	}

	@Override
	public List<Service> findByTouristIdAndState(int id, int state) {
		// TODO Auto-generated method stub
		return serviceDao.findByTouristIdAndState(id, state);
	}

	@Override
	public List<Service> findByVolunteerId(int id) {
		// TODO Auto-generated method stub
		return serviceDao.findByVolunteerId(id);
	}

	@Override
	public List<Service> findByVolunteerIdAndState(int id, int state) {
		// TODO Auto-generated method stub
		return serviceDao.findByVolunteerIdAndState(id, state);
	}

	@Override
	public List<Service> findAllService() {
		// TODO Auto-generated method stub
		return serviceDao.findByAll();
	}

}
