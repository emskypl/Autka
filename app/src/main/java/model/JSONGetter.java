package model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONGetter {

    @GET("bins/vgtow")
    Call<List<Models>> getPosts();

    @GET("bins/vgtow")
    Call<Models> getModelsDictionary(@FieldMap Map<String,String> fields);

}
