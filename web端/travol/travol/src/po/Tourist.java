package po;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * id	username	email	password	name	gender	birthday
 * 	telephone_number	join_date	photograph
 */

public class Tourist implements java.io.Serializable {

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
	
	//参照完整性（这个可能会出错）
	private Set requestServices = new HashSet(0);
	private Set communications = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tourist() {
	}

	/** full constructor */
	public Tourist(String username, String password, String name,
			String gender, Integer age, String telephoneNumber,
			 Date birthday,String photograph, Set requestServices,
			Set communications) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.telephoneNumber = telephoneNumber;
		this.joinDate = joinDate;
		this.photograph = photograph;
		this.requestServices = requestServices;
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

	public Set getRequestServices() {
		return this.requestServices;
	}

	public void setRequestServices(Set requestServices) {
		this.requestServices = requestServices;
	}

	public Set getCommunications() {
		return this.communications;
	}

	public void setCommunications(Set communications) {
		this.communications = communications;
	}

}