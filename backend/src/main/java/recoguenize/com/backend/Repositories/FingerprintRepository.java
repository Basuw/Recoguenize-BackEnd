package recoguenize.com.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import recoguenize.com.backend.Entities.FingerprintEntity;

import java.util.List;


@Repository
public interface FingerprintRepository extends CrudRepository<FingerprintEntity, Integer>{

    List<FingerprintEntity> findByInvariantComponent(double invariantComponent);
}
