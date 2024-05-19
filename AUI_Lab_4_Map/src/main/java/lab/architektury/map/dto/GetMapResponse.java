package lab.architektury.map.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMapResponse
{
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class GameMode
    {
        private UUID id;
        private String name;
    }

    private UUID id;
    private String name;
    private Integer healthKits;
    private GameMode gameMode;
}
