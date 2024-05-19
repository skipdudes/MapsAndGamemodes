package lab.architektury.gamemode.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutGameModeRequest
{
    private String name;
    private Integer objectiveNumber;
}
