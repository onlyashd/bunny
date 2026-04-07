package io.github.onlyashd.bunny.ui.theme

import androidx.compose.ui.graphics.Color
import io.github.onlyashd.bunny.ui.theme.themes.BrownTheme
import io.github.onlyashd.bunny.ui.theme.themes.AquaTheme
import io.github.onlyashd.bunny.ui.theme.themes.EarthyTheme
import io.github.onlyashd.bunny.ui.theme.themes.GreenTheme
import io.github.onlyashd.bunny.ui.theme.themes.PinkTheme
import io.github.onlyashd.bunny.ui.theme.themes.PurpleTheme
import io.github.onlyashd.bunny.ui.theme.themes.YellowTheme

enum class Theme(val sample: Color) {
    Aqua(AquaTheme.sample),
    Brown(BrownTheme.sample),
    Earthy(EarthyTheme.sample),
    Green(GreenTheme.sample),
    Pink(PinkTheme.sample),
    Purple(PurpleTheme.sample),
    Yellow(YellowTheme.sample),
}