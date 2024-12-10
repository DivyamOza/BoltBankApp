package com.example.trainingapp.presentation.screens.dashboardScreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainingapp.R
import com.example.trainingapp.presentation.components.AppText

/**
 * Credit card front
 *
 * @param cardNumber
 * @param cardHolderName
 * @param expiryDate
 * @param backgroundDrawable
 */
@Composable
fun CreditCardFront(
    cardNumber: String,
    cardHolderName: String,
    expiryDate: String,
    @DrawableRes backgroundDrawable: Int,
    isBlue: Boolean = true
) {
    val timesNewRoman = FontFamily(
        Font(resId = R.font.times_new_roman, weight = FontWeight.Normal),
    )
    val blueListGradient = listOf(Color.Blue, Color.Blue.copy(alpha = 0.5f))
    val greenListGradient = listOf(Color(0xFF4CAF50), Color(0xFF2E7D32))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .aspectRatio(1.6f)
            .background(
                brush = Brush.horizontalGradient(
                    colors = if (isBlue) blueListGradient else greenListGradient
                )
            )

    ) {
        Image(
            painter = painterResource(id = backgroundDrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Crop the image to fit the background
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .graphicsLayer(alpha = 0.6f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                AppText(
                    text = "Debit Card".uppercase(),
                    color = Color.White,
                    isBold = true,
                    fontSize = 20
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_nfc),
                    contentDescription = "Card Chip",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_card_chip),
                contentDescription = "Card Chip",
                modifier = Modifier.size(50.dp)
            )
            AppText(
                text = cardNumber,
                fontSize = 22,
                color = Color.White,
                isBold = true,
                fontFamily = timesNewRoman,
                letterSpacing = 2f
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                AppText(
                    text = cardHolderName,
                    fontSize = 24,
                    color = Color.White,
                    fontFamily = timesNewRoman,
                )
                Column {
                    AppText(
                        text = "Valid up to",
                        fontSize = 8,
                        color = Color.White,
                        isThin = true,
                        fontFamily = timesNewRoman,
                    )
                    AppText(
                        text = expiryDate,
                        fontSize = 15,
                        color = Color.White,
                        isThin = true,
                        fontFamily = timesNewRoman,
                    )
                }
            }
        }
    }
}


/**
 * Credit card back
 *
 * @param cvv
 * @param backgroundColor
 */
@Composable
fun CreditCardBack(
    cvv: String, backgroundColor: Color = Color(0xFF455A64)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .aspectRatio(1.6f)
            .background(backgroundColor)
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(38.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = cvv,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(horizontal = 10.dp),
                    style = TextStyle(fontStyle = FontStyle.Italic)
                )
            }
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                color = Color.White,
                modifier = Modifier.padding(15.dp),
                style = TextStyle(
                    fontStyle = FontStyle.Normal, fontWeight = FontWeight.Thin, fontSize = 8.sp
                )
            )
        }
    }
}
