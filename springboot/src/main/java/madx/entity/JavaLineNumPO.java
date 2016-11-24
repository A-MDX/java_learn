package madx.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Table(name="java_line_num")
public class JavaLineNumPO implements Serializable{ 

private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="file_num")
	private Integer fileNum;

	@Column(name="line_num")
	private Integer lineNum;

	@Column(name="line_than_provious")
	private Integer lineThanProvious;

	@Column(name="num_than_provious")
	private Integer numThanProvious;

	@Column(name="creation_time")
	private Date creationTime;

	@Column(name="creator")
	private Integer creator;

	@Override
	public String toString() {
		return "JavaLineNumPO{" +
				"id=" + id +
				", fileNum=" + fileNum +
				", lineNum=" + lineNum +
				", lineThanProvious=" + lineThanProvious +
				", numThanProvious=" + numThanProvious +
				", creationTime=" + creationTime +
				", creator=" + creator +
				'}';
	}

	public void setId(Long id){
    	this.id = id;
 	}

	public Long getId(){
    	return this.id;
 	}

	public void setFileNum(Integer fileNum){
    	this.fileNum = fileNum;
 	}

	public Integer getFileNum(){
    	return this.fileNum;
 	}

	public void setLineNum(Integer lineNum){
    	this.lineNum = lineNum;
 	}

	public Integer getLineNum(){
    	return this.lineNum;
 	}

	public void setLineThanProvious(Integer lineThanProvious){
    	this.lineThanProvious = lineThanProvious;
 	}

	public Integer getLineThanProvious(){
    	return this.lineThanProvious;
 	}

	public void setNumThanProvious(Integer numThanProvious){
    	this.numThanProvious = numThanProvious;
 	}

	public Integer getNumThanProvious(){
    	return this.numThanProvious;
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

} 

