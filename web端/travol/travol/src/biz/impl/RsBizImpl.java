package biz.impl;

import biz.RsBiz;
import dao.RsDao;
import dao.impl.RsDaoImpl;
import po.Rating;

public class RsBizImpl implements RsBiz {

	private RsDao rsdao=new RsDaoImpl();
	@Override
	public boolean doRating(int id,Rating rating) {
		// TODO Auto-generated method stub
//		System.out.println(rating.getServer()+"\t"+rating.getTravel()+"\t"+rating.getWebsite());
		return rsdao.doingRate(id,rating);
	}

}
