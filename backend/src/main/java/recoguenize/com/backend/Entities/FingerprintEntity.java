package recoguenize.com.backend.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="fingerprint", schema="song_matcher")
public class FingerprintEntity {

    /**
     * The invariant component.
     */
    private double invariantComponent;

    /**
     * The variant component.
     */
    private double variantComponent;

    /**
     * The song id linked to the fingerprint.
     */
    @ManyToOne
    private SongEntity song;

    /**
     * The localisation.
     */
    private double localisation;

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "fingerprint_sequence"),
                    @Parameter(name = "schema", value = "song_matcher"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int fingerprint_id;
}
