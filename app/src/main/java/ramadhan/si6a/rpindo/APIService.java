package ramadhan.si6a.rpindo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                   @Field("password") String password);

    @GET("RPINDO")
    Call<ValueData<List<Unggah>>> getUnggah();

    @FormUrlEncoded
    @POST("RPINDO")
    Call<ValueNoData> addUnggah(@Field("namakota") String namaevent,
                                @Field("jenis") String alamat,
                                @Field("deskripsi") String deskripsi,
                                @Field("user_id") String user_id);

    @FormUrlEncoded
    @PUT("RPINDO")
    Call<ValueNoData> updateUnggah(@Field("id") String id,
                                   @Field("namakota") String namaevent,
                                   @Field("jenis") String alamat,
                                   @Field("deskripsi") String deskripsi);

    @DELETE("RPINDO/{id}")
    Call<ValueNoData> deleteUnggah(@Path("id") String id);
}
