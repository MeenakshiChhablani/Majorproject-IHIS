package in.ashokit.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CO_TRIGGERS")
public class CoTriggers {

	
	@Id
	@GeneratedValue
	private Integer triggerId;
	private Integer caseNum;
	private String triggerStatus;  //(P - pending, C - Completed) - Default value : P
	private Blob notice;// BLOB



}
