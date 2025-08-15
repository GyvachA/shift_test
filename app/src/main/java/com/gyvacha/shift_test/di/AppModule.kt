package com.gyvacha.shift_test.di

import android.content.Context
import androidx.room.Room
import com.gyvacha.shift_test.data.local.ShiftDatabase
import com.gyvacha.shift_test.data.remote.RandomUserApi
import com.gyvacha.shift_test.data.repository.RandomUserRepositoryImpl
import com.gyvacha.shift_test.domain.repository.RandomUserRepository
import com.gyvacha.shift_test.utils.PreferenceManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ShiftDatabase {
        return Room.databaseBuilder(
            context,
            ShiftDatabase::class.java,
            "shift.dp"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRandomUserApi(): RandomUserApi {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
        return retrofit.create(RandomUserApi::class.java)
    }

    @Provides
    fun provideRandomUserDao(db: ShiftDatabase) = db.randomUserDao()

    @Provides
    fun provideRemoteKeysDao(db: ShiftDatabase) = db.remoteKeysDao()

    @Provides
    fun providePrefs(@ApplicationContext context: Context) = PreferenceManager(context)

    @Provides
    fun provideRandomUserRepository(
        db: ShiftDatabase,
        api: RandomUserApi,
        prefs: PreferenceManager
    ): RandomUserRepository = RandomUserRepositoryImpl(
        api = api,
        prefs = prefs,
        db = db
    )
}