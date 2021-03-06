package cz.maku.topvoters.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * https://api.craftlist.org/v1/token/votes/YYYY/MM/
 */
@AllArgsConstructor
@Getter
@Setter
public class CraftListVote extends Vote {

    private String nickname;
    private int score;
    private String ip;
    private int timestamp;

    @Override
    public String getUsername() {
        return nickname;
    }
}
