package recoguenize.com.backend.Services.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;
import recoguenize.com.backend.mapper.common.RecoguenizeMapper;

public abstract class ReadService<D, E> {

    @Autowired
    protected JpaRepository<E, Integer> repository;

    @Autowired
    protected RecoguenizeMapper<D, E> mapper;

    public E getById(int id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No song found with id "+ id));
    }

    public List<E> getAll(){
        return repository.findAll();
    }
}
