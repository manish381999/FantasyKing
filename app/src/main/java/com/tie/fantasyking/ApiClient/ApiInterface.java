package com.tie.fantasyking.ApiClient;

import com.tie.fantasyking.ui.SportNews.CricketSeriesInfoModel;
import com.tie.fantasyking.ui.SportNews.CricketSeriesModel;
import com.tie.fantasyking.ui.promotion.Promotion_Model;
import com.tie.fantasyking.ui.Cricket.MatchList_Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("get_cricket_matchdetails.php")
    Call<MatchList_Model> getCricketMatchList();
    @GET("get_promotion.php")
    Call<Promotion_Model> getPromotionList();

    @GET("v1/series?apikey=32969b4d-c1a2-4edf-834f-715eabf450b7&offset=0")
    Call<CricketSeriesModel> getCricketSeries();

    @FormUrlEncoded
    @POST("v1/series_info?apikey=32969b4d-c1a2-4edf-834f-715eabf450b7&id=")
    Call<CricketSeriesInfoModel> getCricketSeriesInfo(
            @Field("id") String id

    );

    @GET("get_football_matchdetails.php")
    Call<MatchList_Model> getFootballMatchList();

}
