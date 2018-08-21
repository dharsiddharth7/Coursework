
import java.util.ArrayList;

/**
 * Created by Siddharth on 10/25/16.
 */

public class EthernetPlayer extends MusicPlayer {

    private int deviceID;
    private int connStatus;

    static final int CONNECTED = 1;
    static final int NOT_CONNECTED = 0;

    private ArrayList<String> downloadList = new ArrayList<String>();

    public EthernetPlayer(int id) {
        super(); // why do we need this?
        deviceID = id;
        connStatus = NOT_CONNECTED;

        downloadList.add("Dark Horse");
        downloadList.add("Royals");
        downloadList.add("Counting Stars");
        downloadList.add("Let Her Go");
        downloadList.add("The Fox");
    }

    /**
     *  @override turnOn and connect
     *
     */
    public void turnOn() {
        super.turnOn();
        connStatus = CONNECTED;
    }

    /**
     *  @override turnOff and disconnect
     *
     */
    public void turnOff() {
        super.turnOff();
        connStatus = NOT_CONNECTED;
    }


    /**
     *  addTrackToPlaylist: Adds mentioned track to the end of playlist array
     *  print appropriate messages to stdout
     *
     */
    public void addToPlaylist(String trackName) {
        playlist.add(trackName);
        System.out.println("Added " + trackName + " to the playlist");
    }

    /**
     *  deleteFromPlaylist: deletes track of give name from the playlist
     *  print appropriate messages to stdout
     *
     */
    public void deleteFromPlaylist(String trackName) {
        for (int i = 0; i < PLAYLIST_SIZE; i++) {
            if(playlist.get(i).equals(trackName)) {
                playlist.remove(i);
                break;
            }
        }

        System.out.println("Deleted " + trackName + " from the playlist");
    }

    /**
     *  download: Downloads mentioned song from the given Download list and adds to playlist
     *  print appropriate messages to stdout
     *
     */
    public void download(String trackName) {
        if(trackName.equals("Dark Horse") || trackName.equals("Royals") || trackName.equals("Counting Stars") ||
                trackName.equals("Let Her Go") || trackName.equals("The Fox"))
            playlist.add(trackName);
        else
            System.out.println("Track " + trackName + " doesn't exist");
    }

}

