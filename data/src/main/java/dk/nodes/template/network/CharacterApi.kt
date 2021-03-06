package dk.nodes.template.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    /**
     * Fetches lists of events filtered by a character id.
     * Fetches lists of events in which a specific character appears, with optional filters. See notes on individual parameters below.
     * @param characterId The character ID. (required)
     * @param name Filter the event list by name. (optional)
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only events which have been modified since the specified date. (optional)
     * @param creators Return only events which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param series Return only events which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param comics Return only events which take place in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only events which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters/{characterId}/events")
    suspend fun getCharacterEventsCollection(
        @Path("characterId") characterId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches a single character by id.
     * This method fetches a single character resource.  It is the canonical URI for any character resource provided by the API.
     * @param characterId A single character id. (required)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters/{characterId}")
    suspend fun getCharacterIndividual(@Path("characterId") characterId: Int): Response<ResponseBody>

    /**
     * Fetches lists of series filtered by a character id.
     * Fetches lists of comic series in which a specific character appears, with optional filters. See notes on individual parameters below.
     * @param characterId The character ID (required)
     * @param title Filter by series title. (optional)
     * @param titleStartsWith Return series with titles that begin with the specified string (e.g. Sp). (optional)
     * @param startYear Return only series matching the specified start year. (optional)
     * @param modifiedSince Return only series which have been modified since the specified date. (optional)
     * @param comics Return only series which contain the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only series which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param events Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only series which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param seriesType Filter the series by publication frequency type. (optional)
     * @param contains Return only series containing one or more comics with the specified format. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters/{characterId}/series")
    suspend fun getCharacterSeriesCollection(
        @Path("characterId") characterId: Int,
        @Query("title") title: String,
        @Query("titleStartsWith") titleStartsWith: String,
        @Query("startYear") startYear: Int,
        @Query("modifiedSince") modifiedSince: String,
        @Query("comics") comics: Array<Int>,
        @Query("stories") stories: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("creators") creators: Array<Int>,
        @Query("seriesType") seriesType: String,
        @Query("contains") contains: Array<String>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of stories filtered by a character id.
     * Fetches lists of comic stories  featuring a specific character with optional filters. See notes on individual parameters below.
     * @param characterId The character ID. (required)
     * @param modifiedSince Return only stories which have been modified since the specified date. (optional)
     * @param comics Return only stories contained in the specified (accepts a comma-separated list of ids). (optional)
     * @param series Return only stories contained the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only stories which take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only stories which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters/{characterId}/stories")
    suspend fun getCharacterStoryCollection(
        @Path("characterId") characterId: Int,
        @Query("modifiedSince") modifiedSince: String,
        @Query("comics") comics: Array<Int>,
        @Query("series") series: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("creators") creators: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics filtered by a character id.
     * Fetches lists of comics containing a specific character, with optional filters. See notes on individual parameters below.
     * @param characterId The character id. (required)
     * @param format Filter by the issue format (e.g. comic, digital comic, hardcover). (optional)
     * @param formatType Filter by the issue format type (comic or collection). (optional)
     * @param noVariants Exclude variant comics from the result set. (optional)
     * @param dateDescriptor Return comics within a predefined date range. (optional)
     * @param dateRange Return comics within a predefined date range.  Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02).  Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format. (optional)
     * @param title Return only issues in series whose title matches the input. (optional)
     * @param titleStartsWith Return only issues in series whose title starts with the input. (optional)
     * @param startYear Return only issues in series whose start year matches the input. (optional)
     * @param issueNumber Return only issues in series whose issue number matches the input. (optional)
     * @param diamondCode Filter by diamond code. (optional)
     * @param digitalId Filter by digital comic id. (optional)
     * @param upc Filter by UPC. (optional)
     * @param isbn Filter by ISBN. (optional)
     * @param ean Filter by EAN. (optional)
     * @param issn Filter by ISSN. (optional)
     * @param hasDigitalIssue Include only results which are available digitally. (optional)
     * @param modifiedSince Return only comics which have been modified since the specified date. (optional)
     * @param creators Return only comics which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param series Return only comics which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters/{characterId}/comics")
    suspend fun getComicsCharacterCollection(
        @Path("characterId") characterId: Int,
        @Query("format") format: String,
        @Query("formatType") formatType: String,
        @Query("noVariants") noVariants: Boolean,
        @Query("dateDescriptor") dateDescriptor: String,
        @Query("dateRange") dateRange: Array<Int>,
        @Query("title") title: String,
        @Query("titleStartsWith") titleStartsWith: String,
        @Query("startYear") startYear: Int,
        @Query("issueNumber") issueNumber: Int,
        @Query("diamondCode") diamondCode: String,
        @Query("digitalId") digitalId: Int,
        @Query("upc") upc: String,
        @Query("isbn") isbn: String,
        @Query("ean") ean: String,
        @Query("issn") issn: String,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean,
        @Query("modifiedSince") modifiedSince: String,
        @Query("creators") creators: Array<Int>,
        @Query("series") series: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("stories") stories: Array<Int>,
        @Query("sharedAppearances") sharedAppearances: Array<Int>,
        @Query("collaborators") collaborators: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>
}