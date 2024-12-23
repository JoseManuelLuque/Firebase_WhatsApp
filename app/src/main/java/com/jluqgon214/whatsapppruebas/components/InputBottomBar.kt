package com.jluqgon214.whatsapppruebas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.whatsapppruebas.model.Mensaje
import com.jluqgon214.whatsapppruebas.data.WhatsAppViewModel
import com.jluqgon214.whatsapppruebas.ui.theme.ColorIconos
import com.jluqgon214.whatsapppruebas.ui.theme.ColorIconos2
import com.jluqgon214.whatsapppruebas.ui.theme.ColorTexto
import com.jluqgon214.whatsapppruebas.ui.theme.ColorTextoSecundario
import com.jluqgon214.whatsapppruebas.ui.theme.Cursor
import com.jluqgon214.whatsapppruebas.ui.theme.FondoInput
import com.jluqgon214.whatsapppruebas.ui.theme.VerdeLlamativo

@Composable
fun InputBottomBar(viewModel: WhatsAppViewModel, navController: NavController) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(50.dp))

        TextField(
            modifier = Modifier
                .weight(5f)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            value = viewModel.messageText.value,
            onValueChange = { viewModel.messageText.value = it },
            shape = shape,
            leadingIcon = {
                IconButton(
                    onClick = {
                        //TODO EMOJIS
                    },
                    modifier = Modifier.size(28.dp),
                    colors = IconButtonColors(
                        contentColor = ColorIconos2,
                        containerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = ColorIconos2
                    )
                ) {
                    Icon(
                        imageVector = Icons.Outlined.EmojiEmotions,
                        contentDescription = "EMOJIES"
                    )
                }
            },
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(16.dp),
                ) {
                    IconButton(
                        onClick = {
                            //TODO EMOJIS
                        },
                        modifier = Modifier.size(28.dp),
                        colors = IconButtonColors(
                            contentColor = ColorIconos2,
                            containerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = ColorIconos2
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AttachFile,
                            contentDescription = "EMOJIES"
                        )
                    }

                    if (viewModel.messageText.value.isEmpty()) {
                        IconButton(
                            onClick = {
                                //TODO EMOJIS
                            },
                            modifier = Modifier.size(28.dp),
                            colors = IconButtonColors(
                                contentColor = ColorIconos2,
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = ColorIconos2
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.CameraAlt,
                                contentDescription = "Camera"
                            )
                        }
                    }

                }
            },
            placeholder = { Text("Mensaje") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = FondoInput,
                unfocusedContainerColor = FondoInput,
                focusedPlaceholderColor = ColorTextoSecundario,
                unfocusedPlaceholderColor = ColorTextoSecundario,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Cursor,
                focusedTextColor = ColorTexto,
                unfocusedTextColor = ColorTexto
            )
        )

        FloatingActionButton(
            content = {
                if (viewModel.messageText.value.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Outlined.Send,
                        contentDescription = "Send Message"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Mic,
                        contentDescription = "Audio"
                    )
                }

            },
            modifier = Modifier
                .weight(1f),
            onClick = {
                if (viewModel.messageText.value.isNotEmpty()) {
                    viewModel.agregarMensaje(
                        Mensaje(
                            viewModel.messageText.value,
                            viewModel.usuario,
                            viewModel.contactoActual.value!!.id
                        )
                    )
                    viewModel.messageText.value = ""
                } else {
                    //TODO RECORD AUDIO
                }
            },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            containerColor = VerdeLlamativo,
            contentColor = ColorIconos,
            shape = MaterialTheme.shapes.small.copy(CornerSize(50.dp))
        )
    }
}