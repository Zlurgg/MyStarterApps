package com.example.mystarterapps.feature_note.di

import android.app.Application
import androidx.room.Room
import com.example.mystarterapps.feature_note.data.data_source.NoteDatabase
import com.example.mystarterapps.feature_note.data.repository.NoteRepositoryImpl
import com.example.mystarterapps.feature_note.domain.repository.NoteRepository
import com.example.mystarterapps.feature_note.domain.use_case.AddNote
import com.example.mystarterapps.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.mystarterapps.feature_note.domain.use_case.GetNote
import com.example.mystarterapps.feature_note.domain.use_case.GetNotesUseCase
import com.example.mystarterapps.feature_note.domain.use_case.NoteUseCases
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
    fun provideNoteDatabase(app: Application): com.example.mystarterapps.feature_note.data.data_source.NoteDatabase {
        return Room.databaseBuilder(
            app,
            com.example.mystarterapps.feature_note.data.data_source.NoteDatabase::class.java,
            com.example.mystarterapps.feature_note.data.data_source.NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: com.example.mystarterapps.feature_note.data.data_source.NoteDatabase): com.example.mystarterapps.feature_note.domain.repository.NoteRepository {
        return com.example.mystarterapps.feature_note.data.repository.NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: com.example.mystarterapps.feature_note.domain.repository.NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository = noteRepository),
            deleteNote = DeleteNoteUseCase(repository = noteRepository),
            addNote = com.example.mystarterapps.feature_note.domain.use_case.AddNote(repository = noteRepository),
            getNote = GetNote(repository = noteRepository)
        )
    }
}