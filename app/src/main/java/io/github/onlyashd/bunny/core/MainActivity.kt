package io.github.onlyashd.bunny.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.onlyashd.bunny.ui.composable.BottomBar
import io.github.onlyashd.bunny.ui.composable.NavigationStack
import io.github.onlyashd.bunny.ui.composable.TopBar
import io.github.onlyashd.bunny.ui.theme.AppTheme
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.paperdb.Paper
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: Provider<MainViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(this)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            AppTheme(viewModel.get().stateApp.theme) {
                Scaffold(
                    contentWindowInsets = WindowInsets.safeContent,
                    topBar = { TopBar(viewModel.get().stateApp.toolbarTitle, navController) },
                    bottomBar = { BottomBar(navController) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = colorScheme().background
                    ) {
                        NavigationStack(navController)
                    }
                }
            }
        }
    }
}
