package recoguenize.com.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recoguenize.com.backend.Entities.ArtistEntity;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
}
