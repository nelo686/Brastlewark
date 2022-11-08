package es.mrmoustard.brastlewark.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.mrmoustard.brastlewark.ui.screen.detail.DetailScreen
import es.mrmoustard.brastlewark.ui.screen.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(NavItem.Main) {
            MainScreen { item ->
                navController.navigate(route =
                NavItem.Detail.buildNavRoute(gnomeId = item.id))
            }
        }
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                itemId = backStackEntry.findArg(NavArg.GnomeId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}