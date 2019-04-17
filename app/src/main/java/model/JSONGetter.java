package model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONGetter {

    @GET("bins/vgtow")
    Call<List<Models>> getPosts();

    @GET("cars/car/_search")
    Call<CarJSONModel> getCar(@Header("Authorization") String authorization);

    @GET("_search/")
    Call<CarJSONModel> search(
            @HeaderMap Map<String,String> headers,
            @Query("default_operator") String operator,
            @Query("q") String query);
    @GET("_search")
    Call<CarJSONModel> search1(
            @HeaderMap Map<String,String> headers);


}
