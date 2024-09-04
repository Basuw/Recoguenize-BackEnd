package recoguenize.com.backend.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="song", schema="song_matcher")
public class SongEntity {

    /**
     * Song id
     */
    @Id
    @GeneratedValue(generator = "sequence-generator-song")
    @GenericGenerator(
            name = "sequence-generator-song",
            parameters = {
                    @Parameter(name = "sequence_name", value = "song_sequence"),
                    @Parameter(name = "schema", value = "song_matcher"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;

    /**
     * Song's title
     */
    private String title;

    /**
     * Song's duration
     */
    private Time duration;

    /**
     * Song's type
     */
    private String type;

    /**
     * Song's description
     */
    private String description;

    /**
     * Song's certifications
     */
    private String certification;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(
            name = "realise_song",
            schema = "song_matcher",
            joinColumns = {  @JoinColumn(name = "song_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "artist_id", referencedColumnName = "id") }
    )
    private List<ArtistEntity> artistsSong = new ArrayList<ArtistEntity>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(
            name = "include_song",
            schema = "song_matcher",
            joinColumns = {  @JoinColumn(name = "song_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "album_id", referencedColumnName = "id") }
    )
    private List<AlbumEntity> albumsSong = new ArrayList<AlbumEntity>();

}
