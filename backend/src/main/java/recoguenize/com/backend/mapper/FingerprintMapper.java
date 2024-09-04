package recoguenize.com.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import recoguenize.com.backend.Entities.FingerprintEntity;
import recoguenize.com.backend.dto.FingerprintDTO;
import recoguenize.com.backend.mapper.common.SongIDMapper;

@Mapper(componentModel = "spring", uses = {SongIDMapper.class})
public abstract class FingerprintMapper {

    /**
     * Map a fingerprint dto to an entity.
     * 
     * @param dto
     *          The dto.
     * @return
     *          The entity.
     */
    @Mapping(target = "song", source = "songID")
    @Mapping(target = "fingerprint_id", ignore = true)
    public abstract FingerprintEntity toEntity(FingerprintDTO dto);

    /**
     * Map a fingerprint entity to a dto.
     * 
     * @param entity
     *          The entity.
     * @return
     *          The dto.
     */
    @Mapping(source = "song.id", target = "songID")
    public abstract FingerprintDTO toDto(FingerprintEntity entity);
}
