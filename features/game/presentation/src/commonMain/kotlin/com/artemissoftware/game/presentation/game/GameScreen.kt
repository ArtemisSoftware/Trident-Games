@file:OptIn(ExperimentalMaterial3Api::class)

package com.artemissoftware.game.presentation.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit,
    onSearchClick: ()->Unit,
    onClick: (Int)-> Unit,
    viewModel: GameViewModel = koinViewModel<GameViewModel>()

) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    GameContent(
        modifier = modifier.fillMaxSize(),
        state = state.value,
        onFavoriteClick = onFavoriteClick,
        onSearchClick = onSearchClick,
        onClick = onClick
    )
}

@Composable
private fun GameContent(
    modifier: Modifier = Modifier,
    state: GameState,
    onFavoriteClick: () -> Unit,
    onSearchClick:()->Unit,
    onClick:(Int)-> Unit
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Gamopedia") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }

                    IconButton(onClick = onFavoriteClick) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->

        if (state.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        if (state.error.isNotBlank()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.error)
            }
        }

        LazyColumn(
            modifier = modifier.fillMaxSize()
                .padding(innerPadding)
        ) {
            items(state.data) {
                Card(
                    modifier = Modifier.padding(12.dp).fillMaxWidth().height(350.dp)
                        .clickable { onClick(it.id) },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Box(Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = it.imageUrl,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth().height(350.dp),
                            contentScale = ContentScale.Crop
                        )

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 12.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter),
                        ) {
                            Text(
                                it.name,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                }
            }
        }
    }
}