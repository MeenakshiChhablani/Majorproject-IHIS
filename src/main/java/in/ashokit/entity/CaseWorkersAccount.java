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
@Table(name="CW_ACCOUNTS")
public class CaseWorkersAccount {

	@Id
	@GeneratedValue
	private Integer acc_id;
	private String fullName;
	private String emailId;
	private String pwd;
	private Long mobile_num;
	private String activeStatus ;
	private String gender;
	private Integer ssn_Num;
	private LocalDate dob;
	
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

