import java.util.ArrayList;

/**
 * Created by Siddharth on 10/25/16.
 */

public class CDPlayer extends MusicPlayer {

    private int deviceID;
    private int thisTrack;

    /**
     * Constructor for CD-Player
     */
    public CDPlayer(int id) {
        deviceID = id;
    }

    /**
     * Over-ride Method: turnOn
     */
    public void turnOn() {
        super.turnOn();
        thisTrack = 0;
    }

    /**
     * Over-ride Method: turnOff
     */
    public void turnOff() {
        super.turnOff();
        thisTrack = 0;
    }

    /**
     * Method to play next track in the playlist by
     * printing it to stdout and changing current
     */
    public void nextTrack() {
        this.thisTrack++;
        System.out.println("Playing: " + playlist.get(thisTrack));
    }

    /**
     * Method to play previous track in the playlist by
     * printing it to stdout and changing current
     */
    public void previousTrack() {
        this.thisTrack--;
        System.out.println("Playing: " + playlist.get(thisTrack));
    }

    /**
     * Method to play current track
     */
    public void play() {
        super.play(thisTrack);
    }

}

