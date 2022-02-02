package cz.maku.topvoters.v1.controller;

import cz.maku.topvoters.utils.Commons;
import cz.maku.topvoters.v1.model.CraftListVote;
import cz.maku.topvoters.v1.model.CzechCraftVote;
import cz.maku.topvoters.v1.model.Vote;
import cz.maku.topvoters.v1.service.TopVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class MainRestController {

    @Autowired
    private TopVotersService topVotersService;

    @GetMapping("/czech-craft/{identifier}/{month}/{year}")
    public ResponseEntity<Map<String, Integer>> czechCraft(@PathVariable("identifier") String identifier, @PathVariable("month") int month, @PathVariable("year") int year) {
        List<CzechCraftVote> czechCraftVotes = topVotersService.czechCraftVotes(identifier, year, month);
        return ResponseEntity.ok(Commons.sortMapByValue(getVotes(czechCraftVotes)));
    }

    @GetMapping("/craftlist/{identifier}/{month}/{year}")
    public ResponseEntity<Map<String, Integer>> craftList(@PathVariable("identifier") String identifier, @PathVariable("month") int month, @PathVariable("year") int year) {
        List<CraftListVote> craftListVotes = topVotersService.craftListVotes(identifier, year, month);
        return ResponseEntity.ok(Commons.sortMapByValue(getVotes(craftListVotes)));
    }

    private Map<String, Integer> getVotes(List<? extends Vote> votes) {
        Map<String, Integer> tempVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (tempVotes.containsKey(vote.getUsername())) {
                tempVotes.put(vote.getUsername(), tempVotes.get(vote.getUsername()) + 1);
                continue;
            }
            tempVotes.put(vote.getUsername(), 1);
        }
        return tempVotes;
    }

}
