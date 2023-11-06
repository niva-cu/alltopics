package com.nivs.all.app_networking

import com.nivs.all.di_hilt_room.ModelAPI
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
//di_hilt_room,  di_hilt_room_fromApi_ToActivity and retroGlideRecycler projects
// Retrofit object to be cnaed and cecked wile runnin

    /*
    di_hilt_room and di_hilt_room_fromApi_ToActivity projects
    */

   /* @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }*/

    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit) : ModelAPI {
        return retrofit.create(ModelAPI::class.java)
    }


    /*
    retroGlideRecycler projects
    */

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/apis/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    /*
            okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("X-App-Version", "1.23")
                    builder.header("X-Platform", "Android")
                    builder.header("X-Auth-Token", "sgsrager32524542afg3423")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()


        sometimes add eader for specific call
        @Headers(
            "Cache-Control: max-age=60",
            "Accept-Path": true")
        @GET("v1/users/getDetail")
        fun getUserDetails(): Single<UserInfo>
    * */

    @Singleton
    @Provides
    fun provideOkHttp() : OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}