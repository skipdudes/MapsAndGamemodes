package lab.architektury.map.function;

import lab.architektury.map.dto.GetMapsResponse;
import lab.architektury.map.entity.Map;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MapsToResponseFunction implements Function<List<Map>, GetMapsResponse>
{
    @Override
    public GetMapsResponse apply(List<Map> entities)
    {
        return GetMapsResponse.builder()
                .maps(entities.stream()
                        .map(map -> GetMapsResponse.Map.builder()
                                .id(map.getId())
                                .name(map.getName())
                                .build())
                        .toList())
                .build();
    }
}
