package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.FreeTime;
import po.Volunteer;
import dao.FreeTimeDao;
import dbutil.DBHelper;

public class FreeTimeDaoImpl implements FreeTimeDao {
	private DBHelper dbHelper = new DBHelper();

	@Override
	public List<FreeTime> findFreeTimeByVid(int vid) {
		String sql = "select * from free_time where v_id=? order by free_date";
		ResultSet rst = dbHelper.execQuery(sql,vid);
		List<FreeTime> list=new ArrayList<FreeTime>();
		try {
			while (rst.next()) {
				FreeTime freeTime = new FreeTime();
				freeTime.setId(rst.getInt("id"));
				freeTime.setVid(rst.getInt("v_id"));
				freeTime.setFreeDate(rst.getDate("free_date"));
				list.add(freeTime);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;	
	}

	@Override
	public boolean addFreeTime(int vid, Date date) {
		// TODO Auto-generated method stub
		DBHelper dbHelper2=new DBHelper();
		String sql="insert into free_time(v_id,free_date) values(?,?)";
		int n=dbHelper2.execOthers(sql,vid,date);//n影响行数
		dbHelper2.closeAll();
		if(n>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteFreeTimeById(int id) {
		// TODO Auto-generated method stub
		String sql="delete from free_time where id=?";
		//Integer Id=new Integer(id);
		int n=dbHelper.execOthers(sql,id);
		dbHelper.closeAll();
		if(n>0)
			return true;
		return false;
	}
	public boolean deleteFreeTimeByVId(int vid) {
		// TODO Auto-generated method stub
		String sql="delete from free_time where v_id=?";
		//Integer Id=new Integer(id);
		int n=dbHelper.execOthers(sql,vid);
		dbHelper.closeAll();
		if(n>0)
			return true;
		return false;
	}
	@Override
	public List<FreeTime> findFreeTimeByValue(String type, Object value) {
		// TODO Auto-generated method stub
		String sql = "select * from free_time where "+type+"=?";
		ResultSet rst = dbHelper.execQuery(sql,value);
		List<FreeTime> list=new ArrayList<FreeTime>();
		try {
			while (rst.next()) {
				FreeTime freeTime = new FreeTime();
				freeTime.setId(rst.getInt("id"));
				freeTime.setVid(rst.getInt("v_id"));
				freeTime.setFreeDate(rst.getDate("free_date"));
				list.add(freeTime);
			}
			rst.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public FreeTime findFreeTimeByVidDate(int vid, Date date) {
		// TODO Auto-generated method stub
		String sql="select * from free_time where v_id=? and free_date=DATE(?)";
		DBHelper dbHelper2=new DBHelper();
		ResultSet rst=dbHelper2.execQuery(sql,vid,new java.sql.Date(date.getTime()));
		FreeTime freeTime=null;
		try {
			if(rst.next())
			{
				freeTime = new FreeTime();
				freeTime.setId(rst.getInt("id"));
				freeTime.setVid(rst.getInt("v_id"));
				freeTime.setFreeDate(rst.getDate("free_date"));
			}
			rst.close();
			return freeTime;//已经
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			dbHelper2.closeAll();
		}
		return freeTime;
	}

	@Override
	public List<FreeTime> findFreeTimeByDate(Date date) {
		// TODO Auto-generated method stub
		return this.findFreeTimeByValue("Date", date);
	}

}
