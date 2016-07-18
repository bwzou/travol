package biz;

import java.util.Date;
import java.util.List;

import po.FreeTime;

public interface FreeTimeBiz {
	List<FreeTime> findAllByVid(int vid);

	boolean addFreeTime(int vid, Date date);

	String addFreeTimeList(int vid,String timeList);

	boolean deleteFreeTimeById(int id);

	boolean deleteAllByVId(int vid);
}
