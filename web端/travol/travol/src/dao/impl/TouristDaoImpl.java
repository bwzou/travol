package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBHelper;
import dao.TouristDao;
import po.Tourist;

public class TouristDaoImpl implements TouristDao {

	private DBHelper dbHelper = new DBHelper();

	@Override
	public void save(Tourist transientInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean insertTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		String sql = "insert into tourist" + "(username,email,password,"
				+ "name,gender,birthday,telephone_number,"
				+ "join_date,photograph)"
				// + "values(?,?,?,"
				// + "?,?,?,"
				// + "?,?,?,"
				+ "values(?,?,?,?,?,?,?,?,?)";
		int n = dbHelper.execOthers(sql, tourist.getUsername(),
				tourist.getEmail(), tourist.getPassword(), tourist.getName(),
				tourist.getGender(), tourist.getBirthday(),
				tourist.getTelephoneNumber(), tourist.getJoinDate(),
				tourist.getPhotograph());// n影响行数
		dbHelper.closeAll();
		System.out.println("插入行数" + n);
		if (n > 0)
			return true;
		else
			return false;
	}

	@Override
	public void delete(Tourist persistentInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updateTouristById(int id, Tourist tourist) {
		// TODO Auto-generated method stub
		String sql = "update tourist set " + "username=?" + ",email=?"
				+ ",password=?" + ",name=?" + ",gender=?" + ",birthday=?"
				+ ",telephone_number=?" + ",join_date=?" + ",photograph=?"
				+ " where id=? ";
		int n = dbHelper.execOthers(sql, tourist.getUsername(),
				tourist.getEmail(), tourist.getPassword(), tourist.getName(),
				tourist.getGender(), tourist.getBirthday(),
				tourist.getTelephoneNumber(), tourist.getJoinDate(),
				tourist.getPhotograph(), id);
		dbHelper.closeAll();
		if (n > 0)
			return true;
		else
			return false;
	}

	public Tourist findTouristByValue(String type, String value) {
		// TODO Auto-generated method stub
		DBHelper dbHelper = new DBHelper();
		String sql = "select * from tourist where " + type + "=?";
		ResultSet rst = dbHelper.execQuery(sql, value);
		try {
			if (rst.next()) {
				Tourist tourist = new Tourist();
				tourist.setId(rst.getInt("id"));
				tourist.setBirthday(rst.getDate("birthday"));
				tourist.setGender(rst.getString("gender"));
				tourist.setEmail(rst.getString("email"));
				tourist.setUsername(rst.getString("username"));
				tourist.setPassword(rst.getString("password"));
				tourist.setName(rst.getString("name"));
				tourist.setJoinDate(rst.getDate("join_date"));
				tourist.setTelephoneNumber(rst.getString("telephone_number"));
				tourist.setPhotograph(rst.getString("photograph"));
				rst.close();
				return tourist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public Tourist findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from tourist where id=" + id;
		ResultSet rst = dbHelper.execQuery(sql);

		try {
			Tourist tourist = null;
			if (rst.next()) {
				//
				tourist = new Tourist();
				tourist.setId(rst.getInt("id"));
				tourist.setBirthday(rst.getDate("birthday"));
				tourist.setGender(rst.getString("gender"));
				tourist.setEmail(rst.getString("email"));
				tourist.setUsername(rst.getString("username"));
				tourist.setPassword(rst.getString("password"));
				tourist.setName(rst.getString("name"));
				tourist.setJoinDate(rst.getDate("join_date"));
				tourist.setTelephoneNumber(rst.getString("telephone_number"));
				tourist.setPhotograph(rst.getString("photograph"));
			}
			rst.close();
			return tourist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.TouristDao#findByUsername(java.lang.Object)
	 */
	@Override
	public Tourist findByEmail(String email) {
		// TODO Auto-generated method stub
		return findTouristByValue("email", email);
	}

	@Override
	public List findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tourist findByUsername(String username) {
		// TODO Auto-generated method stub
		return findTouristByValue("username", username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.TouristDao#findByGender(java.lang.Object)
	 */

	@Override
	public List findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.TouristDao#findAll()
	 */
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		// 查找所有的游客SQL语句
		String sql = "select* from tourist"; // 多表链接应该不能这么写
		// 查询的结果集
		ResultSet rst = dbHelper.execQuery(sql);
		// 把结果集转成list
		try {
			List<Tourist> tourists = new ArrayList<Tourist>();
			while (rst.next()) {
				// 一条条转化
				Tourist tourist = new Tourist();
				tourist.setId(rst.getInt("id"));
				tourist.setEmail(rst.getString("email"));
				tourist.setBirthday(rst.getDate("birthday"));
				tourist.setGender(rst.getString("gender"));
				tourist.setUsername(rst.getString("username"));
				tourist.setPassword(rst.getString("password"));
				tourist.setName(rst.getString("name"));
				tourist.setJoinDate(rst.getDate("join_date"));
				tourist.setTelephoneNumber(rst.getString("telephone_number"));
				tourist.setPhotograph(rst.getString("photograph"));
				// 添加结果集
				tourists.add(tourist);
			}
			rst.close();
			return tourists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public Tourist findTouByUsernameAndPassword(String username, String password) {
		// 根据用户名和密码查找
		String sql = "select * from tourist where username=? and password=?";
		ResultSet rst = dbHelper.execQuery(sql, username, password);
		// 把结果集转成list
		try {
			if (rst.next()) {
				Tourist tourist = new Tourist();
				tourist.setId(rst.getInt("id"));
				tourist.setEmail(rst.getString("email"));
				tourist.setBirthday(rst.getDate("birthday"));
				tourist.setGender(rst.getString("gender"));
				tourist.setUsername(rst.getString("username"));
				tourist.setPassword(rst.getString("password"));
				tourist.setName(rst.getString("name"));
				tourist.setJoinDate(rst.getDate("join_date"));
				tourist.setTelephoneNumber(rst.getString("telephone_number"));
				tourist.setPhotograph(rst.getString("photograph"));
				rst.close();
				return tourist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	// 具备分页的功能
	public List<Tourist> findTouristByPage(int pagesize, int currpage) {
		String sql = "select * from tourist limit ?,?";
		ResultSet rst = dbHelper.execQuery(sql, pagesize * (currpage - 1),
				pagesize);
		try {
			List<Tourist> tourists = new ArrayList<Tourist>();
			while (rst.next()) {
				Tourist tourist = new Tourist();
				tourist.setId(rst.getInt("id"));
				tourist.setBirthday(rst.getDate("birthday"));
				tourist.setGender(rst.getString("gender"));
				tourist.setEmail(rst.getString("email"));
				tourist.setUsername(rst.getString("username"));
				tourist.setPassword(rst.getString("password"));
				tourist.setName(rst.getString("name"));
				tourist.setJoinDate(rst.getDate("join_date"));
				tourist.setTelephoneNumber(rst.getString("telephone_number"));
				tourist.setPhotograph(rst.getString("photograph"));
				// 添加结果集
				tourists.add(tourist);
			}
			rst.close();
			return tourists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	public int getTouristCount() {
		DBHelper dbHelper2 = new DBHelper();
		String sql = "select count(*) from tourist";
		ResultSet rst = dbHelper2.execQuery(sql);
		try {
			if (rst.next()) {
				int count = rst.getInt(1);
				rst.close();
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper2.closeAll();
		}
		return 0;
	}
}
