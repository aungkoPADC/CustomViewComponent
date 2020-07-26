package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.network

import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.network.responses.GetAllNewsResponse
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.utils.GET_NEWS
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.utils.PARAM_ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {
    @FormUrlEncoded
    @POST(GET_NEWS)
    fun getAllNews(@Field(PARAM_ACCESS_TOKEN) accessToken : String)
            : Observable<GetAllNewsResponse>

    /*

    val BASE_URL = "https://api.themoviedb.org/3"

    val LATEST_MOVIE = "latest_movie"
    val MOVIE_DETAIL = "movie_detail"

    val PARAM_API_KEY = "api_key"

    @GET(LATEST_MOVIE)
    fun getLatestMoveList(@Query(PARAM_API_KEY) apiKey : String) : Observable<MovieListResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetail(@Query(PARAM_API_KEY) apiKey : String,@Path("MOVIE_ID") movieID:Int) : Observable<MovieVO>

 */
}