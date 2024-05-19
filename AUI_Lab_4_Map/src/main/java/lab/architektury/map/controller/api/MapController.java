package lab.architektury.map.controller.api;

import lab.architektury.map.dto.GetMapResponse;
import lab.architektury.map.dto.GetMapsResponse;
import lab.architektury.map.dto.PutMapRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface MapController
{
    @GetMapping("api/maps")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMapsResponse getMaps();

    @GetMapping("/api/gamemodes/{gamemodeId}/maps")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMapsResponse getGameModeMaps(
            @PathVariable("gamemodeId")
            UUID gameModeId
    );

    @GetMapping("/api/maps/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMapResponse getMap(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/maps/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMap(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutMapRequest request
    );

    @DeleteMapping("/api/maps/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMap(
            @PathVariable("id")
            UUID id
    );
}
