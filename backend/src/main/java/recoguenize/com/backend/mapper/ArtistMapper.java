package recoguenize.com.backend.mapper;

import org.mapstruct.Mapper;

import recoguenize.com.backend.Entities.ArtistEntity;
import recoguenize.com.backend.dto.ArtistDTO;
import recoguenize.com.backend.mapper.common.RecoguenizeMapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper extends RecoguenizeMapper<ArtistDTO, ArtistEntity>{

}
