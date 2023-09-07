package com.example.mystarterapps.feature_todo_list.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun getTodoById(id: Int): Todo?
    fun getTodos(): Flow<List<Todo>>
}