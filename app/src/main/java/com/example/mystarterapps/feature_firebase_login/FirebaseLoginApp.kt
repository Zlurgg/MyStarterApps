import android.app.appsearch.AppSearchResult.RESULT_OK
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystarterapps.feature_firebase_login.presentation.sign_in.GoogleAuthUiClient
import com.example.mystarterapps.feature_firebase_login.presentation.sign_in.SignInScreen
import com.example.mystarterapps.feature_firebase_login.presentation.sign_in.SignInViewModel
import com.google.android.gms.auth.api.identity.Identity

@Composable
fun FirebaseLoginApp() {
    val applicationContext = LocalContext.current
    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "sign_in") {
            composable("sign_in") {
                val viewModel = viewModel<SignInViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit) {
                    if (googleAuthUiClient.getSignedInUser() != null) {
                        navController.navigate("profile")
                    }
                }

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if (result.resultCode == RESULT_OK) {
//                            lifecycleScope.launch {
//                                val signInResult = googleAuthUiClient.signInWithIntent(
//                                    intent = result.data ?: return@launch
//                                )
//                                viewModel.onSignInResult(signInResult)
//                            }
                        }
                    }
                )

                LaunchedEffect(key1 = state.isSignInSuccessful) {
                    if (state.isSignInSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Sign in successful",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate("profile")
                        viewModel.resetState()
                    }
                }

                SignInScreen(
                    state = state,
                    onSignInClick = {
//                        lifecycleScope.launch {
//                            val signInIntentSender = googleAuthUiClient.signIn()
//                            launcher.launch(
//                                IntentSenderRequest.Builder(
//                                    signInIntentSender ?: return@launch
//                                ).build()
//                            )
//                        }
                    }
                )
            }
//            composable("profile") {
//                ProfileScreen(
//                    userData = googleAuthUiClient.getSignedInUser(),
//                    onSignOut = {
//                        lifecycleScope.launch {
//                            googleAuthUiClient.signOut()
//                            Toast.makeText(
//                                applicationContext,
//                                "Signed out",
//                                Toast.LENGTH_LONG
//                            ).show()
//
//                            navController.popBackStack()
//                        }
//                    }
//                )
//            }
        }
    }
}

