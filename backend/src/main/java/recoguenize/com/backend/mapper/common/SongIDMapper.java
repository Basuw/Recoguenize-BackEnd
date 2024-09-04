package recoguenize.com.backend.mapper.common;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;
import recoguenize.com.backend.Entities.SongEntity;
import recoguenize.com.backend.Repositories.SongRepository;

@Mapper(componentModel = "spring")
public abstract class SongIDMapper {

    @Autowired
    private SongRepository repository;

    public SongEntity toEntity(int id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No song found with id "+ id));
    }
}
