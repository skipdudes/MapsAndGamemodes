package lab.architektury.gamemode.function;

import lab.architektury.gamemode.dto.GetGameModeResponse;
import lab.architektury.gamemode.entity.GameMode;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GameModeToResponseFunction implements Function<GameMode, GetGameModeResponse>
{
    @Override
    public GetGameModeResponse apply(GameMode entity)
    {
        return GetGameModeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .objectiveNumber(entity.getObjectiveNumber())
                .build();
    }
}
