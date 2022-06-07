package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.AppsPlans;

@Repository
public interface AppsPlansRepo  extends JpaRepository<AppsPlans  , Serializable> {



 

}
