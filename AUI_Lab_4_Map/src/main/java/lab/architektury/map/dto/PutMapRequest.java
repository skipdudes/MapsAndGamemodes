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
public class PutMapRequest
{
    private String name;
    private Integer healthKits;
    private UUID gameMode;
}
