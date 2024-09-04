package recoguenize.com.backend.Services;

import recoguenize.com.backend.Services.common.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recoguenize.com.backend.Entities.AlbumEntity;
import recoguenize.com.backend.dto.AlbumDTO;
import recoguenize.com.backend.Repositories.AlbumRepository;

@Service
@Transactional
public class AlbumService extends ReadService<AlbumDTO, AlbumEntity>{

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumEntity addAlbum(AlbumEntity album) {
        return albumRepository.save(album);
    }
}
