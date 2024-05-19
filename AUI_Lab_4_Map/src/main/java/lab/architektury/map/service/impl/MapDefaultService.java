package lab.architektury.map.service.impl;

import lab.architektury.gamemode.repository.api.GameModeRepository;
import lab.architektury.map.entity.Map;
import lab.architektury.map.repository.api.MapRepository;
import lab.architektury.map.service.api.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MapDefaultService implements MapService
{
    private final MapRepository repository;
    private final GameModeRepository gameModeRepository;

    @Autowired
    public MapDefaultService(
            MapRepository repository,
            GameModeRepository gameModeRepository
    ) {
        this.repository = repository;
        this.gameModeRepository = gameModeRepository;
    }

    @Override
    public Optional<Map> find(UUID id)
    {
        return repository.findById(id);
    }

    @Override
    public List<Map> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<List<Map>> findAllByGameMode(UUID gameModeId)
    {
        return gameModeRepository.findById(gameModeId)
                .map(repository::findAllByGameMode);
    }

    @Override
    public void create(Map map)
    {
        repository.save(map);
    }

    @Override
    public void update(Map map)
    {
        repository.save(map);
    }

    @Override
    public void delete(UUID id)
    {
        repository.findById(id).ifPresent(repository::delete);
    }
}
