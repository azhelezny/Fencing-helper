package pish.fencing_helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;

import enums.Levels;
import properties.Properties;


public class MainActivity extends ActionBarActivity {
    RadioButton medium;
    RadioButton hard;
    CheckBox useRandom;

    public View.OnClickListener startButtonListener = new View.OnClickListener() {
        public void onClick(View v) {


            Levels lvlOfDifficulty = Levels.simple;
            if (medium.isChecked())
                lvlOfDifficulty = Levels.medium;
            if (hard.isChecked())
                lvlOfDifficulty = Levels.hard;

            Properties.get().setLevel(lvlOfDifficulty);
            Properties.get().setUseRandom(useRandom.isChecked());

            Intent actionIntent = new Intent(v.getContext(), NumbersDisplay.class);
            startActivity(actionIntent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.medium = (RadioButton) findViewById(R.id.medium);
        this.hard = (RadioButton) findViewById(R.id.hard);
        this.useRandom = (CheckBox) findViewById(R.id.random);
        ImageButton startButton = (ImageButton) findViewById(R.id.start);
        startButton.setOnClickListener(startButtonListener);
        useRandom.setChecked(Properties.get().isUseRandom());
        if (Properties.get().getLevel() == Levels.hard) {
            hard.setChecked(true);
            return;
        }
        if (Properties.get().getLevel() == Levels.medium)
            medium.setChecked(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
