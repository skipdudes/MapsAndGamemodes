package lab.architektury.gamemode.repository.api;

import lab.architektury.gamemode.entity.GameMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameModeRepository extends JpaRepository<GameMode, UUID>
{

}
