package madx.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Table(name="line_day_old")
public class LineDayOldPO implements Serializable{ 

private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="java_file_num")
	private Integer javaFileNum;

	@Column(name="java_line")
	private Integer javaLine;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="increase_file")
	private Integer increaseFile;

	@Column(name="increase_line")
	private Integer increaseLine;

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

	public void setJavaFileNum(Integer javaFileNum){
    	this.javaFileNum = javaFileNum;
 	}

	public Integer getJavaFileNum(){
    	return this.javaFileNum;
 	}

	public void setJavaLine(Integer javaLine){
    	this.javaLine = javaLine;
 	}

	public Integer getJavaLine(){
    	return this.javaLine;
 	}

	public void setCreateTime(Date createTime){
    	this.createTime = createTime;
 	}

	public Date getCreateTime(){
    	return this.createTime;
 	}

	public void setIncreaseFile(Integer increaseFile){
    	this.increaseFile = increaseFile;
 	}

	public Integer getIncreaseFile(){
    	return this.increaseFile;
 	}

	public void setIncreaseLine(Integer increaseLine){
    	this.increaseLine = increaseLine;
 	}

	public Integer getIncreaseLine(){
    	return this.increaseLine;
 	}

} 

