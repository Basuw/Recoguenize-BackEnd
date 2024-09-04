package recoguenize.com.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FingerprintDTO {

    /**
     * The invariant component.
     */
    @Schema(description="The invariant component.")
    private double invariantComponent;

    /**
     * The variant component;
     */
    @Schema(description="The variant component.")
    private double variantComponent;

    /**
     * The localisation of the song.
     */
    @Schema(description="The localisation of the fingerprint")
    private double localisation;

    /**
     * The song id.
     */
    @Schema(description="The id of the music related to the song.")
    private Integer songID;
}
