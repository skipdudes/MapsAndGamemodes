package lab.architektury.map.service.api;

import lab.architektury.map.entity.Map;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MapService
{
    Optional<Map> find(UUID id);
    List<Map> findAll();
    void create(Map map);
    void update(Map map);
    void delete(UUID id);
    Optional<List<Map>> findAllByGameMode(UUID gameModeId);
}
