package com.jlp.mvvm_jlp_project.api;


import androidx.annotation.NonNull;

import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {

    @Provides
    public static ApiService getApi() {
        return getRetrofit().create( ApiService.class );
    }

    @NonNull
    protected static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .baseUrl(Constants.API_BASE_URL)
                .client(okHttpClient)
                .build();
    }
}
