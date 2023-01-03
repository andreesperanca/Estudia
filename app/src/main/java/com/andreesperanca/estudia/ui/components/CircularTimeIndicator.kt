package com.andreesperanca.estudia.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit


@Composable
fun CircularTimeIndicator(
    /** CANVAS */
    canvasSize: Dp,
    backgroundIndicatorColor: Color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
    backgroundIndicatorStrokeWidth: Float = (canvasSize / 50.dp),
    foregroundIndicatorColor: Color = MaterialTheme.colors.primary,
    foregroundIndicatorStrokeWidth: Float = (canvasSize / 50.dp),
    titleText: String = stringResource(id = R.string.study),
    titleTextColor: Color = MaterialTheme.colors.onSurface.copy(0.4f),
    titleTextStyle: TextStyle = MaterialTheme.typography.h5,
    timeTextStyle: TextStyle = MaterialTheme.typography.h6,
    timeTextColor: Color = MaterialTheme.colors.primary,

    /** Parâmetros */
    totalTime: Long,

    /** Play Button */
    configButtonClick: () -> Unit,
    changeStateButtonClick: () -> Unit,

    /** Time is over */
    timeIsOver: () -> Unit,
    automaticPreference: Boolean
) {
    var value by rememberSaveable {
        mutableStateOf(0f)
    }

    var currentTime by rememberSaveable {
        mutableStateOf(0f)
    }

    var isTimerRunning by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (isTimerRunning) {
            if (currentTime > totalTime) {
                currentTime = 0f
                isTimerRunning = false
                timeIsOver()
                value = 0f
                if (automaticPreference) {
                    isTimerRunning = true
                }
            }
            delay(1000)
            currentTime += 1f
            value = currentTime / totalTime
        }
    }

    val sweepAngle by animateFloatAsState(
        targetValue = value,
        animationSpec = tween(1000)
    )

    val widthLocal = LocalConfiguration.current.screenWidthDp.dp
    val heightLocal = LocalConfiguration.current.screenHeightDp.dp

    val screenLying = heightLocal > widthLocal

    if (screenLying) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .size(canvasSize)
                    .drawBehind {
                        val componentSize = size / 1.2f
                        backgroundIndicator(
                            componentSize = componentSize,
                            indicatorColor = backgroundIndicatorColor,
                            indicatorStrokeWith = backgroundIndicatorStrokeWidth
                        )
                        foregroundIndicator(
                            sweepAngle = (sweepAngle * 360),
                            componentSize = componentSize,
                            indicatorColor = foregroundIndicatorColor,
                            indicatorStrokeWith = foregroundIndicatorStrokeWidth
                        )
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DescriptionCircularTimeIndicator(
                    titleText = titleText,
                    titleTextColor = titleTextColor,
                    titleTextStyle = titleTextStyle,
                    timeTextStyle = timeTextStyle,
                    timeTextColor = timeTextColor,
                    currentTime = timeConverter(currentTime.toLong())
                )
            }

            HorizontalControlPanel(
                playButtonClick = {
                    isTimerRunning = if (currentTime <= 0L) {
                        true
                    } else {
                        !isTimerRunning
                    }
                },
                playButtonPainter = if (isTimerRunning) {
                    painterResource(id = R.drawable.ic_pause)
                } else {
                    painterResource(id = R.drawable.ic_play)
                },
                changeStateButtonClick = {
                    value = 0f
                    currentTime = 0f
                    isTimerRunning = false
                    changeStateButtonClick()
                },
                configButtonClick = { configButtonClick() }
            )

        }
    }
    else {
        Row(
            verticalAlignment =  Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .size(canvasSize)
                    .drawBehind {
                        val componentSize = size / 1.2f
                        backgroundIndicator(
                            componentSize = componentSize,
                            indicatorColor = backgroundIndicatorColor,
                            indicatorStrokeWith = backgroundIndicatorStrokeWidth
                        )
                        foregroundIndicator(
                            sweepAngle = (sweepAngle * 360),
                            componentSize = componentSize,
                            indicatorColor = foregroundIndicatorColor,
                            indicatorStrokeWith = foregroundIndicatorStrokeWidth
                        )
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DescriptionCircularTimeIndicator(
                    titleText = titleText,
                    titleTextColor = titleTextColor,
                    titleTextStyle = titleTextStyle,
                    timeTextStyle = timeTextStyle,
                    timeTextColor = timeTextColor,
                    currentTime = timeConverter(currentTime.toLong())
                )
            }

            VerticalControlPanel(
                playButtonClick = {
                    isTimerRunning = if (currentTime <= 0L) {
                        true
                    } else {
                        !isTimerRunning
                    }
                },
                playButtonPainter = if (isTimerRunning) {
                    painterResource(id = R.drawable.ic_pause)
                } else {
                    painterResource(id = R.drawable.ic_play)
                },
                changeStateButtonClick = {
                    value = 0f
                    currentTime = 0f
                    isTimerRunning = false
                    changeStateButtonClick()
                },
                configButtonClick = { configButtonClick() }
            )

        }
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWith: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWith,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWith: Float
) {

    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 180f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWith,
            cap = StrokeCap.Butt
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        ),
    )
}

@Composable
fun DescriptionCircularTimeIndicator(
    titleText: String,
    titleTextColor: Color,
    titleTextStyle: TextStyle,
    timeTextStyle: TextStyle,
    timeTextColor: Color,
    currentTime: String
) {
    Text(
        text = titleText,
        color = titleTextColor,
        style = titleTextStyle,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = currentTime.toString(),
        color = timeTextColor,
        style = timeTextStyle,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}


@Preview
@Composable()
fun PreviewCircularTimeIndicator() {
    EstudiaTheme {
        CircularTimeIndicator(
            totalTime = 100,
            configButtonClick = {},
            changeStateButtonClick = {},
            timeIsOver = {},
            automaticPreference = true,
            canvasSize = 300.dp
        )
    }
}

fun timeConverter(time: Long): String {
    val minutes = TimeUnit.SECONDS.toMinutes(time)
    var minutesString: String = ""
    var secondsString: String = ""

    minutesString = if (minutes < 10) {
        "0$minutes"
    } else {
        "$minutes"
    }

    val seconds = (time % 60)
    secondsString = if (seconds < 10) {
        "0$seconds"
    } else {
        "$seconds"
    }

    return "$minutesString:$secondsString"
}






