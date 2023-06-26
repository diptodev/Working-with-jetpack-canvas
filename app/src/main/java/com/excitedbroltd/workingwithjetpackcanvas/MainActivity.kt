package com.excitedbroltd.workingwithjetpackcanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.excitedbroltd.workingwithjetpackcanvas.ui.theme.WorkingWithJetpackCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkingWithJetpackCanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CanvasGraph()
                }
            }
        }
    }


}

@Composable
fun WorkingWithCanvas() {
    Canvas(modifier = Modifier
        .height(400.dp)
        .width(400.dp)
        .border(width = 0.dp, color = Color.Black), onDraw = {
        drawRect(
            color = Color.Cyan,
            size = Size(height = 400.dp.toPx(), width = 400.dp.toPx()),
            topLeft = Offset(
                x = 0f, y = 0f
            )
        )
        var mainWidth = size.width / 10f
        var msize = (size.width) / 9f
        drawRect(
            color = Color.Red,
            size = Size(height = 400.dp.toPx(), width = msize),
            topLeft = Offset(
                x = 0f, y = 0f
            )
        )
        drawRect(
            color = Color.Red,
            size = Size(height = 400.dp.toPx(), width = msize),
            topLeft = Offset(
                x = msize * 2f, y = 0f
            )
        )
        drawRect(
            color = Color.Red,
            size = Size(height = 400.dp.toPx(), width = msize),
            topLeft = Offset(
                x = msize * 3.6f, y = 0f
            )
        )

        drawRect(
            color = Color.Red,
            size = Size(height = 400.dp.toPx(), width = msize),
            topLeft = Offset(
                x = msize * 5.4f, y = 0f
            )
        )
        drawRect(
            color = Color.Red,
            size = Size(height = 400.dp.toPx(), width = msize),
            topLeft = Offset(
                x = msize * 7.2f, y = 0f
            )
        )

//        var divide = 0f
//        for (i in 0..4) {
//
//            drawRect(
//                color = Color.Red,
//                size = Size(height = 400.dp.toPx(), width = msize - 80),
//                topLeft = Offset(
//                    x = msize * i, y = 0f
//                )
//            )
//            divide += msize
//        }
    })
}


@Composable
fun CanvasGraph() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue.copy(alpha = .5f)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .aspectRatio(3 / 2f)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            drawRect(color = Color.LightGray, style = Stroke(width = 2.dp.toPx()))
            val verticalLines = 4;
            var verticalSize = size.width / (verticalLines + 1)

            repeat(verticalLines) { i ->
                val startX = verticalSize * (i + 1)
                drawLine(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    start = Offset(x = startX, 0f),
                    end = Offset(x = startX, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
            val horizontalLines = 3;
            var horizontalSize = size.height / (horizontalLines + 1)

            repeat(horizontalLines) { i ->
                val startY = horizontalSize * (i + 1)
                drawLine(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    start = Offset(x = 0f, startY),
                    end = Offset(x = size.width, startY),
                    strokeWidth = 2.dp.toPx()
                )
            }
            val brush =
                Brush.verticalGradient(listOf(Color.Green.copy(alpha = 0.4f), Color.Transparent))
            val path = Path()
            path.moveTo(x = 0f, y = horizontalSize * 4)
            path.lineTo(x = verticalSize * 1.1f, y = horizontalSize * 3.4f)
            path.lineTo(verticalSize * 1.8f, y = horizontalSize * 2)
            path.lineTo(x = verticalSize * 3.4f, y = horizontalSize * 1.5f)
            path.lineTo(x = verticalSize * 4.4f, y = horizontalSize * 0.5f)
            path.lineTo(x = verticalSize * 5f, y = horizontalSize * 0f)
            drawPath(path, style = Stroke(width = 2.dp.toPx()), color = Color.Green)
            path.lineTo(x = verticalSize * 5, y = horizontalSize * 4)
            path.close()
            drawPath(
                brush = brush,
                path = path,
                style = Fill
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkingWithJetpackCanvasTheme {
        CanvasGraph()
    }
}