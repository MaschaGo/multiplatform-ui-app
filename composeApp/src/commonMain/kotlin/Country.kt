import kotlinx.datetime.TimeZone

data class Country(val name: String, val zone: TimeZone, val image: String)


class MockCountry{
    fun countries() = listOf(
        Country("Japan", TimeZone.of("Asia/Tokyo"), "jp.png"),
        Country("France", TimeZone.of("Europe/Paris"), "fr.png"),
        Country("Mexico", TimeZone.of("America/Mexico_City"), "mx.png"),
        Country("Indonesia", TimeZone.of("Asia/Jakarta"), "id.png"),
        Country("Egypt", TimeZone.of("Africa/Cairo"), "eg.png")
    )
}
