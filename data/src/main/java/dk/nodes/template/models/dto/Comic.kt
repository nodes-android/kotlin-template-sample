package dk.nodes.template.models.dto

data class Comic(
    val characters: Characters = Characters(),
    val collectedIssues: List<Any> = listOf(),
    val collections: List<Any> = listOf(),
    val creators: Creators = Creators(),
    val dates: List<Date> = listOf(),
    val description: String? = "",
    val diamondCode: String = "",
    val digitalId: Int = 0,
    val ean: String = "",
    val events: Events = Events(),
    val format: String = "",
    val id: Int = 0,
    val images: List<Image> = listOf(),
    val isbn: String = "",
    val issn: String = "",
    val issueNumber: Int = 0,
    val modified: String = "",
    val pageCount: Int = 0,
    val prices: List<Price> = listOf(),
    val resourceURI: String = "",
    val series: Series = Series(),
    val stories: Stories = Stories(),
    val textObjects: List<TextObject> = listOf(),
    val thumbnail: Thumbnail = Thumbnail(),
    val title: String = "",
    val upc: String = "",
    val urls: List<Url> = listOf(),
    val variantDescription: String = "",
    val variants: List<Any> = listOf()
)