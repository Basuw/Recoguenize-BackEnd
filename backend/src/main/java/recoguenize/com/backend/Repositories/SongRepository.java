package recoguenize.com.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import recoguenize.com.backend.Entities.SongEntity;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Integer> {
    @Query(value = "SELECT nextval('song_matcher.song_sequence')", nativeQuery = true)
    int getCurvaSongSequence();
}
