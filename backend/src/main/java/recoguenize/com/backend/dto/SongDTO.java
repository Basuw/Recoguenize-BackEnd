package recoguenize.com.backend.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class SongDTO {

    @Schema(description = "The song's id.")
    private int id;

    @Schema(description = "The song's title.")
    private String title;

    @Schema(description = "The song's duration.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm:ss")
    private String duration;

    @Schema(description = "The song's type.")
    private String type;

    @Schema(description = "The song's description.")
    private String description;

    @Schema(description = "The song's certification.")
    private String certification;

    @Schema(description = "Artists who sing in the song.")
    private List<ArtistDTO> artists;

    @Schema(description = "Albums in which music is present.")
    private List<AlbumDTO> albums;
}
