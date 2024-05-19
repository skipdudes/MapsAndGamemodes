package lab.architektury.gamemode.initialize;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.gamemode.service.api.GameModeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean
{
    private final GameModeService gameModeService;

    @Autowired
    public InitializeData(GameModeService gameModeService)
    {
        this.gameModeService = gameModeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        if(gameModeService.findAll().isEmpty())
        {
            GameMode ctf = GameMode.builder()
                    .id(UUID.fromString("e1500356-ec4f-4e54-88e4-a847532f8dfc"))
                    .name("Capture the Flag")
                    .objectiveNumber(2)
                    .build();

            GameMode koth = GameMode.builder()
                    .id(UUID.fromString("3f186f93-f08c-4bbc-92ef-bae861daf85d"))
                    .name("King of the Hill")
                    .objectiveNumber(1)
                    .build();

            GameMode plr = GameMode.builder()
                    .id(UUID.fromString("1a3510b9-8b5a-4b87-8d48-906a3227f186"))
                    .name("Payload Race")
                    .objectiveNumber(2)
                    .build();

            gameModeService.create(ctf);
            gameModeService.create(koth);
            gameModeService.create(plr);
        }
    }
}
