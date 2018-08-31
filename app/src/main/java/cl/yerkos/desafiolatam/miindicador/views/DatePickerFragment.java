package cl.yerkos.desafiolatam.miindicador.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerCallback datePickerCallback;

    public static DatePickerFragment newInstance(){
        return new DatePickerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        datePickerCallback = (DatePickerCallback) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = String.valueOf(dayOfMonth) +"-0"+ String.valueOf(month) +"-"+ String.valueOf(year);
        datePickerCallback.callbackSetDate(date);

    }
}
