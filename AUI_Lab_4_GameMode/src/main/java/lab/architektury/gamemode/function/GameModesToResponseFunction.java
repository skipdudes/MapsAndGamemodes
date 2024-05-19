package lab.architektury.gamemode.function;

import lab.architektury.gamemode.dto.GetGameModesResponse;
import lab.architektury.gamemode.entity.GameMode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class GameModesToResponseFunction implements Function<List<GameMode>, GetGameModesResponse>
{
    @Override
    public GetGameModesResponse apply(List<GameMode> entities)
    {
        return GetGameModesResponse.builder()
                .gameModes(entities.stream()
                        .map(gameMode -> GetGameModesResponse.GameMode.builder()
                                .id(gameMode.getId())
                                .name(gameMode.getName())
                                .build())
                        .toList())
                .build();
    }
}
