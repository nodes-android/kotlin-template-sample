package dk.nodes.template.network

import dk.nodes.template.models.dto.ComicsResponse
import dk.nodes.template.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("comics")
    suspend fun getComics(): Response<ComicsResponse>
}