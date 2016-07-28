package dalbers.com.timerpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.Time;

/**
 * Created by davidalbers on 7/12/16.
 */
public class TimerPickerDialogFragment extends DialogFragment {
    private TimerTextView timerTextView;
    private TimerPickerDialogListener listener;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private ImageButton deleteButton;
    private TimerViewUtils.DelimiterType delimiterType = TimerViewUtils.DelimiterType.hms;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.numerical_dialog_layout, null);
        timerTextView = (TimerTextView)view.findViewById(R.id.timerTextView);
        timerTextView.setDelimiterType(delimiterType);
        oneButton = (Button)view.findViewById(R.id.one_button);
                oneButton.setOnClickListener(numberButtonClickListener);
        twoButton = (Button)view.findViewById(R.id.two_button);
        twoButton.setOnClickListener(numberButtonClickListener);
        threeButton = (Button)view.findViewById(R.id.three_button);
        threeButton.setOnClickListener(numberButtonClickListener);
        fourButton = (Button)view.findViewById(R.id.four_button);
        fourButton.setOnClickListener(numberButtonClickListener);
        fiveButton = (Button)view.findViewById(R.id.five_button);
        fiveButton.setOnClickListener(numberButtonClickListener);
        sixButton = (Button)view.findViewById(R.id.six_button);
        sixButton.setOnClickListener(numberButtonClickListener);
        sevenButton = (Button)view.findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(numberButtonClickListener);
        eightButton = (Button)view.findViewById(R.id.eight_button);
        eightButton.setOnClickListener(numberButtonClickListener);
        nineButton = (Button)view.findViewById(R.id.nine_button);
        nineButton.setOnClickListener(numberButtonClickListener);
        zeroButton = (Button)view.findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(numberButtonClickListener);
        deleteButton = (ImageButton)view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerTextView.removeLastNumber();
            }
        });
            builder.setView(view);
        builder.setMessage(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_set, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(listener != null)
                            listener.timeSet(timerTextView.getTime());
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(listener != null)
                            listener.dialogCanceled();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public void setDialogListener(TimerPickerDialogListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.one_button)
                timerTextView.appendNumber(1);
            else if (v.getId() == R.id.two_button)
                timerTextView.appendNumber(2);
            else if (v.getId() == R.id.three_button)
                timerTextView.appendNumber(3);
            else if (v.getId() == R.id.four_button)
                timerTextView.appendNumber(4);
            else if (v.getId() == R.id.five_button)
                timerTextView.appendNumber(5);
            else if (v.getId() == R.id.six_button)
                timerTextView.appendNumber(6);
            else if (v.getId() == R.id.seven_button)
                timerTextView.appendNumber(7);
            else if (v.getId() == R.id.eight_button)
                timerTextView.appendNumber(8);
            else if (v.getId() == R.id.nine_button)
                timerTextView.appendNumber(9);
            else if (v.getId() == R.id.zero_button)
                timerTextView.appendNumber(0);
        }
    };

    public void setDelimiter(TimerViewUtils.DelimiterType delimiterType) {
        this.delimiterType = delimiterType;
    }

    private void setColors(int color) {
        oneButton.setTextColor(color);
        twoButton.setTextColor(color);
        threeButton.setTextColor(color);
        fourButton.setTextColor(color);
        fiveButton.setTextColor(color);
        sixButton.setTextColor(color);
        sevenButton.setTextColor(color);
        eightButton.setTextColor(color);
        nineButton.setTextColor(color);
        zeroButton.setTextColor(color);
        timerTextView.setTextColor(color);

    }
}