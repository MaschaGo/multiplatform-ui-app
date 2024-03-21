package data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("date")
    val date: String?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("ratio")
    val ratio: Double?
)