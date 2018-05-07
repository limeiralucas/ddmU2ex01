package com.lucaslimeira.u2ex1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public OnTimeSetListener onTimeSetListener;
    private Calendar calendar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onTimeSetListener = (OnTimeSetListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + e.getMessage());
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.calendar = Calendar.getInstance();

        return new TimePickerDialog(getActivity(), this, this.calendar.get(Calendar.HOUR_OF_DAY), this.calendar.get(Calendar.MINUTE), true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        onTimeSetListener.updateTime(hourOfDay, minute);
    }

    public interface OnTimeSetListener {
        void updateTime(int hourOfDay, int minute);
    }
}
