package recoguenize.com.backend.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="album", schema="song_matcher")
public class AlbumEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator-album")
    @GenericGenerator(
            name = "sequence-generator-album",
            parameters = {
                    @Parameter(name = "sequence_name", value = "album_sequence"),
                    @Parameter(name = "schema", value = "song_matcher"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;

    @Schema(description = "The album title.")
    private String title;

    @Schema(description = "The album description.")
    private String description;

    @Schema(description = "The album icon.")
    private String icon;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(
            name = "realise_album",
            schema = "song_matcher",
            joinColumns = {  @JoinColumn(name = "album_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "artist_id", referencedColumnName = "id") }
    )
    @Schema(description = "Artists presents in the album.")
    private List<ArtistEntity> artistsAlbum;

    @ManyToMany(mappedBy = "albumsSong", fetch = FetchType.LAZY)
    @Schema(description = "Songs available in the album.")
    private List<SongEntity> songs;
}
