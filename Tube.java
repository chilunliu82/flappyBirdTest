package chilunliu.com;

import java.util.Random;

public class Tube {
    // TubeX = Tube X-coordinate, topTubeOffsetY = top tube bottom edge coordinate
    private int tubeX, topTubeOffsetY;
    private Random random;
    private int tubeColour;
    public Tube(int tubeX, int topTubeOffsetY){
        this.tubeX = tubeX;
        this.topTubeOffsetY = topTubeOffsetY;
        random = new Random();
    }

    public void setTubeColour(){
        tubeColour = random.nextInt(2);
    }

    public int getTubeColour(){
        return tubeColour;
    }

    public int getTopTubeOffsetY(){
        return topTubeOffsetY;
    }

    public int getTubeX(){
        return tubeX;
    }

    public int getTopTubeY(){
        return topTubeOffsetY - AppConstants.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return topTubeOffsetY + AppConstants.gapBetweenTopAndBottomTubes;
    }

    public void setTubeX(int tubeX){
        this.tubeX = tubeX;
    }

    public void setTopTubeOffsetY(int topTubeOffsetY){
        this.topTubeOffsetY = topTubeOffsetY;
    }

}
