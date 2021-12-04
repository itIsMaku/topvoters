package cz.maku.topvoters.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * https://czech-craft.eu/api/server/SERVER-SLUG/votes/YYYY/MM/
 */
@AllArgsConstructor
@Getter
@Setter
public class CzechCraftVote implements Serializable {

    private String datetime;
    private boolean delivered;
    private String username;

}
