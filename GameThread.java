package chilunliu.com;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder; // SurfaceHolder object reference
    boolean isRunning ; // Flag to detect whether teh thread is running or not
    long startTime, loopTime; // Loop start time and loop duration
    long DELAY = 33; // Delay in milliseconds between screen refreshes

    // Constructor
    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run(){
        // Looping until the boolean is false
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            // Locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    AppConstants.getGameEngine().updateAndDrawTubes(canvas);
                    // Unlocking the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            // Loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            // pausing here to make sure we update the right amount per second
            if(loopTime < DELAY){
                try{
                    Thread.sleep(DELAY - loopTime);
                }
                catch(InterruptedException e){
                    Log.e("Interrupted","Interrupted while sleeping");
                }
            }
        }
    }

    // Return whether the thread is running
    public boolean isRunning(){
        return isRunning;
    }

    // Sets the thread state, false = stopped, true = running
    public void setIsRunning(boolean state){
        isRunning = state;
    }

}