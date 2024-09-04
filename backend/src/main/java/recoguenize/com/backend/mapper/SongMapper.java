package recoguenize.com.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import recoguenize.com.backend.Entities.SongEntity;
import recoguenize.com.backend.dto.SongDTO;
import recoguenize.com.backend.mapper.common.DurationMapper;
import recoguenize.com.backend.mapper.common.RecoguenizeMapper;

@Mapper(componentModel = "spring", uses = { ArtistMapper.class, AlbumMapper.class, DurationMapper.class })
public interface SongMapper extends RecoguenizeMapper<SongDTO, SongEntity>{

    @Override
    @Mapping(target = "artists", source = "artistsSong")
    @Mapping(target = "albums", source = "albumsSong")
    public SongDTO toDto(SongEntity entity);

    @Override
    @Mapping(target = "artistsSong", source = "artists")
    @Mapping(target = "albumsSong", source = "albums")
    public SongEntity toEntity(SongDTO dto);
}
