package com.lucaslimeira.u2ex1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Calendar calendar;
    OnDateSetListerner onDateSetListerner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onDateSetListerner = (OnDateSetListerner) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + e.getMessage());
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }

        return new DatePickerDialog(getActivity(), this, this.calendar.get(Calendar.YEAR), this.calendar.get(Calendar.MONTH), this.calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        onDateSetListerner.updateDate(year, month, dayOfMonth);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public interface OnDateSetListerner {
        void updateDate(int year, int month, int dayOfMonth);
    }
}