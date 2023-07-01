package com.tie.fantasyking.ApiClient;

import com.tie.fantasyking.promotion.Promotion_Model;
import com.tie.fantasyking.ui.Cricket.MatchList_Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("get_matchdetails.php")
    Call<MatchList_Model> getMatchList();

    @GET("get_promotion.php")
    Call<Promotion_Model> getPromotionList();
}
