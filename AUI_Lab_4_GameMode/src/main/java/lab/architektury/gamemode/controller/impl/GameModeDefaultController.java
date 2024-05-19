package lab.architektury.gamemode.controller.impl;

import lab.architektury.gamemode.controller.api.GameModeController;
import lab.architektury.gamemode.dto.GetGameModeResponse;
import lab.architektury.gamemode.dto.GetGameModesResponse;
import lab.architektury.gamemode.dto.PutGameModeRequest;
import lab.architektury.gamemode.function.GameModeToResponseFunction;
import lab.architektury.gamemode.function.GameModesToResponseFunction;
import lab.architektury.gamemode.function.RequestToGameModeFunction;
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
    private final GameModeToResponseFunction gameModeToResponse;
    private final GameModesToResponseFunction gameModesToResponse;
    private final RequestToGameModeFunction requestToGameMode;

    @Autowired
    public GameModeDefaultController(
            GameModeService service,
            GameModeToResponseFunction gameModeToResponse,
            GameModesToResponseFunction gameModesToResponse,
            RequestToGameModeFunction requestToGameMode
    ) {
        this.service = service;
        this.gameModeToResponse = gameModeToResponse;
        this.gameModesToResponse = gameModesToResponse;
        this.requestToGameMode = requestToGameMode;
    }

    @Override
    public GetGameModesResponse getGameModes()
    {
        return gameModesToResponse.apply(service.findAll());
    }

    @Override
    public GetGameModeResponse getGameMode(UUID id)
    {
        return service.find(id)
                .map(gameModeToResponse)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putGameMode(UUID id, PutGameModeRequest request)
    {
        service.create(requestToGameMode.apply(id, request));
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
