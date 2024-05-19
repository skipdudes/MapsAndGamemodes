package lab.architektury.map.initialize;

import lab.architektury.gamemode.entity.GameMode;
import lab.architektury.gamemode.service.api.GameModeService;
import lab.architektury.map.entity.Map;
import lab.architektury.map.service.api.MapService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean
{
    private final MapService mapService;
    private final GameModeService gameModeService;

    @Autowired
    public InitializeData(
            MapService mapService,
            GameModeService gameModeService
    ) {
        this.mapService = mapService;
        this.gameModeService = gameModeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        if(mapService.findAll().isEmpty())
        {
            GameMode ctf = GameMode.builder()
                    .id(UUID.fromString("e1500356-ec4f-4e54-88e4-a847532f8dfc"))
                    .build();

            GameMode koth = GameMode.builder()
                    .id(UUID.fromString("3f186f93-f08c-4bbc-92ef-bae861daf85d"))
                    .build();

            GameMode plr = GameMode.builder()
                    .id(UUID.fromString("1a3510b9-8b5a-4b87-8d48-906a3227f186"))
                    .build();

            gameModeService.create(ctf);
            gameModeService.create(koth);
            gameModeService.create(plr);

            Map ctf_2fort = Map.builder()
                    .id(UUID.fromString("4a1a63f7-afa7-4dd0-b605-143d0082f70a"))
                    .name("2Fort")
                    .healthKits(6)
                    .gameMode(ctf)
                    .build();

            Map ctf_turbine = Map.builder()
                    .id(UUID.fromString("e81c3b8c-f0bf-4ed2-873d-1c09d85d29a3"))
                    .name("Turbine")
                    .healthKits(6)
                    .gameMode(ctf)
                    .build();

            Map ctf_sawmill = Map.builder()
                    .id(UUID.fromString("15703308-b67b-48a0-b243-d9a28a6bb045"))
                    .name("Sawmill")
                    .healthKits(9)
                    .gameMode(ctf)
                    .build();

            Map koth_harvest = Map.builder()
                    .id(UUID.fromString("ecfcc234-6743-49f0-8201-2535cfd99140"))
                    .name("Harvest")
                    .healthKits(8)
                    .gameMode(koth)
                    .build();

            Map koth_suijin = Map.builder()
                    .id(UUID.fromString("b9d89055-9cd8-414f-a266-60c5e5706e76"))
                    .name("Suijin")
                    .healthKits(7)
                    .gameMode(koth)
                    .build();

            Map plr_hightower = Map.builder()
                    .id(UUID.fromString("da043457-7f52-4286-b797-cf1aad533a26"))
                    .name("Hightower")
                    .healthKits(12)
                    .gameMode(plr)
                    .build();

            Map plr_bananabay = Map.builder()
                    .id(UUID.fromString("64e93ac1-dc0c-40c8-a536-0804e6b0ea30"))
                    .name("Banana Bay")
                    .healthKits(14)
                    .gameMode(plr)
                    .build();

            mapService.create(ctf_2fort);
            mapService.create(ctf_turbine);
            mapService.create(ctf_sawmill);
            mapService.create(koth_harvest);
            mapService.create(koth_suijin);
            mapService.create(plr_hightower);
            mapService.create(plr_bananabay);
        }
    }
}
