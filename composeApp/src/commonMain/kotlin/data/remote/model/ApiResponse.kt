package data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
    data class ApiResponse(
    @SerialName("currentPage")
        val currentPage: Int?,
    @SerialName("images")
        val mjImageResponses: List<Image?>?,
    @SerialName("pageSize")
        val pageSize: Int?,
    @SerialName("totalImages")
        val totalImages: Int?,
    @SerialName("totalPages")
        val totalPages: Int?
    )
