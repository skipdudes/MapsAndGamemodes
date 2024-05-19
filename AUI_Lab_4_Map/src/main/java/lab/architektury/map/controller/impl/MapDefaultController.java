package lab.architektury.map.controller.impl;

import lab.architektury.map.controller.api.MapController;
import lab.architektury.map.dto.GetMapResponse;
import lab.architektury.map.dto.GetMapsResponse;
import lab.architektury.map.dto.PutMapRequest;
import lab.architektury.map.function.MapToResponseFunction;
import lab.architektury.map.function.MapsToResponseFunction;
import lab.architektury.map.function.RequestToMapFunction;
import lab.architektury.map.service.api.MapService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class MapDefaultController implements MapController
{
    private final MapService service;
    private final MapToResponseFunction mapToResponse;
    private final MapsToResponseFunction mapsToResponse;
    private final RequestToMapFunction requestToMap;

    @Autowired
    public MapDefaultController(
            MapService service,
            MapToResponseFunction mapToResponse,
            MapsToResponseFunction mapsToResponse,
            RequestToMapFunction requestToMap
    ) {
        this.service = service;
        this.mapToResponse = mapToResponse;
        this.mapsToResponse = mapsToResponse;
        this.requestToMap = requestToMap;
    }

    @Override
    public GetMapsResponse getMaps()
    {
        return mapsToResponse.apply(service.findAll());
    }

    @Override
    public GetMapsResponse getGameModeMaps(UUID gameModeId)
    {
        return service.findAllByGameMode(gameModeId)
                .map(mapsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMapResponse getMap(UUID id)
    {
        return service.find(id)
                .map(mapToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putMap(UUID id, PutMapRequest request)
    {
        service.create(requestToMap.apply(id, request));
    }

    @Override
    public void deleteMap(UUID id)
    {
        service.find(id)
                .ifPresentOrElse(
                        map -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
