package pl.szymonjedrzejewski.springboot.projekt4.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonjedrzejewski.springboot.projekt4.dao.PlayerRepository;
import pl.szymonjedrzejewski.springboot.projekt4.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository thePlayerRepository) {
		this.playerRepository = thePlayerRepository;
	}

	@Override
	@Transactional
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	@Transactional
	public Player findById(int theId) {
		
		Optional <Player> result = playerRepository.findById(theId);
		
		Player thePlayer = null;
		
		if (result.isPresent()) {
			thePlayer = result.get();
		} else {
			throw new RuntimeException("Did not find player id - " + theId);
		}
		
		return thePlayer;
	}

	@Override
	@Transactional
	public void save(Player thePlayer) {
		playerRepository.save(thePlayer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		playerRepository.deleteById(theId);
	}

}
