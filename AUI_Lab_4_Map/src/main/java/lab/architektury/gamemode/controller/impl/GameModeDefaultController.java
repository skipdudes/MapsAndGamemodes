package lab.architektury.gamemode.controller.impl;

import lab.architektury.gamemode.controller.api.GameModeController;
import lab.architektury.gamemode.service.api.GameModeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class GameModeDefaultController implements GameModeController
{
    private final GameModeService service;

    @Autowired
    public GameModeDefaultController(GameModeService service)
    {
        this.service = service;
    }

    @Override
    public void deleteGameMode(UUID id)
    {
        service.find(id)
                .ifPresentOrElse(
                        gameMode -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
