package app.android.girod.imageur.data.api;

import app.android.girod.imageur.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germangirod on 8/30/16.
 */
public class RestClient {

    private static Api REST_Client;

    static {
        setupRestClient();
    }

    private RestClient() {

    }

    public static Api get() {
        return REST_Client;
    }

    private static void setupRestClient() {

        Retrofit builder = new Retrofit.Builder().baseUrl(BuildConfig.API_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        REST_Client = builder.create(Api.class);
    }

    private static OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }

    /*private static GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adding custom deserializers
        /*gsonBuilder.registerTypeAdapter(SignUpResponse.class, new SignUpDeserializer());
        gsonBuilder.registerTypeAdapter(VerifyCodeResponse.class, new VerifyCodeDeserializer());
        gsonBuilder.registerTypeAdapter(SessionTokenResponse.class, new UserTokenDeserializer());
        gsonBuilder.registerTypeAdapter(UserProfileResponse.class, new UserProfileDeserializer());
        gsonBuilder.registerTypeAdapter(FileResponse.class, new FileDeserializer());
        gsonBuilder.registerTypeAdapter(ZiingResponse.class, new ZiingDeserializer());
        gsonBuilder.registerTypeAdapter(ContactResponse.class, new ContactsDeserializer());
        gsonBuilder.registerTypeAdapter(ZiingsListResponse.class, new ZiingListDeserializer());
        gsonBuilder.registerTypeAdapter(ImagesResponse.class, new ImagesListDeserializer());
        Gson myGson = gsonBuilder.create();*/

        //return GsonConverterFactory.create(myGson);
    //}

}
