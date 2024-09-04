package recoguenize.com.backend.Services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recoguenize.com.backend.Entities.SongEntity;
import recoguenize.com.backend.Services.common.ReadService;
import recoguenize.com.backend.dto.SongDTO;

@Service
@Transactional
public class SongService extends ReadService<SongDTO, SongEntity>{

    public SongDTO addSong(SongDTO dto) {
        SongEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }
}
