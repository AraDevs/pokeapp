package com.aradevs.pokeapp.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.ui.theme.borderGray

@Composable
fun PokemonSearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    maxLines: Int = 1,
    onSearch: (String) -> Unit = {}
) {

    val focusManager = LocalFocusManager.current
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Card(modifier = modifier, shape = RoundedCornerShape(10.dp)) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 8.dp),
                value = text,
                maxLines = maxLines,
                singleLine = maxLines == 1,
                textStyle = TextStyle(color = MaterialTheme.colorScheme.inverseOnSurface),
                onValueChange = {
                    text = it
                },
                keyboardActions = KeyboardActions(
                    onDone = {
                        onSearch(text.text)
                        focusManager.clearFocus()
                    }
                ),
                decorationBox = { innerTextField ->
                    if (text.text.isEmpty()) {
                        Text(hint, color = MaterialTheme.colorScheme.onSurface)
                    }
                    // <-- Add this
                    innerTextField()
                }
            )
            Button(
                modifier = Modifier.size(27.dp),
                shape = CircleShape,
                onClick = {
                    onSearch(text.text)
                },
                contentPadding = PaddingValues(4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PokemonSearchBarPreview() {
    PokeappTheme {
        PokemonSearchBar(
            modifier = Modifier
                .border(1.dp, borderGray, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(36.dp)
        )
    }
}