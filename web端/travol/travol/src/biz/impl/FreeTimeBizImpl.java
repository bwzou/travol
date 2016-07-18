package biz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.FreeTime;
import dao.FreeTimeDao;
import dao.impl.FreeTimeDaoImpl;
import biz.FreeTimeBiz;

public class FreeTimeBizImpl implements FreeTimeBiz {
	private FreeTimeDao freeTimeDao = new FreeTimeDaoImpl();

	@Override
	public boolean addFreeTime(int vid, Date date) {
		// TODO Auto-generated method stub
		if (freeTimeDao.findFreeTimeByVidDate(vid, date) != null) {
			return false;
		}
		return freeTimeDao.addFreeTime(vid, date);
	}

	@Override
	public String addFreeTimeList(int vid, String timeList) {
		// TODO Auto-generated method stub
		List<Date> datelist = new ArrayList<Date>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] slist = timeList.split(",");
		for (String s : slist) {
			try {
				datelist.add(sdf.parse(s));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Date d : datelist) {
			this.addFreeTime(vid, d);
		}
		return null;
	}

	@Override
	public boolean deleteFreeTimeById(int id) {
		// TODO Auto-generated method stub
		return freeTimeDao.deleteFreeTimeById(id);
	}

	@Override
	public boolean deleteAllByVId(int vid) {
		// TODO Auto-generated method stub
		return freeTimeDao.deleteFreeTimeByVId(vid);
	}

	@Override
	public List<FreeTime> findAllByVid(int vid) {
		// TODO Auto-generated method stub
		return freeTimeDao.findFreeTimeByVid(vid);
	}

}
