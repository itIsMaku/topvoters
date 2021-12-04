package cz.maku.topvoters.v1.controller;

import cz.maku.topvoters.v1.model.CraftListVote;
import cz.maku.topvoters.v1.model.CzechCraftVote;
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

    /*

        Maybe sometimes when I will have more time I will rewrite this. But now it's not time for that. :P
        - maku 04.12.2021 20:40

     */

    @GetMapping("/czech-craft/{identifier}/{month}/")
    public ResponseEntity<Map<String, Integer>> czechCraft(@PathVariable("identifier") String identifier, @PathVariable("month") int month) {
        List<CzechCraftVote> czechCraftVotes = topVotersService.czechCraftVotes(identifier, 2021, month);
        Map<String, Integer> votes = new HashMap<>();
        for (CzechCraftVote ccv : czechCraftVotes) {
            if (votes.containsKey(ccv.getUsername())) {
                votes.put(ccv.getUsername(), votes.get(ccv.getUsername()) + 1);
                continue;
            }
            votes.put(ccv.getUsername(), 1);
        }
        return sortMapByValue(votes);
    }

    @GetMapping("/craftlist/{identifier}/{month}/")
    public ResponseEntity<Map<String, Integer>> craftList(@PathVariable("identifier") String identifier, @PathVariable("month") int month) {
        List<CraftListVote> craftListVotes = topVotersService.craftListVotes(identifier, 2021, month);
        Map<String, Integer> votes = new HashMap<>();
        for (CraftListVote clv : craftListVotes) {
            if (votes.containsKey(clv.getNickname())) {
                votes.put(clv.getNickname(), votes.get(clv.getNickname()) + 1);
                continue;
            }
            votes.put(clv.getNickname(), 1);
        }
        return sortMapByValue(votes);
    }

    private ResponseEntity<Map<String, Integer>> sortMapByValue(Map<String, Integer> votes) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(votes.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return ResponseEntity.ok(result);
    }

}
