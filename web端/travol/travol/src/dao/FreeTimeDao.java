package dao;

import java.util.Date;
import java.util.List;

import po.FreeTime;

public interface FreeTimeDao {
	List<FreeTime> findFreeTimeByVid(int vid);

	List<FreeTime> findFreeTimeByDate(Date date);
	
	List<FreeTime> findFreeTimeByValue(String type, Object value);

	FreeTime findFreeTimeByVidDate(int vid, Date date);

	boolean addFreeTime(int vid, Date date);

	boolean deleteFreeTimeByVId(int vid);

	boolean deleteFreeTimeById(int id);
}
