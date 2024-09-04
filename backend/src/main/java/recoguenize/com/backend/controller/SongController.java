package recoguenize.com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import recoguenize.com.backend.Entities.SongEntity;
import recoguenize.com.backend.Services.SongService;
import recoguenize.com.backend.dto.SongDTO;
import recoguenize.com.backend.mapper.SongMapper;

import java.util.List;

@RestController
@RequestMapping(value="song")
public class SongController {

	@Autowired
	public SongService songService;

	@Autowired
	private SongMapper mapper;

	@PostMapping("/")
	@Operation(description = "Add a song to database.")
	public SongDTO addSong(@RequestBody() SongDTO song) {
		return songService.addSong(song);
	}

	@GetMapping("{id}")
	@Operation(description = "Get a song based on its id.")
	public ResponseEntity<SongDTO> getSongInfo(@Parameter(description="Id de la musique") @PathVariable int id) {
		SongEntity entity = songService.getById(id);
		return ResponseEntity.ok(mapper.toDto(entity));
	}

	@GetMapping("/")
	@Operation(description = "Retrieve all songs in database.")
	public ResponseEntity<List<SongEntity>> getAllSongInfo() {
		return ResponseEntity.ok(songService.getAll());
	}
}
