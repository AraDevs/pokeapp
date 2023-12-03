package com.aradevs.pokeapp.ui.home.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.ui.theme.AppFont
import com.aradevs.pokeapp.ui.theme.PokeappTheme

@Composable
fun ErrorContainer(modifier: Modifier = Modifier, onRetry: () -> Unit = {}) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.error_image),
            contentDescription = "Error image",
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Algo salio mal", fontFamily = AppFont.Montserrat,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.W700,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .padding(vertical = 5.dp),
            shape = CircleShape,
            onClick = onRetry,
            contentPadding = PaddingValues(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Reintentar", modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}

@Preview
@Composable
fun ErrorContainerPreview() {
    PokeappTheme {
        ErrorContainer()
    }
}