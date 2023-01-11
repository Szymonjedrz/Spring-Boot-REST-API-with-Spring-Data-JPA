package pl.szymonjedrzejewski.springboot.projekt4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymonjedrzejewski.springboot.projekt4.entity.Player;

public interface PlayerRepository extends JpaRepository <Player, Integer> {
	
	
}
