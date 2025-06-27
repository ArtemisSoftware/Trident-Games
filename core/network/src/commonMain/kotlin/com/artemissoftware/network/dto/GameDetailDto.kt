package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDetailDto(
    @SerialName("achievements_count")
    val achievementsCount: Int,
    @SerialName("added")
    val added: Int,
    @SerialName("added_by_status")
    val addedByStatus: AddedByStatusDto,
    @SerialName("additions_count")
    val additionsCount: Int,
    @SerialName("alternative_names")
    val alternativeNames: List<String>,
    @SerialName("background_image")
    val backgroundImage: String,
    @SerialName("background_image_additional")
    val backgroundImageAdditional: String?,
    @SerialName("creators_count")
    val creatorsCount: Int,
    @SerialName("description")
    val description: String,
    @SerialName("description_raw")
    val descriptionRaw: String,
    @SerialName("developers")
    val developers: List<DeveloperDto>,
    @SerialName("dominant_color")
    val dominantColor: String,
    @SerialName("esrb_rating")
    val esrbRating: EsrbRatingDto? = null,
    @SerialName("game_series_count")
    val gameSeriesCount: Int,
    @SerialName("genres")
    val genres: List<GenreDto>,
    @SerialName("id")
    val id: Int,
    @SerialName("movies_count")
    val moviesCount: Int,
    @SerialName("name")
    val name: String,
    @SerialName("name_original")
    val nameOriginal: String,
    @SerialName("parent_achievements_count")
    val parentAchievementsCount: Int,
    @SerialName("parent_platforms")
    val parentPlatforms: List<ParentPlatformDto>,
    @SerialName("parents_count")
    val parentsCount: Int,
    @SerialName("platforms")
    val platforms: List<PlatformReleaseDTO>,
    @SerialName("playtime")
    val playtime: Int,
    @SerialName("publishers")
    val publishers: List<PublisherDto>,
    @SerialName("rating")
    val rating: Double,
    @SerialName("rating_top")
    val ratingTop: Int,
    @SerialName("ratings")
    val ratings: List<RatingDto>,
    @SerialName("ratings_count")
    val ratingsCount: Int,
    @SerialName("reddit_count")
    val redditCount: Int,
    @SerialName("reddit_description")
    val redditDescription: String,
    @SerialName("reddit_logo")
    val redditLogo: String,
    @SerialName("reddit_name")
    val redditName: String,
    @SerialName("reddit_url")
    val redditUrl: String,
    @SerialName("released")
    val released: String?,
    @SerialName("reviews_count")
    val reviewsCount: Int,
    @SerialName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerialName("saturated_color")
    val saturatedColor: String,
    @SerialName("screenshots_count")
    val screenshotsCount: Int,
    @SerialName("slug")
    val slug: String,
    @SerialName("stores")
    val stores: List<StoreDto>,
    @SerialName("suggestions_count")
    val suggestionsCount: Int,
    @SerialName("tags")
    val tags: List<TagDto>,
    @SerialName("tba")
    val tba: Boolean,
    @SerialName("twitch_count")
    val twitchCount: Int,
    @SerialName("updated")
    val updated: String,
    @SerialName("user_game")
    val userGame: String?,
    @SerialName("website")
    val website: String,
    @SerialName("youtube_count")
    val youtubeCount: Int
)
