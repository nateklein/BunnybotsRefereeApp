package frc.team449.bunnybotsrefereeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends Activity {

    public static ArrayList<Match> matches;
    public static int currentMatch;
    public static int nextMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matches = new ArrayList<>();
        currentMatch = 1;
        nextMatch = 2;
        matches.add(new Match(currentMatch));
        Intent i = new Intent(this, RefereeScreenActivity.class);
        startActivity(i);
    }
}
