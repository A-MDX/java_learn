package madx.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Table(name="user")
public class UserPO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="login_name")
	private String loginName;

	@Column(name="creation_time")
	private Date creationTime;

	@Column(name="phone")
	private String phone;

	@Column(name="email")
	private String email;

	@Column(name="address")
	private String address;

	@Column(name="creator")
	private Integer creator;

	@Column(name="modify_time")
	private Date modifyTime;

	@Column(name="modifier")
	private Integer modifier;

	@Column(name="java_line")
	private Integer javaLine;

	@Column(name="java_file")
	private Integer javaFile;

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	public String getLoginName(){
		return this.loginName;
	}

	public void setCreationTime(Date creationTime){
		this.creationTime = creationTime;
	}

	public Date getCreationTime(){
		return this.creationTime;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return this.address;
	}

	public void setCreator(Integer creator){
		this.creator = creator;
	}

	public Integer getCreator(){
		return this.creator;
	}

	public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime(){
		return this.modifyTime;
	}

	public void setModifier(Integer modifier){
		this.modifier = modifier;
	}

	public Integer getModifier(){
		return this.modifier;
	}

	public void setJavaLine(Integer javaLine){
		this.javaLine = javaLine;
	}

	public Integer getJavaLine(){
		return this.javaLine;
	}

	public void setJavaFile(Integer javaFile){
		this.javaFile = javaFile;
	}

	public Integer getJavaFile(){
		return this.javaFile;
	}

} 

