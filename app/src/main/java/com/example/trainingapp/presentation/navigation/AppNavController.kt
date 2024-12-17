package com.example.trainingapp.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trainingapp.core.Constants
import com.example.trainingapp.presentation.screens.dashboardScreen.DashboardScreen
import com.example.trainingapp.presentation.screens.detailScreen.DetailScreen
import com.example.trainingapp.presentation.screens.homeScreen.HomeScreen
import com.example.trainingapp.presentation.screens.landingScreen.LandingScreen
import com.example.trainingapp.presentation.screens.loginScreen.LoginScreen
import com.example.trainingapp.presentation.screens.otpScreen.OTPScreen
import com.example.trainingapp.presentation.screens.splashScreen.SplashScreen
import com.example.trainingapp.presentation.screens.webViewScreen.WebViewScreen
import com.example.trainingapp.utils.CommonUtils
import com.example.trainingapp.utils.SecureSharedPreference

/**
 * App nav controller
 *
 */
@Composable
fun AppNavController() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val startDestination =
        if (SecureSharedPreference(context).getBoolean(Constants.PREF_IS_LOGGED_IN)) {
            ScreenName.DASHBOARD_SCREEN
        } else {
            ScreenName.SPLASH_SCREEN
        }
    NavHost(navController = navController, startDestination = startDestination) {

        // SPLASH SCREEN
        composable(route = ScreenName.SPLASH_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                SplashScreen {
                    navController.navigate(ScreenName.LANDING_SCREEN) {
                        // Remove splash_screen from the stack
                        popUpTo(ScreenName.SPLASH_SCREEN) {
                            inclusive = true
                        }
                    }
                }
            }
        }

        // LANDING SCREEN
        composable(route = ScreenName.LANDING_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                LandingScreen {
                    navController.navigate(ScreenName.LOGIN_SCREEN)
                }
            }
        }

        // LOGIN SCREEN
        composable(route = ScreenName.LOGIN_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                LoginScreen(gotoPrivacyPolicy = { navController.navigate(ScreenName.WEB_VIEW_SCREEN) },
                    gotoOTP = { navController.navigate(ScreenName.OTP_SCREEN) })
            }
        }

        // OTP SCREEN
        composable(route = ScreenName.OTP_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                OTPScreen { navController.navigate(ScreenName.DASHBOARD_SCREEN) }
            }
        }

        // WEB_VIEW SCREEN
        composable(route = ScreenName.WEB_VIEW_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                WebViewScreen(url = CommonUtils.PRIVACY_POLICY_URL)
            }
        }

        // DASHBOARD SCREEN
        composable(route = ScreenName.DASHBOARD_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                DashboardScreen(
                    gotoProfile = {
                        navController.navigate(ScreenName.PROFILE_SCREEN) {
                            popUpTo(ScreenName.DASHBOARD_SCREEN) { inclusive = true }
                        }
                    },
                    performLogout = {
                        CommonUtils.logout(
                            context = context,
                            navController = navController
                        )
                    }
                )
            }
        }

        // HOME SCREEN
        composable(route = ScreenName.HOME_SCREEN) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                HomeScreen { id ->
                    navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
                }
            }
        }

        // DETAIL SCREEN
        composable(
            route = ScreenName.DETAIL_SCREEN + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            AnimatedVisibility(
                visible = true,
                enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut()
            ) {
                DetailScreen {
                    navController.popBackStack()
                }
            }
        }
    }
}