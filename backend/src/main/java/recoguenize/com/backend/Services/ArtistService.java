package recoguenize.com.backend.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recoguenize.com.backend.Entities.ArtistEntity;
import recoguenize.com.backend.Services.common.ReadService;
import recoguenize.com.backend.dto.ArtistDTO;

@Service
@Transactional
public class ArtistService extends ReadService<ArtistDTO, ArtistEntity>{

    public void addArtist(ArtistEntity artist) {
        repository.save(artist);
    }
}
