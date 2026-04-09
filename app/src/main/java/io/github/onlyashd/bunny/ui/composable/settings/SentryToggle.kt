package io.github.onlyashd.bunny.ui.composable.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.github.onlyashd.bunny.R
import io.github.onlyashd.bunny.core.MainViewModel
import io.github.onlyashd.bunny.observability.SentryViewModel
import io.github.onlyashd.bunny.util.composable.colorScheme
import io.github.onlyashd.bunny.util.composable.shapes
import io.github.onlyashd.bunny.util.composable.typography
import io.github.onlyashd.bunny.util.extensions.getDrawable
import io.github.onlyashd.bunny.util.extensions.getString

@Composable
fun SentryToggle(
    onInfoClick: () -> Unit,
    sentryViewModel: SentryViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme().background)
                .padding(8.dp)
        ) {
            val (
                titleRef,
                infoRef,
                toggleRef
            ) = createRefs()

            Text(
                text = R.string.sentry_title.getString(),
                style = typography().titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorScheme().onBackground,
                modifier = Modifier.constrainAs(titleRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            IconButton(
                onClick = { onInfoClick() },
                modifier = Modifier.constrainAs(infoRef) {
                    end.linkTo(parent.end)
                    top.linkTo(titleRef.top)
                    bottom.linkTo(toggleRef.bottom)
                }
            ) {
                Icon(
                    painter = R.drawable.info.getDrawable(),
                    contentDescription = R.string.info.getString(),
                )
            }

            Switch(
                checked = mainViewModel.stateApp.sentryState,
                onCheckedChange = { sentryViewModel.toggleSentry() },
                modifier = Modifier.constrainAs(toggleRef) {
                    start.linkTo(parent.start)
                    top.linkTo(titleRef.bottom)
                }
            )
        }

        HorizontalDivider()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SentryDetailsDialog(
    showOnHide: Boolean = false,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onHide: () -> Unit = {},
) {
    BasicAlertDialog(onDismissRequest = { onDismiss() }) {
        Surface(shape = shapes().large) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorScheme().background)
                    .padding(8.dp)
            ) {
                val (
                    titleRef,
                    descRef,
                    dismissBtnRef,
                    enableBtnRef,
                    dontShowAgainRef,
                ) = createRefs()

                Text(
                    text = R.string.sentry_dialog_title.getString(),
                    style = typography().titleMedium,
                    color = colorScheme().onBackground,
                    modifier = Modifier.constrainAs(titleRef) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                )

                Text(
                    text = AnnotatedString.fromHtml(R.string.sentry_dialog_description.getString()),
                    style = typography().bodyMedium,
                    color = colorScheme().onBackground,
                    modifier = Modifier.constrainAs(descRef) {
                        start.linkTo(parent.start)
                        top.linkTo(titleRef.bottom, 8.dp)
                        end.linkTo(parent.end)
                    }
                )

                OutlinedButton(
                    onClick = { onClick() },
                    border = null,
                    modifier = Modifier.constrainAs(enableBtnRef) {
                        top.linkTo(descRef.bottom, 8.dp)
                        end.linkTo(parent.end)
                    }
                ) {
                    Text(
                        text = R.string.enable.getString(),
                        style = typography().bodyMedium,
                        color = colorScheme().onSurface,
                    )
                }

                OutlinedButton(
                    onClick = { onDismiss() },
                    border = null,
                    modifier = Modifier.constrainAs(dismissBtnRef) {
                        top.linkTo(enableBtnRef.bottom, 4.dp)
                        end.linkTo(parent.end)
                    }
                ) {
                    Text(
                        text = R.string.dismiss.getString(),
                        style = typography().bodyMedium,
                        color = colorScheme().onSurface,
                    )
                }

                if (showOnHide) {
                    OutlinedButton(
                        onClick = {
                            onHide()
                            onDismiss()
                        },
                        border = null,
                        modifier = Modifier.constrainAs(dontShowAgainRef) {
                            top.linkTo(dismissBtnRef.bottom, 4.dp)
                            end.linkTo(parent.end)
                        }
                    ) {
                        Text(
                            text = R.string.dont_show_again.getString(),
                            style = typography().bodyMedium,
                            color = colorScheme().onSurface,
                        )
                    }
                }
            }
        }
    }
}