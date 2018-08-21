package com.example.siddharth.lab10;
import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShakeModel {

    String[] messages = new String[8];
    ShakeView view;

    public ShakeModel(ShakeView view) {
        //TO-DO: initialize instance variables
        this.view = view;
        //create different response messages in all positions of the messages array
        messages[0] = "Yes";
        messages[1] = "Done";
        messages[2] = "Hello";
        messages[3] = "Goodbye ";
        messages[4] = "Next ";
        messages[5] = "Back";
        messages[6] = "Shake Again ";
        messages[7] = "Thank you ";
    }

    public void displayMessage() {
        //TO-DO: choose a random message of the array
        Random rd = new Random();
        int index = rd.nextInt(7);
        view.changeMessage(messages[index]);
        //make a call to view.changeMessages using the random message chosen
    }


}