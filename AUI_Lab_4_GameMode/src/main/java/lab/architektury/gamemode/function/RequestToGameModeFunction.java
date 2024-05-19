package lab.architektury.gamemode.function;

import lab.architektury.gamemode.dto.PutGameModeRequest;
import lab.architektury.gamemode.entity.GameMode;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToGameModeFunction implements BiFunction<UUID, PutGameModeRequest, GameMode>
{
    @Override
    public GameMode apply(UUID id, PutGameModeRequest request)
    {
        return GameMode.builder()
                .id(id)
                .name(request.getName())
                .objectiveNumber(request.getObjectiveNumber())
                .build();
    }
}
