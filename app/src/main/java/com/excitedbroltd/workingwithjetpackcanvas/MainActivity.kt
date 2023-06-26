package com.excitedbroltd.workingwithjetpackcanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
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
                    WorkingWithCanvas()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkingWithJetpackCanvasTheme {
        WorkingWithCanvas()
    }
}