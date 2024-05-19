package lab.architektury.gamemode.entity;

import jakarta.persistence.*;
import lab.architektury.map.entity.Map;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "gameModes")
public class GameMode implements Serializable
{
    @Id
    private UUID id;

    @OneToMany(mappedBy = "gameMode", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Map> maps;
}
