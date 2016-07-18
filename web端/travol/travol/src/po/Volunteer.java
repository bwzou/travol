package po;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Volunteer entity. @author MyEclipse Persistence Tools
 */

public class Volunteer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String email;
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	private String telephoneNumber;
	private Date joinDate;
	private String photograph;
	private String idCard;
	private String place;
	private Integer serviceTimes;
	private Float rating;
	private String selfIntroduction;

	private Set suitableScenicspots = new HashSet(0);
	private Set freeTimes = new HashSet(0);
	private Set proviceServices = new HashSet(0);
	private Set communications = new HashSet(0);

	// Constructors

	/** default constructor */
	public Volunteer() {
	}

	/** full constructor */
	public Volunteer(Integer id, String username, String email,
			String password, String name, String gender, Date birthday,
			String telephoneNumber, Date joinDate, String photograph,
			String idCard, String place, Integer serviceTimes, Float rating,
			String selfIntroduction, Set suitableScenicspots, Set freeTimes,
			Set proviceServices, Set communications) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.telephoneNumber = telephoneNumber;
		this.joinDate = joinDate;
		this.photograph = photograph;
		this.idCard = idCard;
		this.place = place;
		this.serviceTimes = serviceTimes;
		this.rating = rating;
		this.selfIntroduction = selfIntroduction;
		this.suitableScenicspots = suitableScenicspots;
		this.freeTimes = freeTimes;
		this.proviceServices = proviceServices;
		this.communications = communications;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhotograph() {
		return this.photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getServiceTimes() {
		return this.serviceTimes;
	}

	public void setServiceTimes(Integer serviceTimes) {
		this.serviceTimes = serviceTimes;
	}

	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getSelfIntroduction() {
		return this.selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public Set getSuitableScenicspots() {
		return this.suitableScenicspots;
	}

	public void setSuitableScenicspots(Set suitableScenicspots) {
		this.suitableScenicspots = suitableScenicspots;
	}

	public Set getFreeTimes() {
		return this.freeTimes;
	}

	public void setFreeTimes(Set freeTimes) {
		this.freeTimes = freeTimes;
	}

	public Set getProviceServices() {
		return this.proviceServices;
	}

	public void setProviceServices(Set proviceServices) {
		this.proviceServices = proviceServices;
	}

	public Set getCommunications() {
		return this.communications;
	}

	public void setCommunications(Set communications) {
		this.communications = communications;
	}

}