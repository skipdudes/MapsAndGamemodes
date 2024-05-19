package lab.architektury.map.function;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.map.dto.PutMapRequest;
import lab.architektury.map.entity.Map;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMapFunction implements BiFunction<UUID, PutMapRequest, Map>
{
    @Override
    public Map apply(UUID id, PutMapRequest request)
    {
        return Map.builder()
                .id(id)
                .name(request.getName())
                .healthKits(request.getHealthKits())
                .gameMode(GameMode.builder()
                        .id(request.getGameMode())
                        .build())
                .build();
    }
}
