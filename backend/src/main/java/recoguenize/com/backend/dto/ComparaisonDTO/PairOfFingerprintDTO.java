package recoguenize.com.backend.dto.ComparaisonDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import recoguenize.com.backend.dto.FingerprintDTO;

@Data
@AllArgsConstructor
public class PairOfFingerprintDTO {

    /**
     * The fingerprint to compare.
     */
    @Schema(description = "The fingerprint to compare.")
    private FingerprintDTO songFingerprint;

    /**
     * The matching fingerprint.
     */
    @Schema(description = "The matching fingerprint.")
    private FingerprintDTO databaseFingerprint;
}
