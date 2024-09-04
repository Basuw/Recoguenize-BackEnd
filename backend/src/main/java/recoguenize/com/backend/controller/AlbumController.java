package recoguenize.com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import recoguenize.com.backend.Entities.AlbumEntity;
import recoguenize.com.backend.Services.AlbumService;

@RestController
@RequestMapping(value="album")
public class AlbumController {

    @Autowired
    public AlbumService albumService;

    @PostMapping("/")
    @Operation(description = "Add an album to database.")
    public AlbumEntity addAlbum(@RequestBody AlbumEntity album) {
        return albumService.addAlbum(album);
    }

    @GetMapping("{id}")
    @Operation(description = "Add an album to database.")
    public AlbumEntity addAlbum(@PathVariable int id) {
        return albumService.getById(id);
    }
}
