package lab.architektury.gamemode.service.api;

import lab.architektury.gamemode.entity.GameMode;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameModeService
{
    Optional<GameMode> find(UUID id);
    void create(GameMode gameMode);
    List<GameMode> findAll();
    void delete(UUID id);
}
