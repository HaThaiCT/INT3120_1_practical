package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Amphibians screen.
 */
sealed interface AmphibiansUiState {
    /**
     * State when data is successfully loaded.
     */
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState

    /**
     * State when an error occurs.
     */
    object Error : AmphibiansUiState

    /**
     * State when data is loading.
     */
    object Loading : AmphibiansUiState
}

/**
 * ViewModel for managing amphibians data and UI state.
 *
 * @param amphibiansRepository The repository for fetching amphibians data.
 */
class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    /**
     * Fetches amphibians data from the repository and updates UI state.
     */
    fun getAmphibians() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        /**
         * Factory for creating AmphibiansViewModel instances.
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }
}
