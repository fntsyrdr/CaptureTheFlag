package scarcity.captuetheflag.Models;

import java.util.Timer;

public class GameTimer {
    private static long startTime;
    private static long gameTimeAllowed;

    public static void setStartTime(long newStartTime)
    {
        startTime = newStartTime;
    }

    public static void setGameTimeAllowed(long newGameTimeAllowed){
        gameTimeAllowed = newGameTimeAllowed;
    }

    public static boolean isGameOver(){
        return System.currentTimeMillis() - startTime > gameTimeAllowed;
    }
}
