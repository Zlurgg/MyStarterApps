package com.example.mystarterapps.feature_todo_list.di

import android.app.Application
import androidx.room.Room
import com.example.mystarterapps.feature_todo_list.data.TodoDatabase
import com.example.mystarterapps.feature_todo_list.data.TodoRepository
import com.example.mystarterapps.feature_todo_list.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}