package lab.architektury.map.repository.api;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.map.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MapRepository extends JpaRepository<Map, UUID>
{
    List<Map> findAllByGameMode(GameMode gameMode);
}
