package com.clean.presentation_post.single

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.domain.usecase.PostUseCase
import com.clean.presentation_common.PresentedResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    private val postConverter: PostConverter
) : ViewModel() {

    private val _postFlow =
        MutableStateFlow<PresentedResult<PostModel>>(PresentedResult.Loading)
    val postFlow: StateFlow<PresentedResult<PostModel>> = _postFlow

    fun loadPost(postId: Long) {
        viewModelScope.launch {
            postUseCase.execute(PostUseCase.Request(postId))
                .map {
                    postConverter.convert(it)
                }
                .collect {
                    _postFlow.value = it
                }
        }
    }
}