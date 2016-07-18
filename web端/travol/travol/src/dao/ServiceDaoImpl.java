package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBHelper;
import po.FreeTime;
import po.Service;

public class ServiceDaoImpl implements ServiceDao {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public void save(Service transientInstance) {
		// TODO Auto-generated method stub
		
        
	}

	@Override
	public boolean insertService(Service service) {
		// TODO Auto-generated method stub
		DBHelper dbHelper2=new DBHelper();
		String sql="insert into service(t_id,v_id,date,state) values(?,?,?,0)";   //"0"表示请求未被处理，"1"表示请求被接受，“-1”表示请求被拒接
        int n= dbHelper2.execOthers(sql,service.getT_id(),service.getV_id(),service.getDate());
         dbHelper2.closeAll();
        if(n>0){
    	   return true;
       }
		return false;
	}

	@Override
	public boolean deleteServiceById(int Id) {
		// TODO Auto-generated method stub
		DBHelper dbHelper2=new DBHelper();
		String sql="delete from service where id=?";
		 int n= dbHelper2.execOthers(sql,Id);
		 dbHelper2.closeAll();
		 if(n>0)
			 return true;
		 return false;
	}

	@Override
	public boolean updateServiceById(int id, Service service) {
		// TODO Auto-generated method stub
		DBHelper dbHelper2=new DBHelper();
		String sql="update service set state=?,rating=?,evaluation=? where id=?";
	    int n= dbHelper2.execOthers(sql,service.getState(),service.getRating(),service.getEvaluation(),id);
		dbHelper2.closeAll();
		if(n>0)
			return true;
		return false;
	}

	@Override
	public Service findById(Integer id) {
		// TODO Auto-generated method stub
		String sql="select* from  service where id=?";
		ResultSet rst=dbHelper.execQuery(sql,id);
		try {
			if(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
			    rst.close();
			    return service;//已经
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public List findByTouristId(int id) {
		// TODO Auto-generated method stub
		String sql="select* from  service where t_id=?";
		ResultSet rst=dbHelper.execQuery(sql,id);
		try {
			List<Service> services=new ArrayList<Service>();
			while(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
				// 添加结果集
				services.add(service);
			}
			rst.close();
		    return services;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public List findByTouristIdAndState(int id, int state) {
		// TODO Auto-generated method stub
		String sql="select* from  service where t_id=? and state=?";
		ResultSet rst=dbHelper.execQuery(sql,id,state);
		try {
			List<Service> services=new ArrayList<Service>();
			while(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
				// 添加结果集
				services.add(service);
			}
			rst.close();
		    return services;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public List findByVolunteerId(int id) {
		// TODO Auto-generated method stub
		String sql="select* from  service where v_id=?";
		ResultSet rst=dbHelper.execQuery(sql,id);
		try {
			List<Service> services=new ArrayList<Service>();
			while(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
				services.add(service);
				// 添加结果集
				
			}
			rst.close();
			System.out.println("到这里了");
		    return services;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public List findByVolunteerIdAndState(int id, int state) {
		// TODO Auto-generated method stub
		String sql="select* from  service where v_id=? and state=?";
		ResultSet rst=dbHelper.execQuery(sql,id,state);
		try {
			List<Service> services=new ArrayList<Service>();
			while(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
				// 添加结果集
				services.add(service);
			}
			rst.close();
		    return services;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public List findByAll() {
		// TODO Auto-generated method stub
		String sql="select* from  service";
		ResultSet rst=dbHelper.execQuery(sql);
		try {
			List<Service> services=new ArrayList<Service>();
			while(rst.next())
			{
				Service service=new Service();
				service.setId(rst.getInt("id"));
				service.setV_id(rst.getInt("v_id"));
				service.setT_id(rst.getInt("t_id"));
				service.setEvaluation(rst.getString("evaluation"));
				service.setDate(rst.getDate("date"));
			    service.setState(rst.getInt("state"));
			    service.setRating(rst.getFloat("rating"));
				service.setOpp_date(rst.getDate("opp_date"));
				// 添加结果集
				services.add(service);
			}
			rst.close();
		    return services;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper.closeAll();
		}
		return null;
	}

}
