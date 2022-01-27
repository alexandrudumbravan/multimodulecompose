package com.clean.presentation_post.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.domain.entities.Interaction
import com.clean.domain.usecase.PostsUsersUseCase
import com.clean.domain.usecase.UpdateInteractionUseCase
import com.clean.presentation_common.PresentedResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val postsUsersUseCase: PostsUsersUseCase,
    private val updateInteractionUseCase: UpdateInteractionUseCase,
    private val converter: PostListConverter
) : ViewModel() {

    private val _postListFlow =
        MutableStateFlow<PresentedResult<PostListModel>>(PresentedResult.Loading)
    val postListFlow: StateFlow<PresentedResult<PostListModel>> = _postListFlow

    fun loadPosts() {
        viewModelScope.launch {
            postsUsersUseCase.execute(PostsUsersUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    _postListFlow.value = it
                }
        }
    }

    fun updateInteraction(interaction: Interaction) {
        viewModelScope.launch {
            updateInteractionUseCase.execute(
                UpdateInteractionUseCase.Request(
                    interaction.copy(
                        totalTaps = interaction.totalTaps.inc()
                    )
                )
            ).collect {

            }
        }
    }

}