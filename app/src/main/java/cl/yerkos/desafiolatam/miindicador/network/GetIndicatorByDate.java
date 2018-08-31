package cl.yerkos.desafiolatam.miindicador.network;

import android.os.AsyncTask;

import java.io.IOException;

import cl.yerkos.desafiolatam.miindicador.models.Wrapper;
import retrofit2.Call;
import retrofit2.Response;

public class GetIndicatorByDate extends AsyncTask<String, Void, Wrapper> {

    @Override
    protected Wrapper doInBackground(String... strings) {
        MiIndicador miIndicador = new Interceptor().get();
        Call<Wrapper> wrapperCall = miIndicador.indicatorByDate(strings[0], strings[1]);
        try {
            Response<Wrapper> response = wrapperCall.execute();
            if (200 == response.code() && response.isSuccessful()){
                return response.body();
            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
