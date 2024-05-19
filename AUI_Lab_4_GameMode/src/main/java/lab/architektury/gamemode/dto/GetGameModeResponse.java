package lab.architektury.gamemode.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetGameModeResponse
{
    private UUID id;
    private String name;
    private Integer objectiveNumber;
}
