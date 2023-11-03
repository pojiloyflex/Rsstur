package ru.rsttur.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.rsttur.data.response.home_page.blog_preview.HomePageBlogPreviewResponse
import ru.rsttur.data.response.home_page.card.HomePageCardResponse
import ru.rsttur.data.response.home_page.content.HomePageResponse
import ru.rsttur.data.response.home_page.room.HomePageRoomResponse
import ru.rsttur.data.response.home_page.tour.HomePageTourResponse
import ru.rsttur.data.source.remote.ApiConstants.BLOG
import ru.rsttur.data.source.remote.ApiConstants.BLOGS
import ru.rsttur.data.source.remote.ApiConstants.CARDS
import ru.rsttur.data.source.remote.ApiConstants.HOME_PAGE
import ru.rsttur.data.source.remote.ApiConstants.ROOMS
import ru.rsttur.data.source.remote.ApiConstants.TOURS

private const val DEFAULT_ID = 117L

interface ApiService {

    @GET(HOME_PAGE)
    suspend fun getHomePage(@Query("id") id: Long = DEFAULT_ID): HomePageResponse

    @GET(BLOG)
    suspend fun getBlog(
        @Query("id") id: Long,
        @Query("blog_id ") blogId: Long
    )

    @GET(BLOGS)
    suspend fun getBlogs(
        @Query("id") id: Long,
        @Query("format") format: String
    ): HomePageBlogPreviewResponse

    @GET(CARDS)
    suspend fun getCards(
        @Query("id") id: Long,
        @Query("type") type: String
    ): HomePageCardResponse

    @GET(TOURS)
    suspend fun getTours(
        @Query("id") id: Long
    ): HomePageTourResponse

    @GET(ROOMS)
    suspend fun getRooms(
        @Query("id") id: Long
    ): HomePageRoomResponse
}