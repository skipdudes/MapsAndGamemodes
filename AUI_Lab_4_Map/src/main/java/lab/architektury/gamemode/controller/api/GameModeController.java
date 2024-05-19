package lab.architektury.gamemode.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface GameModeController
{
    @DeleteMapping("/api/gamemodes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGameMode(
            @PathVariable("id")
            UUID id
    );
}
