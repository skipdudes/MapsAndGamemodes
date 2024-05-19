package lab.architektury.gamemode.service.impl;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.gamemode.event.repository.api.GameModeEventRepository;
import lab.architektury.gamemode.repository.api.GameModeRepository;
import lab.architektury.gamemode.service.api.GameModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameModeDefaultService implements GameModeService
{
    private final GameModeRepository repository;
    private final GameModeEventRepository eventRepository;

    @Autowired
    public GameModeDefaultService(GameModeRepository repository, GameModeEventRepository eventRepository)
    {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<GameMode> findAll()
    {
        return repository.findAll();
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
        eventRepository.delete(id);
    }
}
