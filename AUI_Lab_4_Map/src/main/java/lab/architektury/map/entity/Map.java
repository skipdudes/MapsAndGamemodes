package lab.architektury.map.entity;

import jakarta.persistence.*;
import lab.architektury.gamemode.entity.GameMode;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "maps")
public class Map implements Serializable
{
    @Id
    private UUID id;
    private String name;
    private Integer healthKits;

    @ManyToOne
    @JoinColumn(name = "gameMode")
    private GameMode gameMode;
}
