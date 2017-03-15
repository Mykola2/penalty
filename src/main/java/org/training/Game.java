package org.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Game {
    private String teamOne;
    private String teamTwo;
    private List<Boolean> score;
    private Boolean isOver;

    public Game(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        score = new ArrayList<Boolean>();
        isOver = false;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public List<Boolean> getScore() {
        return score;
    }

    public void shot(boolean b) {
        score.add(b);
    }

    public void shot(boolean b, int times) {
        int i = 0;
        while (i != times) {
            score.add(b);
            i++;
        }
    }

    public String getWinner() {
        int teamOneFails = 0;
        int teamTwoFails = 0;
        teamOneFails = getFailedShots()[0];
        teamTwoFails = getFailedShots()[1];
        if (moreThanTenShots()) {
            if (score.size() % 2 == 0) {
                if (teamOneFails > teamTwoFails) {
                    return teamTwo;
                } else
                    return teamOne;
            }
        }
        return "Game is not over";
    }

    public boolean isOver() {
        int teamOneFails = 0;
        int teamTwoFails = 0;
        teamOneFails = getFailedShots()[0];
        teamTwoFails = getFailedShots()[1];
        if (moreThanTenShots()) {
            if (score.size() % 2 == 0) {
                if (teamOneFails != teamTwoFails) {
                    isOver = true;
                }
            }
        }else if((score.size() - Math.abs(teamOneFails - teamTwoFails)) - 1 <= 5 - (score.size() /2)){
            isOver = true;
        }
        return isOver;
    }

    private boolean moreThanTenShots() {
        return score.size() >= 10;
    }

    private int[] getFailedShots() {
        int[] failedPair = new int[2];
        int teamOneFails = 0;
        int teamTwoFails = 0;
        for (int i = 0; i < score.size(); i++) {
            if (!score.get(i)) {
                if (i % 2 == 0)
                    teamOneFails++;
                else
                    teamTwoFails++;
            }
        }
        failedPair[0] = teamOneFails;
        failedPair[1] = teamTwoFails;
        return failedPair;
    }
}
