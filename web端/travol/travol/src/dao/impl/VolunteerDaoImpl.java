package dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.VolunteerDao;
import dbutil.DBHelper;
import po.Volunteer;

public class VolunteerDaoImpl implements VolunteerDao {
	private DBHelper dbHelper = new DBHelper();
	@Override
	public void save(Volunteer transientInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean insertVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		/*
		 * username	email	password	name	
		 * gender	age	telephone_number	join_date
		 * 	photograph	id_card	city	service_times	
		 * rating	self_introduction

		 */
		String sql="insert into volunteer"
				+ "(username,email,password,"
				+ "name,gender,birthday,telephone_number,"
				+ "join_date,photograph,id_card,"
				+ "place,service_times,rating,self_introduction)"
//				+ "values(?,?,?,"
//				+ "?,?,?,"
//				+ "?,?,?,"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int n=dbHelper.execOthers(sql,
			volunteer.getUsername(),volunteer.getEmail(),volunteer.getPassword(),
			volunteer.getName(),volunteer.getGender(),volunteer.getBirthday(),volunteer.getTelephoneNumber(),
			volunteer.getJoinDate(),volunteer.getPhotograph(),volunteer.getIdCard(),
			volunteer.getPlace(),volunteer.getServiceTimes(),volunteer.getRating(),volunteer.getSelfIntroduction()
			);//n影响行数
		dbHelper.closeAll();
		System.out.println("插入行数"+n);
		if(n>0)
			return true;
		else return false;
	}
	@Override
	public boolean updateVolunteerById(int id, Volunteer volunteer) {
		// TODO Auto-generated method stub
		String sql="update volunteer set "
				+"username=?"
				+",email=?"
				+",password=?"
				+",name=?"
				+",gender=?"
				+",birthday=?"
				+",telephone_number=?"
				+",join_date=?"
				+",photograph=?"
				+",id_card=?"
				+",place=?"
				+",service_times=?"
				+",rating=?"
				+",self_introduction=? "
				+"where id=?";
		int n=dbHelper.execOthers(sql,
				volunteer.getUsername(),
				volunteer.getEmail(),
				volunteer.getPassword(),
				volunteer.getName(),
				volunteer.getGender(),
				volunteer.getBirthday(),
				volunteer.getTelephoneNumber(),
				volunteer.getJoinDate(),
				volunteer.getPhotograph(),
				volunteer.getIdCard(),
				volunteer.getPlace(),
				volunteer.getServiceTimes(),
				volunteer.getRating(),
				volunteer.getSelfIntroduction(),
				id
				);
		dbHelper.closeAll();
		if(n>0)
		return true;
		else return false;
	}


	@Override
	public Volunteer findVolunteerByValue(String type, String value) {
		// TODO Auto-generated method stub
		DBHelper dbHelper = new DBHelper();
		String sql = "select * from volunteer where "+type+"=?";
		ResultSet rst = dbHelper.execQuery(sql,value);
		try {
			if (rst.next()) {
				Volunteer volunteer = new Volunteer();
				volunteer.setId(rst.getInt("id"));
				volunteer.setBirthday(rst.getDate("birthday"));
				volunteer.setGender(rst.getString("gender"));
				volunteer.setEmail(rst.getString("email"));
				volunteer.setUsername(rst.getString("username"));
				volunteer.setPassword(rst.getString("password"));
				volunteer.setName(rst.getString("name"));
				volunteer.setJoinDate(rst.getDate("join_date"));
				volunteer.setTelephoneNumber(rst.getString("telephone_number"));
				volunteer.setPhotograph(rst.getString("photograph"));
				volunteer.setServiceTimes(rst.getInt("service_times"));
				volunteer.setPlace(rst.getString("place"));
				volunteer.setIdCard(rst.getString("id_card"));
				volunteer.setRating(rst.getFloat("rating"));
				volunteer.setSelfIntroduction(rst
						.getString("self_introduction"));
				rst.close();
				return volunteer;
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
	public Volunteer findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from volunteer where id="+id;
		ResultSet rst = dbHelper.execQuery(sql);

		try {
			Volunteer volunteer=null;
			if(rst.next()) {
				//
				volunteer = new Volunteer();
				volunteer.setId(rst.getInt("id"));
				volunteer.setBirthday(rst.getDate("birthday"));
				volunteer.setGender(rst.getString("gender"));
				volunteer.setEmail(rst.getString("email"));
				volunteer.setUsername(rst.getString("username"));
				volunteer.setPassword(rst.getString("password"));
				volunteer.setName(rst.getString("name"));
				volunteer.setJoinDate(rst.getDate("join_date"));
				volunteer.setTelephoneNumber(rst.getString("telephone_number"));
				volunteer.setPhotograph(rst.getString("photograph"));
				volunteer.setServiceTimes(rst.getInt("service_times"));
				volunteer.setPlace(rst.getString("place"));
				volunteer.setIdCard(rst.getString("id_card"));
				volunteer.setRating(rst.getFloat("rating"));
				volunteer.setSelfIntroduction(rst
						.getString("self_introduction"));
				
			}
			rst.close();
			return volunteer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}
	
	public Volunteer findByEmail(String email) {
		// TODO Auto-generated method stub
		return findVolunteerByValue("email",email);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByUsername(java.lang.Object)
	 */

	@Override
	public Volunteer findByUsername(String username) {
		// TODO Auto-generated method stub
		return findVolunteerByValue("username",username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByGender(java.lang.Object)
	 */
	@Override
	public List findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByIdCard(java.lang.Object)
	 */

	@Override
	public List findByIdCard(String idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByCity(java.lang.Object)
	 */
	@Override
	public List findByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByServiceTimes(java.lang.Object)
	 */

	@Override
	public List findByServiceTimes(Object serviceTimes) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findByRating(java.lang.Object)
	 */

	@Override
	public List findByRating(Object rating) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.impl.VolunteerDao#findAll()
	 */

	@Override
	public List findAll() {
		String sql = "select* from volunteer";
		ResultSet rst = dbHelper.execQuery(sql);

		try {
			List<Volunteer> volunteers = new ArrayList<Volunteer>();
			while (rst.next()) {
				//
				Volunteer volunteer = new Volunteer();
				volunteer.setId(rst.getInt("id"));
				volunteer.setBirthday(rst.getDate("birthday"));
				volunteer.setGender(rst.getString("gender"));
				volunteer.setEmail(rst.getString("email"));
				volunteer.setUsername(rst.getString("username"));
				volunteer.setPassword(rst.getString("password"));
				volunteer.setName(rst.getString("name"));
				volunteer.setJoinDate(rst.getDate("join_date"));
				volunteer.setTelephoneNumber(rst.getString("telephone_number"));
				volunteer.setPhotograph(rst.getString("photograph"));
				volunteer.setServiceTimes(rst.getInt("service_times"));
				volunteer.setPlace(rst.getString("place"));
				volunteer.setIdCard(rst.getString("id_card"));
				volunteer.setRating(rst.getFloat("rating"));
				volunteer.setSelfIntroduction(rst
						.getString("self_introduction"));
				// ��ӽ��
				volunteers.add(volunteer);
			}
			rst.close();
			return volunteers;
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
	 * @see dao.impl.VolunteerDao#findByCityScenicGenderTime(java.lang.String,
	 * java.lang.String, java.lang.String, java.sql.Date)
	 */
	@Override
	public List findByCityScenicGenderTime(String city, String scenic,
			String gender, String joinDate) {
		// TODO Auto-generated method stub
		//这里scenic不要用到
		/*String sql ="select *"
                  + "from volunteer AS V"
                  + "WHERE V.gender=? AND V.place=? AND "
                  + " V.id IN"
                  +"("
                  +  "select B.id"
                  + " from volunteer AS B,free_time AS S "
                  + " WHERE B.id=S.v_id AND S.free_date=?"
                  +")" ;
            */
		String sql = "select *"
				+ "from volunteer as V "
				+ "WHERE V.gender=? AND V.place=? AND "
				+ "V.id IN"
				+ "("
				+ "select B.id "
				+ "from volunteer AS B,free_time AS S "
				+ " WHERE B.id=S.v_id AND S.free_date=?"
				+ ")";
		//查询的结果集
		ResultSet rst = dbHelper.execQuery(sql,gender,city,joinDate);
		//ResultSet rst = dbHelper.execQuery(sql);
		try {
			List<Volunteer> volunteers = new ArrayList<Volunteer>();
			while (rst.next()) {
				
				Volunteer volunteer = new Volunteer();
				volunteer.setId(rst.getInt("id"));
				volunteer.setBirthday(rst.getDate("birthday"));
				volunteer.setGender(rst.getString("gender"));
				volunteer.setEmail(rst.getString("email"));
				volunteer.setUsername(rst.getString("username"));
				volunteer.setPassword(rst.getString("password"));
				volunteer.setName(rst.getString("name"));
				volunteer.setJoinDate(rst.getDate("join_date"));
				volunteer.setTelephoneNumber(rst.getString("telephone_number"));
				volunteer.setPhotograph(rst.getString("photograph"));
				volunteer.setServiceTimes(rst.getInt("service_times"));
				volunteer.setPlace(rst.getString("place"));
				volunteer.setIdCard(rst.getString("id_card"));
				volunteer.setRating(rst.getFloat("rating"));
				volunteer.setSelfIntroduction(rst
						.getString("self_introduction"));

				volunteers.add(volunteer);
			}
			rst.close();
			return volunteers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbHelper.closeAll();
		}
		return null;
	}

	@Override
	public Volunteer findByVolByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		String sql = "select * from volunteer where username=? and password=?";

		ResultSet rst = dbHelper.execQuery(sql, username, password);
		try {

			if (rst.next()) {
				Volunteer volunteer = new Volunteer();
				volunteer.setId(rst.getInt("id"));
				volunteer.setBirthday(rst.getDate("birthday"));
				volunteer.setGender(rst.getString("gender"));
				volunteer.setEmail(rst.getString("email"));
				volunteer.setUsername(rst.getString("username"));
				volunteer.setPassword(rst.getString("password"));
				volunteer.setName(rst.getString("name"));
				volunteer.setJoinDate(rst.getDate("join_date"));
				volunteer.setTelephoneNumber(rst.getString("telephone_number"));
				volunteer.setPhotograph(rst.getString("photograph"));
				volunteer.setServiceTimes(rst.getInt("service_times"));
				volunteer.setPlace(rst.getString("place"));
				volunteer.setIdCard(rst.getString("id_card"));
				volunteer.setRating(rst.getFloat("rating"));
				volunteer.setSelfIntroduction(rst
						.getString("self_introduction"));

				rst.close();
				return volunteer;
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
	public List<Volunteer> findVolunteerByPage(int pagesize, int currpage) {
		// TODO Auto-generated method stub
		// 澹版槑SQL璇彞
					String sql = "select * from volunteer limit ?,?";
					// 鎵цSQL璇彞
					ResultSet rst = dbHelper.execQuery(sql,pagesize*(currpage-1),pagesize);
					// 鎶婄粨鏋滈泦锛圧esultSet锛夎浆涓篖ist
					try {
						List<Volunteer> volunteers = new ArrayList<Volunteer>();
						while (rst.next()) {
							//一条条转化(还剩下一些关于参照完整性的问题)
							Volunteer volunteer = new Volunteer();
							volunteer.setId(rst.getInt("id"));
							volunteer.setBirthday(rst.getDate("birthday"));
							volunteer.setGender(rst.getString("gender"));
							volunteer.setEmail(rst.getString("email"));
							volunteer.setUsername(rst.getString("username"));
							volunteer.setPassword(rst.getString("password"));
							volunteer.setName(rst.getString("name"));
							volunteer.setJoinDate(rst.getDate("join_date"));
							volunteer.setTelephoneNumber(rst.getString("telephone_number"));
							volunteer.setPhotograph(rst.getString("photograph"));
							volunteer.setServiceTimes(rst.getInt("service_times"));
							volunteer.setPlace(rst.getString("place"));
							volunteer.setIdCard(rst.getString("id_card"));
							volunteer.setRating(rst.getFloat("rating"));
							volunteer.setSelfIntroduction(rst.getString("self_introduction"));
							// 添加结果集
							volunteers.add(volunteer);
							
						}
						rst.close();
						return volunteers;
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						dbHelper.closeAll();
					}
		return null;
	}

	@Override
	public int getVolunteerCount() {
		// TODO Auto-generated method stub
		DBHelper dbHelper2 = new DBHelper();
		String sql = "select count(*) from volunteer";
		ResultSet rst = dbHelper2.execQuery(sql);
		try {
			if(rst.next()){
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
