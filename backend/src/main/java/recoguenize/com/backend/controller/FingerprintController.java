package recoguenize.com.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import recoguenize.com.backend.Services.FingerprintService;
import recoguenize.com.backend.dto.FingerprintDTO;
import recoguenize.com.backend.dto.ComparaisonDTO.PairOfFingerprintDTO;

@RestController
@RequestMapping(value="fingerprint/")
public class FingerprintController {

    @Autowired
    private FingerprintService service;

    /**
     * Add a new fingerprint to the database.
     * 
     * @param dto
     *          The dto to add in the database.
     * @return
     *          A 201 http status code with the new fingerprint created.
     */
    @PostMapping("")
    @Operation(description = "Add a list of fingerprints to the database.")
    public ResponseEntity<String> addFingerprints(@RequestBody() @Parameter(description = "The dto to add in the database.") List<FingerprintDTO> dtos){
        dtos.stream()
            .forEach(dto -> service.addFingerprint(dto));
        return new ResponseEntity<String>("List has been successfully added.", HttpStatus.CREATED);
    }

    /**
     * Compare a list of fingerprints with that in the database.
     * 
     * @param dtos
     *          The list of dtos.
     * @return
     *          A 200 http status code with the map of matching fingerprints.
     */
    @PostMapping("compare/")
    @Operation(description = "Compare the list of provided fingerprints with those in the database.")
    public ResponseEntity<Map<Integer, List<PairOfFingerprintDTO>>> compareFingerprints(@RequestBody() @Parameter(description = "The list of dtos to compare.") List<FingerprintDTO> dtos){
        return ResponseEntity.ok(service.compareFingerprints(dtos));
    }
}
