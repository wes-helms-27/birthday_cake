package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
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
        //nada
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //no nesecita
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        controlView.setRectX(event.getX());
        controlView.setRectY(event.getY());
        controlView.invalidate();

        return false;
    }
}
