package org.training;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test for simple Game.
 */
public class GameTest

{
    Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game("Team 1", "Team 2");

    }

    @Test
    public void newGameWithTeams() {
        String teams = g.getTeamOne() + " " + g.getTeamTwo();
        assertEquals(teams, "Team 1" + " " + "Team 2");
    }


    @Test
    public void shot() throws Exception {
        g.shot(true);
        assertEquals(g.getScore().size(), 1);
    }

    @Test
    public void shotNTimes() throws Exception {
        g.shot(true, 4);
        assertEquals(g.getScore().size(), 4);
    }

    @Test
    public void winner() throws Exception {
        g.shot(true, 9);
        g.shot(false);
        assertEquals(g.getWinner(), "Team 1");

    }

    @Test
    public void gameNotOver() throws Exception {
        g.shot(true, 4);
        assertEquals(g.getWinner(), "Game is not over");
    }

    @Test
    public void gameOver() throws Exception {
        g.shot(true, 9);
        g.shot(false);
        assertEquals(g.isOver(),true);
    }

    @Ignore
    @Test
    public void earlyWin() throws Exception {
        g.shot(false);
        g.shot(true);
        g.shot(false);
        g.shot(true,3);
        assertEquals(g.isOver(),true);
    }

}
