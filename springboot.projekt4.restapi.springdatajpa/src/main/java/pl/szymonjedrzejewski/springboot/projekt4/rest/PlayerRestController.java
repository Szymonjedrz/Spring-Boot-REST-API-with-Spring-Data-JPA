package pl.szymonjedrzejewski.springboot.projekt4.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonjedrzejewski.springboot.projekt4.entity.Player;
import pl.szymonjedrzejewski.springboot.projekt4.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerRestController {

	private PlayerService playerService;

	@Autowired
	public PlayerRestController(PlayerService thePlayerService) {
		this.playerService = thePlayerService;
	}
	
	@GetMapping("/players")
	public List <Player> findAll() {
		
		return playerService.findAll();
	}
	
	@GetMapping("/players/{playerId}")
	public Player findById (@PathVariable int playerId) {
		
		Player thePlayer = playerService.findById(playerId);
		
		if (thePlayer == null) {
			throw new RuntimeException("Player not found with id - " + playerId);
		}
		
		return thePlayer;
	}
	
	@PostMapping("/players")
	public Player savePlayer (@RequestBody Player thePlayer) {
		
		thePlayer.setId(0);
		
		playerService.save(thePlayer);
		
		return thePlayer;
	}
	
	@PutMapping("/players")
	public Player updatePlayer (@RequestBody Player thePlayer) {
		
		playerService.save(thePlayer);
		
		return thePlayer;
	}
	
	@DeleteMapping("/players/{playerId}")
	public String deleteById(@PathVariable int playerId) {
		
		Player thePlayer = playerService.findById(playerId);
		
		if (thePlayer == null) {
			throw new RuntimeException("Player not found with id - " + playerId);
		}
		
		playerService.deleteById(playerId);
		
		return "Player deleted with id - " + playerId;
	}
}
