package po;

import java.util.Date;



public class Service {
    private int id;
    private int t_id;
    private int v_id;
    private int state;      //表示约定的状态
    private Date opp_date;  //表示约定的时间
    private Date date;   //表示约定的状态
    private String evaluation;  
    private float  rating;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getOpp_date() {
		return opp_date;
	}
	public void setOpp_date(Date opp_date) {
		this.opp_date = opp_date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}  
}