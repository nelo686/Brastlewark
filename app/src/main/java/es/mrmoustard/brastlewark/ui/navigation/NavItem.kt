package es.mrmoustard.brastlewark.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NavArg> = emptyList()
) {
    val route = run {
        //baseroute/{arg1}/{arg2}
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString(separator = "/")
    }

    val args = navArgs.map {
        navArgument(it.key) {type = it.navType }
    }

    object Main: NavItem(baseRoute = "main")
    object Detail: NavItem(baseRoute = "detail", listOf(NavArg.GnomeId)) {
        fun buildNavRoute(gnomeId: Int) = "$baseRoute/$gnomeId"
    }
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    GnomeId(key = "gnomeId", navType = NavType.IntType)
}