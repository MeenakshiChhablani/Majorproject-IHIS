package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZENS_APPS")
public class Citizens_AppAcc {

	@Id
	@GeneratedValue
	private Integer caseNum;  //citizen_acc_id
	private String fullName ;
	private String emailId;
	private Long mobileNum;
	private String gender;
	private Integer ssn_Num;
	private String active_switch;
	private LocalDate dob;
	private String stateName;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE")
	private LocalDate updatedDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	
	
}
