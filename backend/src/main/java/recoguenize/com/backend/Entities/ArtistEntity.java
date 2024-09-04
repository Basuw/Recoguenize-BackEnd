package recoguenize.com.backend.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;

@Entity
@Data
@Table(name="artist", schema="song_matcher")
public class ArtistEntity
{
    /**
     * Artist id
     */
    @Id
    @GeneratedValue(generator = "sequence-generator-artist")
    @GenericGenerator(
            name = "sequence-generator-artist",
            parameters = {
                    @Parameter(name = "sequence_name", value = "artist_sequence"),
                    @Parameter(name = "schema", value = "song_matcher"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;

    /**
     * Artist's name
     */
    private String name;

    /**
     * Artist's description
     */
    private String description;

    /**
     * Artist's certifications
     */
    private String certification;

    @ManyToMany(mappedBy = "artistsSong", fetch = FetchType.LAZY)
    private List<SongEntity> songs;

    @ManyToMany(mappedBy = "artistsAlbum", fetch = FetchType.LAZY)
    private List<AlbumEntity> albums;
}
