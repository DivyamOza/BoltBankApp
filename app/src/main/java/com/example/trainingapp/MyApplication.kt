package com.example.trainingapp

import android.app.Application
import androidx.room.Room
import com.example.trainingapp.data.local.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

/**
 * My application
 *
 * @constructor Create empty My application
 */
@HiltAndroidApp
class MyApplication : Application() {
    lateinit var database: AppDatabase
    //lateinit var repository: NoteRepository

    override fun onCreate() {
        super.onCreate()
        // TODO: NEEDS TO ADD TIMBER
        /*if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // For debug builds
        }*/

       /* database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()*/
        //repository = NoteRepository(database.noteDao())
    }
}