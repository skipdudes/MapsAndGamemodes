package lab.architektury.gamemode.controller.api;

import lab.architektury.gamemode.dto.GetGameModeResponse;
import lab.architektury.gamemode.dto.GetGameModesResponse;
import lab.architektury.gamemode.dto.PutGameModeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface GameModeController
{
    @GetMapping("api/gamemodes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGameModesResponse getGameModes();

    @GetMapping("/api/gamemodes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGameModeResponse getGameMode(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/gamemodes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putGameMode(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutGameModeRequest request
    );

    @DeleteMapping("/api/gamemodes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGameMode(
            @PathVariable("id")
            UUID id
    );
}
