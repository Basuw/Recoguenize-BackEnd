package recoguenize.com.backend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import recoguenize.com.backend.Repositories.FingerprintRepository;
import recoguenize.com.backend.dto.FingerprintDTO;
import recoguenize.com.backend.dto.ComparaisonDTO.PairOfFingerprintDTO;
import recoguenize.com.backend.mapper.FingerprintMapper;

@Service
@Transactional
public class ComparaisonService {

    private static double PERCENTAGE_TOLERANCE = 0.2d;

    @Autowired
    private FingerprintRepository fingerprintRepository;

    @Autowired
    private FingerprintMapper mapper;

    /**
     * Compare a list of fingerprints with that on database.
     * 
     * @param fingerprints
     *          The list of fingerprints to compare.
     * @return
     *          A map of matching fingerprints grouped by songID.
     */
    public Map<Integer, List<PairOfFingerprintDTO>> getMatchingFingerprints(List<FingerprintDTO> fingerprints){
        List<PairOfFingerprintDTO> matchingFingerprints = new ArrayList<PairOfFingerprintDTO>();
        fingerprints.forEach(f -> matchingFingerprints.addAll(getMatchingFingerprints(f)));
        Map<Integer, List<PairOfFingerprintDTO>> sortedMatchingFingerPrint = matchingFingerprints.stream()
                    .collect(Collectors.groupingBy(dto -> dto.getDatabaseFingerprint().getSongID()));
        sortedMatchingFingerPrint.forEach((id, list) -> list
                                                        .forEach(pair -> {pair.getDatabaseFingerprint().setSongID(null);
                                                                            pair.getSongFingerprint().setSongID(null);}));
        return sortedMatchingFingerPrint;
    }

    /**
     * Compare a fingerprint with that in the database.
     * 
     * @param fingerprintDTO
     *          The fingerprintDTO.
     * @return
     *          The list of matching fingerprints.
     */
    private List<PairOfFingerprintDTO> getMatchingFingerprints(FingerprintDTO fingerprintDTO){
        List<PairOfFingerprintDTO> potentialMatching = fingerprintRepository
                                                        .findByInvariantComponent(fingerprintDTO.getInvariantComponent())
                                                        .stream()
                                                        .map(f -> new PairOfFingerprintDTO(fingerprintDTO, mapper.toDto(f)))
                                                        .toList();

        return potentialMatching.stream()
                                .filter(f -> fingerprintDTO.getVariantComponent() < f.getDatabaseFingerprint().getVariantComponent() * (1 + PERCENTAGE_TOLERANCE) && 
                                                        fingerprintDTO.getVariantComponent() > f.getDatabaseFingerprint().getVariantComponent() * (1 - PERCENTAGE_TOLERANCE))
                                .toList();
    }
}
