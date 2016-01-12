package tomerbu.itworks.edu.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private EditText etRed, etGreen, etBlue, etTotal;
    private SeekBar sbRed, sbGreen, sbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();

       sbRed.setOnSeekBarChangeListener(this);
       sbGreen.setOnSeekBarChangeListener(this);
       sbBlue.setOnSeekBarChangeListener(this);

    }

    private void initLayout() {
        etTotal = (EditText) findViewById(R.id.etTotal);
        etRed = (EditText) findViewById(R.id.etRed);
        etGreen = (EditText) findViewById(R.id.etGreen);
        etBlue = (EditText) findViewById(R.id.etBlue);

        sbBlue = (SeekBar) findViewById(R.id.sbBlue);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbRed = (SeekBar) findViewById(R.id.sbRed);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        etBlue.setText(""+sbBlue.getProgress());
        etGreen.setText(""+sbGreen.getProgress());
        etRed.setText("" + sbRed.getProgress());

        int totalColor = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());
        etTotal.setBackgroundColor(totalColor);

        String hexColor = Integer.toHexString(totalColor);

        etTotal.setText(hexColor);


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
