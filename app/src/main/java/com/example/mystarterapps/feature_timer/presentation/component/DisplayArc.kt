package com.example.mystarterapps.feature_timer.presentation.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import java.lang.Math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun TimerArc(
    modifier: Modifier,
    inactiveBarColor: Color,
    activeBarColor: Color,
    size: IntSize,
    strokeWidth: Dp,
    value: Float,
    handleColor: Color
) {
    Canvas(modifier = modifier) {
        drawArc(
            color = inactiveBarColor,
            startAngle = -215f,
            sweepAngle = 250f,
            useCenter = false,
            size = Size(size.width.toFloat(), size.height.toFloat()),
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
        )
        drawArc(
            color = activeBarColor,
            startAngle = -215f,
            sweepAngle = 250f * value,
            useCenter = false,
            size = Size(size.width.toFloat(), size.height.toFloat()),
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
        )
        val center = Offset(size.width / 2f, size.height / 2f)
        val beta = (250f * value + 145f) * (PI / 180f).toFloat()
        val radius = size.width / 2f
        val sideA = cos(beta) * radius
        val sideB= sin(beta) * radius

        drawPoints(
            listOf(Offset(center.x + sideA, center.y + sideB)),
            pointMode = PointMode.Points,
            color = handleColor,
            strokeWidth = (strokeWidth * 3f).toPx(),
            cap = StrokeCap.Round
        )
    }
}