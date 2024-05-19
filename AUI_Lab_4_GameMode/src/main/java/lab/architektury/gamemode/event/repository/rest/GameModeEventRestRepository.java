package lab.architektury.gamemode.event.repository.rest;

import lab.architektury.gamemode.event.repository.api.GameModeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class GameModeEventRestRepository implements GameModeEventRepository
{
    private final RestTemplate restTemplate;

    @Autowired
    public GameModeEventRestRepository(RestTemplate template)
    {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id)
    {
        restTemplate.delete("/api/gamemodes/{id}", id);
    }
}
