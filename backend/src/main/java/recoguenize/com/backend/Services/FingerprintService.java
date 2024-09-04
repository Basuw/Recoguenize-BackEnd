package recoguenize.com.backend.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import recoguenize.com.backend.Entities.FingerprintEntity;
import recoguenize.com.backend.Repositories.FingerprintRepository;
import recoguenize.com.backend.dto.FingerprintDTO;
import recoguenize.com.backend.dto.ComparaisonDTO.PairOfFingerprintDTO;
import recoguenize.com.backend.mapper.FingerprintMapper;

@Service
@Transactional
public class FingerprintService {

    @Autowired
    private FingerprintMapper mapper;

    @Autowired
    private FingerprintRepository repository;

    @Autowired
    private ComparaisonService comparaisonService;

    /**
     * Add a fingerprint to the database.
     * 
     * @param dto
     *      The fingerprint dto.
     * @return
     *      The fingerprintDTO saved in the database.
     */
    public FingerprintDTO addFingerprint(FingerprintDTO dto){
        FingerprintEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    /**
     * Compare the provided list of fingerprints with those on database.
     * 
     * @param dtos
     *          The list of fingerprints to compare.
     * @return
     *          The list of matching fingerprint.
     */
    public Map<Integer, List<PairOfFingerprintDTO>> compareFingerprints(List<FingerprintDTO> dtos){
        return comparaisonService.getMatchingFingerprints(dtos);
    }
}
