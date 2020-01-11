package controler;

import java.util.Map;
import model.HitsObject;
import retrofit2.Call;
import retrofit2.http.Body;
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
}
