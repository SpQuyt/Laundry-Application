package org.lma.helpers;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private static Timer mTimer = new Timer();

    private static String now = "";
    private static TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            now = MyTime.convertTimeToString();
            System.out.println(now);
        }
    };

    private static void start() {
        mTimer.scheduleAtFixedRate(mTask, 1000, 1000);
    }
    
    public Clock(String s) {
    	Clock.start();
    }

    public static void main(String[] args) {
    	Clock.start();
    }
}
