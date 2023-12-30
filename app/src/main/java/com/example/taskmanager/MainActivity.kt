package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentBody()
                }
            }
        }
    }
}

@Composable
fun CheckmarkImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)

    Image(
        contentDescription = null,
        modifier = modifier,
        painter = image,
    )
}

@Composable
fun ContentBody(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CheckmarkImage(modifier = modifier)
        TasksRemainingText(modifier = modifier)
        PraiseText(modifier = modifier)
    }
}

@Composable
fun PraiseText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        fontSize = 16.sp,
        text = stringResource(R.string.praise_text),
    )
}

@Composable
fun TasksRemainingText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(bottom = 8.dp, top = 24.dp),
        fontWeight = FontWeight.Bold,
        text = stringResource(R.string.tasks_remaining_text),
    )
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        ContentBody()
    }
}