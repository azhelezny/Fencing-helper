package pish.fencing_helper;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import properties.Properties;
import utils.Magic;

public class NumbersDisplay extends ActionBarActivity {

    private Timer timer;
    private TextView numberImage;
    private TextView info;

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private int initTimer() {
        timer = new Timer();
        int timeInterval = Magic.getPeriod();
        timer.schedule(new ActionTask(), Magic.getPeriod());
        return timeInterval;
    }

    public void onClick(View view) {
        stopTimer();
        Intent actionIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(actionIntent);
        finish();
    }

    private class ActionTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    doSomething();
                }
            });
        }
    }

    public void doSomething() {
        String position = Magic.getNextPosition().toString();
        numberImage.setText(position);
        try {
            AssetFileDescriptor afd = getAssets().openFd(position + ".mp3");
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.prepare();
            player.start();
            stopTimer();
            while (player.isPlaying()) {
                Thread.sleep(100);
            }
            player.release();

        } catch (Exception e) {
            throw new RuntimeException("You are a pig!");
        }
        int timerValue = initTimer();
        int max = Properties.get().getLevel().getMaxSeconds();
        int min = Properties.get().getLevel().getMinSeconds();
        info.setText("range: [" + min + " - " + max + "], value = " + timerValue + " millisecond(s)");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_display);
        this.numberImage = (TextView) findViewById(R.id.positionText);
        this.info = (TextView) findViewById(R.id.numbers);
        initTimer();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers_display, menu);
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
