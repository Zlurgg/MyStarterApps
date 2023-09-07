package com.example.mystarterapps.feature_todo_list

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mystarterapps.feature_todo_list.common.util.Routes
import com.example.mystarterapps.feature_todo_list.presentation.add_edit_todo.AddEditTodoScreen
import com.example.mystarterapps.feature_todo_list.presentation.todo_list.TodoListScreen

@Composable
fun TodoApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.TODO_LIST,
        builder = {
            composable(route = Routes.TODO_LIST) {
                TodoListScreen(onNavigate = {
                    navController.navigate(it.route)
                })
            }
            composable(
                route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                arguments = listOf(
                    navArgument(name = "todoId") {
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ) {
                AddEditTodoScreen(onPopBackStack = {
                    navController.popBackStack()
                })
            }
        })
}
