package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CoTriggers;

@Repository
public interface CoTriggersRepo  extends JpaRepository<CoTriggers  , Serializable> {
 

}
