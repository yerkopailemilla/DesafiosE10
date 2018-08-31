package cl.yerkos.desafiolatam.miindicador.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.yerkos.desafiolatam.miindicador.R;
import cl.yerkos.desafiolatam.miindicador.models.Wrapper;
import cl.yerkos.desafiolatam.miindicador.network.GetIndicatorByDate;

public class MainActivity extends AppCompatActivity implements DatePickerCallback {

    private Spinner spinner_money;
    private Button date_picker_btn;
    String date_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_money = findViewById(R.id.spinner_money);
        date_picker_btn = findViewById(R.id.date_picker_btn);

        FloatingActionButton fab = findViewById(R.id.fab);

        List<String> list = new ArrayList<>();
        list.add("uf");
        list.add("utm");
        list.add("dolar");
        list.add("euro");
        list.add("bitcoin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        spinner_money.setAdapter(adapter);

        date_picker_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePickerFragment = DatePickerFragment.newInstance();
                datePickerFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

    }

    @Override
    public void callbackSetDate(String date) {
        date_picker_btn.setText(date);
        String money = spinner_money.getSelectedItem().toString();
        new BackgroundMoney().execute(money, date);
    }

    private class BackgroundMoney extends GetIndicatorByDate{

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            if (wrapper != null){
                TextView uf_tv = findViewById(R.id.uf_tv);
                uf_tv.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }
            progressDialog.dismiss();
        }
    }
}
