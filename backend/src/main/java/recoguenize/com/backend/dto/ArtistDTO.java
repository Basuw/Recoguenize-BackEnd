package recoguenize.com.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArtistDTO {

    @Schema(description = "The artist's id.")
    private int id;

    @Schema(description = "The artist's name.")
    private String name;

    @Schema(description = "The artist's description.")
    private String description;

    @Schema(description = "The artist's certification.")
    private String certification;
}
