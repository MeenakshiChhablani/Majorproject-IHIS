package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.PlanCategoryMaster;
@Repository
public interface Citizens_AppAccRepo  extends JpaRepository<PlanCategoryMaster ,Serializable >{

}
