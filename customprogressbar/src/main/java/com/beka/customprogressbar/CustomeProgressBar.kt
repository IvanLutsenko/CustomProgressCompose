package com.beka.customprogressbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomProgressWithPercent(
    modifier: Modifier = Modifier,
    strokeColor: Color = Color.Blue,
    strokeWidth: Int = 3,
    curValue: Int = 500,
    maxValue: Int = 1000,
    size: Int = 150,
    txtStyle: SpanStyle =
        SpanStyle(
            color = Color.Black,
            fontSize = 22.sp
        )
) {

    val angle = (curValue * 360) / maxValue
    val percent = (curValue * 100) / maxValue

    val textMeasurer = rememberTextMeasurer()

    val angleText = buildAnnotatedString {
        withStyle(
            style = txtStyle
        ) {
            append("$percent%")
        }
    }

    val angleTxtSize = textMeasurer.measure(angleText).size

    Canvas(
        modifier = modifier
            .size(size.dp)
    ) {
        drawArc(
            color = strokeColor,
            startAngle = -90f,
            sweepAngle = angle.toFloat(),
            useCenter = false,
            style = Stroke(
                width = strokeWidth.dp.toPx()
            )
        )

        drawText(
            textMeasurer = textMeasurer,
            text = angleText,
            topLeft = Offset(center.x - angleTxtSize.width / 2, center.y - angleTxtSize.height / 2)
        )

    }
}