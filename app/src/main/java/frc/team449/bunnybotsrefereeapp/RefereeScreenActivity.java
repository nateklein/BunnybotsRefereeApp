package frc.team449.bunnybotsrefereeapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RefereeScreenActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private TextView redTechFouls;
    private TextView redFouls;
    private TextView blueTechFouls;
    private TextView blueFouls;
    private TextView redFoulPoints;
    private TextView blueFoulPoints;
    private Spinner matchSelector;
    private Button nextMatchButton;
    private Match match;
    private int selectedMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referee_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        redTechFouls = findViewById(R.id.redTechFouls);
//        redFouls = findViewById(R.id.redFouls);
        redFoulPoints = findViewById(R.id.redFoulPoints);
        blueFoulPoints = findViewById(R.id.blueFoulPoints);
        blueTechFouls = findViewById(R.id.blueTechFouls);
//        blueFouls = findViewById(R.id.blueFouls);
        nextMatchButton = findViewById(R.id.nextMatch);
        matchSelector = findViewById(R.id.matchDropdown);
        ArrayAdapter<Match> a = new ArrayAdapter<>(this, R.layout.dropdown, MainActivity.matches);
        matchSelector.setAdapter(a);
        matchSelector.setOnItemSelectedListener(this);
        selectedMatch = 1;
        getActionBar().setTitle("Match " + Integer.toString(MainActivity.currentMatch));
        match = MainActivity.matches.get(MainActivity.currentMatch - 1);
        for (Match m : MainActivity.matches) {
            Log.v("matches list", m.toString());
        }
        redTechFouls.setText(Integer.toString(match.getRedTechFouls()));
        redFoulPoints.setText(Integer.toString(match.getRedFoulPoints()));
//        redFouls.setText(Integer.toString(match.getRedFouls()));
        blueTechFouls.setText(Integer.toString(match.getBlueTechFouls()));
//        blueFouls.setText(Integer.toString(match.getBlueFouls()));
        blueFoulPoints.setText(Integer.toString(match.getBlueFoulPoints()));
        nextMatchButton.setText("Next Match (" + Integer.toString(MainActivity.nextMatch) + ")");
    }

    public void plusRedTechFouls(View v) {
        match.setRedTechFouls(match.getRedTechFouls() + 1);
        redTechFouls.setText(Integer.toString(match.getRedTechFouls()));
        blueFoulPoints.setText(Integer.toString(match.getRedFoulPoints()));
    }

    public void minusRedTechFouls(View v) {
        if (match.getRedTechFouls() > 0) {
            match.setRedTechFouls(match.getRedTechFouls() - 1);
            redTechFouls.setText(Integer.toString(match.getRedTechFouls()));
            blueFoulPoints.setText(Integer.toString(match.getRedFoulPoints()));
        }
    }

    public void plusBlueTechFouls(View v) {
        match.setBlueTechFouls(match.getBlueTechFouls() + 1);
        blueTechFouls.setText(Integer.toString(match.getBlueTechFouls()));
        redFoulPoints.setText(Integer.toString(match.getBlueFoulPoints()));
    }

    public void minusBlueTechFouls(View v) {
        if (match.getBlueTechFouls() > 0) {
            match.setBlueTechFouls(match.getBlueTechFouls() - 1);
            blueTechFouls.setText(Integer.toString(match.getBlueTechFouls()));
            redFoulPoints.setText(Integer.toString(match.getBlueFoulPoints()));
        }
    }

    public void plusRedFouls(View v) {
        match.setRedFouls(match.getRedFouls() + 1);
        redFouls.setText(Integer.toString(match.getRedFouls()));
        blueFoulPoints.setText(Integer.toString(match.getRedFoulPoints()));
    }

    public void minusRedFouls(View v) {
        if (match.getRedFouls() > 0) {
            match.setRedFouls(match.getRedFouls() - 1);
            redFouls.setText(Integer.toString(match.getRedFouls()));
            blueFoulPoints.setText(Integer.toString(match.getRedFoulPoints()));
        }
    }

    public void plusBlueFouls(View v) {
        match.setBlueFouls(match.getBlueFouls() + 1);
        blueFouls.setText(Integer.toString(match.getBlueFouls()));
        redFoulPoints.setText(Integer.toString(match.getBlueFoulPoints()));
    }

    public void minusBlueFouls(View v) {
        if (match.getBlueFouls() > 0) {
            match.setBlueFouls(match.getBlueFouls() - 1);
            blueFouls.setText(Integer.toString(match.getBlueFouls()));
            redFoulPoints.setText(Integer.toString(match.getBlueFoulPoints()));
        }
    }

    public void nextMatch(View v) {
        MainActivity.currentMatch = MainActivity.nextMatch;
        MainActivity.nextMatch++;
        MainActivity.matches.add(new Match(MainActivity.currentMatch));
        Intent i = new Intent(this, RefereeScreenActivity.class);
        startActivity(i);
    }

    public void goToPrevious(View v) {
        MainActivity.currentMatch = selectedMatch;
        Intent i = new Intent(this, RefereeScreenActivity.class);
        startActivity(i);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selectedMatch = pos + 1;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Log.v("hmmmm", "how did this happen");
    }

}
