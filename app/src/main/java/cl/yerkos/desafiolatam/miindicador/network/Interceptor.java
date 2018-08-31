package cl.yerkos.desafiolatam.miindicador.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Interceptor {

    private static final String BASE_URL = "http://mindicador.cl/";

    public MiIndicador get(){
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MiIndicador indicadorRequest = interceptor.create(MiIndicador.class);
        return indicadorRequest;
    }
}
