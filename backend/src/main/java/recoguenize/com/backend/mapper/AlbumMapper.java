package recoguenize.com.backend.mapper;

import org.mapstruct.Mapper;

import recoguenize.com.backend.Entities.AlbumEntity;
import recoguenize.com.backend.dto.AlbumDTO;
import recoguenize.com.backend.mapper.common.RecoguenizeMapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends RecoguenizeMapper<AlbumDTO, AlbumEntity>{

}
