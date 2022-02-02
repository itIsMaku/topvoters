package cz.maku.topvoters.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://czech-craft.eu/api/server/SERVER-SLUG/votes/YYYY/MM/
 */
@AllArgsConstructor
@Getter
@Setter
public class CzechCraftVote extends Vote {

    private String datetime;
    private boolean delivered;
    private String username;
}
