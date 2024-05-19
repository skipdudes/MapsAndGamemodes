package lab.architektury.gamemode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "gameModes")
public class GameMode implements Serializable
{
    @Id
    private UUID id;
    private String name;
    private Integer objectiveNumber;
}
