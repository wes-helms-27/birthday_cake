package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements
        View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private CakeView controlView;
    private CakeModel controlModel;

    public CakeController(CakeView thisCakeView) {
        controlView = thisCakeView;
        controlModel = controlView.getCakeModel();

    }

    @Override
    public void onClick(View v) {
        Log.d("cake", "click");
        controlModel.candlesLit = false;
        controlView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d("cake", "switch");
        controlModel.hasCandles = isChecked;
        controlView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("cake", "seekBar");
        controlModel.numCandles = progress;
        controlView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("cake", "Balloon" );
        this.controlView.touchx = event.getX();
        this.controlView.touchy = event.getY();

        controlView.invalidate();

        return false;
    }

    /** whenever the user touches the surface view */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("face", "touch!");
        this.controlView.touchx = motionEvent.getX();
        this.controlView.touchy = motionEvent.getY();

        controlView.invalidate();

        return false;

    }
}
