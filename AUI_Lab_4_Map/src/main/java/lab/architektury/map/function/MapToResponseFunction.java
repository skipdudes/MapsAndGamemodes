package lab.architektury.map.function;

import lab.architektury.map.dto.GetMapResponse;
import lab.architektury.map.entity.Map;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapToResponseFunction implements Function<Map, GetMapResponse>
{
    @Override
    public GetMapResponse apply(Map entity)
    {
        return GetMapResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .healthKits(entity.getHealthKits())
                .gameMode(GetMapResponse.GameMode.builder()
                        .id(entity.getGameMode().getId())
                        .build())
                .build();
    }
}
