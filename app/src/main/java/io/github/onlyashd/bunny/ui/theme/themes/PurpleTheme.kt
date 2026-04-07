package io.github.onlyashd.bunny.ui.theme.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

class PurpleTheme {
    private val primaryLight = Color(0xFF67558E)
    private val onPrimaryLight = Color(0xFFFFFFFF)
    private val primaryContainerLight = Color(0xFFEADDFF)
    private val onPrimaryContainerLight = Color(0xFF4E3D75)
    private val secondaryLight = Color(0xFF625B70)
    private val onSecondaryLight = Color(0xFFFFFFFF)
    private val secondaryContainerLight = Color(0xFFE9DEF8)
    private val onSecondaryContainerLight = Color(0xFF4A4358)
    private val tertiaryLight = Color(0xFF7E525E)
    private val onTertiaryLight = Color(0xFFFFFFFF)
    private val tertiaryContainerLight = Color(0xFFFFD9E1)
    private val onTertiaryContainerLight = Color(0xFF643B47)
    private val errorLight = Color(0xFFBA1A1A)
    private val onErrorLight = Color(0xFFFFFFFF)
    private val errorContainerLight = Color(0xFFFFDAD6)
    private val onErrorContainerLight = Color(0xFF93000A)
    private val backgroundLight = Color(0xFFFEF7FF)
    private val onBackgroundLight = Color(0xFF1D1B20)
    private val surfaceLight = Color(0xFFFEF7FF)
    private val onSurfaceLight = Color(0xFF1D1B20)
    private val surfaceVariantLight = Color(0xFFE7E0EB)
    private val onSurfaceVariantLight = Color(0xFF49454E)
    private val outlineLight = Color(0xFF7A757F)
    private val outlineVariantLight = Color(0xFFCBC4CF)
    private val scrimLight = Color(0xFF000000)
    private val inverseSurfaceLight = Color(0xFF322F35)
    private val inverseOnSurfaceLight = Color(0xFFF5EFF7)
    private val inversePrimaryLight = Color(0xFFD1BCFD)
    private val surfaceDimLight = Color(0xFFDED8E0)
    private val surfaceBrightLight = Color(0xFFFEF7FF)
    private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    private val surfaceContainerLowLight = Color(0xFFF8F1FA)
    private val surfaceContainerLight = Color(0xFFF2ECF4)
    private val surfaceContainerHighLight = Color(0xFFECE6EE)
    private val surfaceContainerHighestLight = Color(0xFFE7E0E8)

    private val primaryDark = Color(0xFFD1BCFD)
    private val onPrimaryDark = Color(0xFF37265C)
    private val primaryContainerDark = Color(0xFF4E3D75)
    private val onPrimaryContainerDark = Color(0xFFEADDFF)
    private val secondaryDark = Color(0xFFCCC2DB)
    private val onSecondaryDark = Color(0xFF342D41)
    private val secondaryContainerDark = Color(0xFF4A4358)
    private val onSecondaryContainerDark = Color(0xFFE9DEF8)
    private val tertiaryDark = Color(0xFFF0B8C6)
    private val onTertiaryDark = Color(0xFF4A2531)
    private val tertiaryContainerDark = Color(0xFF643B47)
    private val onTertiaryContainerDark = Color(0xFFFFD9E1)
    private val errorDark = Color(0xFFFFB4AB)
    private val onErrorDark = Color(0xFF690005)
    private val errorContainerDark = Color(0xFF93000A)
    private val onErrorContainerDark = Color(0xFFFFDAD6)
    private val backgroundDark = Color(0xFF141218)
    private val onBackgroundDark = Color(0xFFE7E0E8)
    private val surfaceDark = Color(0xFF141218)
    private val onSurfaceDark = Color(0xFFE7E0E8)
    private val surfaceVariantDark = Color(0xFF49454E)
    private val onSurfaceVariantDark = Color(0xFFCBC4CF)
    private val outlineDark = Color(0xFF948F99)
    private val outlineVariantDark = Color(0xFF49454E)
    private val scrimDark = Color(0xFF000000)
    private val inverseSurfaceDark = Color(0xFFE7E0E8)
    private val inverseOnSurfaceDark = Color(0xFF322F35)
    private val inversePrimaryDark = Color(0xFF67558E)
    private val surfaceDimDark = Color(0xFF141218)
    private val surfaceBrightDark = Color(0xFF3B383E)
    private val surfaceContainerLowestDark = Color(0xFF0F0D13)
    private val surfaceContainerLowDark = Color(0xFF1D1B20)
    private val surfaceContainerDark = Color(0xFF211F24)
    private val surfaceContainerHighDark = Color(0xFF2B292F)
    private val surfaceContainerHighestDark = Color(0xFF36343A)

    private val lightScheme = lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

    private val darkScheme = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

    companion object {
        val lightScheme = PurpleTheme().lightScheme
        val darkScheme = PurpleTheme().darkScheme
        val sample = PurpleTheme().primaryLight
    }
}