package org.tburke.javavideogamebackendexample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tburke.javavideogamebackendexample.models.MatchHistory;
import org.tburke.javavideogamebackendexample.repo.MatchHistoryRepository;
import org.tburke.javavideogamebackendexample.repo.PlayerScore;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
    public class MatchHistoryService {
    @Autowired
    private UserService userService;
        private final MatchHistoryRepository repository;

        public MatchHistoryService(MatchHistoryRepository repository) {
            this.repository = repository;
        }

        public List<MatchHistory> findAll() {
            return repository.findAll();
        }

        public List<MatchHistory> findAllByUserName(String userName) {
            return repository.findByUserName(userName);
        }

    public List<PlayerScore> calculateHighScores() {
        List<MatchHistory> allMatches = repository.findAll();
        Map<Long, Long> winsCount = allMatches.stream()
                .collect(Collectors.groupingBy(o -> o.getWinner().getUserId(), Collectors.counting()));

        Map<Long, Long> totalMatchesPerPlayer = allMatches.stream()
                .flatMap(match -> Stream.of(match.getUser1().getUserId(), match.getUser2().getUserId()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<PlayerScore> returnList = winsCount.entrySet().stream()
                .map(entry -> new PlayerScore(
                        entry.getKey(),
                        entry.getValue(),
                        totalMatchesPerPlayer.getOrDefault(entry.getKey(), 0L),
                        entry.getValue() * 1.0 / totalMatchesPerPlayer.getOrDefault(entry.getKey(), 1L)
                ))
                .sorted(Comparator.comparing(PlayerScore::getTotalWins, Comparator.reverseOrder())
                        .thenComparing(PlayerScore::getWinRatio, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        returnList.forEach(playerScore -> playerScore.setUserName(userService.getUser(playerScore.getUserId()).getName()));

        return returnList;
    }
    }
