import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * App switch
 *
 * @param isChecked
 * @param onCheckedChange
 * @param modifier
 * @receiver
 */
@Composable
fun AppSwitch(
    isChecked: MutableState<Boolean>,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Switch(
        checked = isChecked.value,
        onCheckedChange = { isCheckedValue ->
            isChecked.value = isCheckedValue
            onCheckedChange(isCheckedValue)
        },
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Color(0xFF34C759),
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color(0xFFBDBDBD)
        )
    )
}

@Composable
fun SwitchDemo() {
    val isChecked = rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("iOS Style Switch")
        AppSwitch(isChecked = isChecked, onCheckedChange = { _ ->
            // Handle the change here if needed
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwitchDemo()
}
