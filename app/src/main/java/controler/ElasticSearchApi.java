package controler;

import java.util.HashMap;
import java.util.Map;

import model.Car;
import model.HitsObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ElasticSearchApi {

    @GET("_search/")
    Call<HitsObject> search(
                @HeaderMap Map<String, String> headers,
                @Query("default_operator") String operator,
                @Query("q") String query
                //@Body String body
    );

    @POST("_search")
    Call<HitsObject> search1(
            @HeaderMap Map<String,String> headers,
            @Body RequestBody body
    );
}
