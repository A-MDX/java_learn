package madx.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Table(name="java_file_path")
public class JavaFilePathPO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="path")
	private String path;

	@Column(name="now_line")
	private Integer nowLine;

	@Column(name="now_num")
	private Integer nowNum;

	@Column(name="is_big_path")
	private Integer isBigPath;

	@Column(name="creation_time")
	private Date creationTime;

	@Column(name="creator")
	private Integer creator;

	@Column(name="modify_time")
	private Date modifyTime;

	@Column(name="modifier")
	private Integer modifier;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "is_active")
	private Integer isActive;

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return this.path;
	}

	public void setNowLine(Integer nowLine){
		this.nowLine = nowLine;
	}

	public Integer getNowLine(){
		return this.nowLine;
	}

	public void setNowNum(Integer nowNum){
		this.nowNum = nowNum;
	}

	public Integer getNowNum(){
		return this.nowNum;
	}

	public void setIsBigPath(Integer isBigPath){
		this.isBigPath = isBigPath;
	}

	public Integer getIsBigPath(){
		return this.isBigPath;
	}

	public void setCreationTime(Date creationTime){
		this.creationTime = creationTime;
	}

	public Date getCreationTime(){
		return this.creationTime;
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

} 

