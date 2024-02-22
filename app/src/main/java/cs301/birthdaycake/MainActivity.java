package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView goodCake = findViewById(R.id.cakeview);
        CakeController cakeControl = new CakeController(goodCake);
        goodCake.setOnTouchListener(cakeControl);


        Button blowOut = findViewById(R.id.blowButton);
        blowOut.setOnClickListener(cakeControl);

        Switch candles = findViewById(R.id.candlesButton);
        candles.setOnCheckedChangeListener(cakeControl);

        SeekBar numCandles = findViewById(R.id.candlesSeekBar);
        numCandles.setOnSeekBarChangeListener(cakeControl);

        SurfaceView surfsUp= findViewById(R.id.cakeview);
        surfsUp.setOnTouchListener(cakeControl);

    }

    public void goodbye(View button) {
        Log.i("button", "goodbye");
    }
}
