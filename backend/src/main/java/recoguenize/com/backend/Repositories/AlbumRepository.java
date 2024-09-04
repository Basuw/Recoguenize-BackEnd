package recoguenize.com.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recoguenize.com.backend.Entities.AlbumEntity;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
}
