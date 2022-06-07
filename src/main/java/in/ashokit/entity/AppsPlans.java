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
@Table(name="APPS_PLANS")
public class AppsPlans {

	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer categoryId;
	private String active_Status;
	
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



