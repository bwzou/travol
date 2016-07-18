package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;





import po.Rating;
import dao.RsDao;
import dbutil.DBHelper;

public class RsDaoImpl implements RsDao {

	@Override
	public boolean doingRate(int id,Rating rating) {
		DBHelper dbHelper = new DBHelper();
		float rate,result=0;
		int rating_time=0;
		int point = rating.getServer()*8+rating.getTravel()*8+rating.getWebsite()*4;
		System.out.println("your rating is :"+point);
        //rating表	
//		String sql="insert into rating(point) values(?)";
//		System.out.println(rating.getServer()+"\t"+rating.getTravel()+"\t"+rating.getWebsite());
//		System.out.println(point);
//		int n=dbHelper.execOthers(sql,point);

        //user表		
		String sql2="select rating,service_times from volunteer where id=?";
		ResultSet rst= dbHelper.execQuery(sql2,id);
		try {
			if(rst.next())
			{
				rate = rst.getFloat(1);
				rating_time = rst.getInt(2);
				result = (rate*rating_time)/(rating_time+1)+point/(rating_time+1);
				System.out.println("rating is : "+rate+"\n"+"times is : "+rating_time+"\n"+"result is : "+result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dbHelper.closeAll();
			System.out.println("查询失败");
			return false;
		}
		String sql3="update volunteer set rating = ?,service_times = ? where id = ?";
		int n = dbHelper.execOthers(sql3,result,rating_time+1,id);
		if(n>0){return true;}
		else{System.out.println("更新失败");return false;}
	}

}
