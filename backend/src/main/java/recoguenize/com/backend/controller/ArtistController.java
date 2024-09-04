package recoguenize.com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import recoguenize.com.backend.Entities.ArtistEntity;
import recoguenize.com.backend.Services.ArtistService;
import recoguenize.com.backend.dto.ArtistDTO;
import recoguenize.com.backend.mapper.ArtistMapper;

@RestController
@RequestMapping(value="artist/")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistMapper mapper;

    @PostMapping("/")
    @Operation(description = "Add an artist to database.")
    public void addArtist(@RequestBody ArtistEntity artist) {
        artistService.addArtist(artist);
    }

    @GetMapping("{id}")
    @Operation(description = "Get an artist from the database.")
    public ResponseEntity<ArtistDTO> getArtist(@PathVariable int id) {
        ArtistEntity entity = artistService.getById(id);
        return ResponseEntity.ok(mapper.toDto(entity));
    }
}
