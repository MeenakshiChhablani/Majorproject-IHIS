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
@Table(name = "EILIGIBILITY_DTLS")
public class EligibilityDtls {

	@Id
	@GeneratedValue
	private Integer elig_Id;
	private Integer caseNum;
	private String planName;
	private String planStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer childSSN;
	private String benefitAmount;
	private String denialReason;

	
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private LocalDate updatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
				



	

	
	
}
