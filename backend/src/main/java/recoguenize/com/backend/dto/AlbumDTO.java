package recoguenize.com.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AlbumDTO {

    @Schema(description = "The album's id.")
    private int id;

    @Schema(description = "The album's title.")
    private String title;

    @Schema(description = "The album's description.")
    private String description;

    @Schema(description = "The album's icon.")
    private String icon;
}
