package io.github.onlyashd.bunny.ui.composable.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.ui.theme.Theme
import io.github.onlyashd.bunny.ui.theme.setAquaTheme
import io.github.onlyashd.bunny.ui.theme.setBrownTheme
import io.github.onlyashd.bunny.ui.theme.setEarthyTheme
import io.github.onlyashd.bunny.ui.theme.setGreenTheme
import io.github.onlyashd.bunny.ui.theme.setPinkTheme
import io.github.onlyashd.bunny.ui.theme.setPurpleTheme
import io.github.onlyashd.bunny.ui.theme.setYellowTheme
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.composable.typography
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun ThemePicker(viewModel: MainViewModel? = hiltViewModel()) {
    val current = viewModel!!.stateApp.theme

    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme().background)
                .padding(8.dp)
        ) {
            val (titleRef, rowRef) = createRefs()

            Text(
                text = R.string.theme.getString(),
                style = typography().titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorScheme().onBackground,
                modifier = Modifier.constrainAs(titleRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .constrainAs(rowRef) {
                        start.linkTo(parent.start)
                        top.linkTo(titleRef.bottom, 16.dp)
                    },
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                ThemeCard(R.string.theme_aqua.getString(), Theme.Aqua, current) {
                    setAquaTheme(viewModel)
                }

                ThemeCard(R.string.theme_brown.getString(), Theme.Brown, current) {
                    setBrownTheme(viewModel)
                }

                ThemeCard(R.string.theme_earthy.getString(), Theme.Earthy, current) {
                    setEarthyTheme(viewModel)
                }

                ThemeCard(R.string.theme_green.getString(), Theme.Green, current) {
                    setGreenTheme(viewModel)
                }

                ThemeCard(R.string.theme_pink.getString(), Theme.Pink, current) {
                    setPinkTheme(viewModel)
                }

                ThemeCard(R.string.theme_purple.getString(), Theme.Purple, current) {
                    setPurpleTheme(viewModel)
                }

                ThemeCard(R.string.theme_yellow.getString(), Theme.Yellow, current) {
                    setYellowTheme(viewModel)
                }
            }
        }

        HorizontalDivider()
    }
}

@Composable
private fun ThemeCard(
    label: String,
    theme: Theme,
    current: Theme,
    onClick: () -> Unit,
) {

    OutlinedButton(
        onClick = { onClick() },
        shape = CardDefaults.elevatedShape,
        border = if (current.sample == theme.sample) BorderStroke(
            1.dp,
            colorScheme().onBackground
        ) else null
    ) {
        ConstraintLayout {
            val (colorRef, labelRef) = createRefs()

            ElevatedCard(
                modifier = Modifier
                    .size(48.dp)
                    .constrainAs(colorRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                colors = CardColors(
                    containerColor = theme.sample,
                    contentColor = theme.sample,
                    disabledContainerColor = theme.sample,
                    disabledContentColor = theme.sample
                )
            ) { }
            Text(
                text = label,
                style = typography().bodySmall,
                color = colorScheme().onBackground,
                modifier = Modifier.constrainAs(labelRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(colorRef.bottom)
                }
            )
        }
    }
}
