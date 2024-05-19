package lab.architektury.gamemode.service.impl;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.gamemode.repository.api.GameModeRepository;
import lab.architektury.gamemode.service.api.GameModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GameModeDefaultService implements GameModeService
{
    private final GameModeRepository repository;

    @Autowired
    public GameModeDefaultService(GameModeRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Optional<GameMode> find(UUID id)
    {
        return repository.findById(id);
    }

    @Override
    public void create(GameMode gameMode)
    {
        repository.save(gameMode);
    }

    @Override
    public void delete(UUID id)
    {
        repository.findById(id).ifPresent(repository::delete);
    }
}
