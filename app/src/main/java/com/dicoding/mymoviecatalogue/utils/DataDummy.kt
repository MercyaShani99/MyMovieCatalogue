package com.dicoding.mymoviecatalogue.utils

import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.TvShow
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultMovie
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultTvShow
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.TvDetailResponse

object DataDummy {
    fun getMoviePopular(): List<Movie> {
        return listOf(
            Movie(
                567189,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "2021-04-29",
                "Tom Clancy's Without Remorse",
                7.3
            ),
            Movie(
                8044435,
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "2021-04-16",
                "Vanquish",
                6.4
            ),
            Movie(
                460465,
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "2021-04-07",
                "Mortal Kombat",
                7.6
            )
        )
    }

    fun getTvPopular(): List<TvShow> {
        return listOf(
            TvShow(
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-04-23",
                "The Falcon and the Winter Soldier",
                7.9
            ),
            TvShow(
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                "The Flash",
                7.7
            ),
            TvShow(
                71712,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "2017-09-25",
                "The Good Doctor",
                8.6
            )
        )
    }

    fun getMovieDetail(): Movie {
        return Movie(
                567189,
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "2021-04-29",
                "Tom Clancy's Without Remorse",
                7.3
            )
    }

    fun getTvDetail(): TvShow {
        return TvShow(
                88396,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-04-23",
                "The Falcon and the Winter Soldier",
                7.9
            )
    }

    fun getMoviesResponse(): List<ResultMovie> {
        return listOf(
            ResultMovie(
                id = 567189,
                posterPath = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                releaseDate = "2021-04-29",
                overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                title = "Tom Clancy's Without Remorse",
                voteAverage = 7.3
            ),
            ResultMovie(
                id = 8044435,
                posterPath = "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                releaseDate = "2021-04-16",
                overview = "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                title = "Vanquish",
                voteAverage = 6.4
            ),
            ResultMovie(
                id = 460465,
                posterPath = "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                releaseDate = "2021-04-07",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                title = "Mortal Kombat",
                voteAverage = 7.6
            )
        )
    }

    fun getTvShowResponse(): List<ResultTvShow> {
        return listOf(
            ResultTvShow(
                id = 88396,
                posterPath = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                firstAirDate = "2021-04-23",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                name = "The Falcon and the Winter Soldier",
                voteAverage = 7.9
            ),
            ResultTvShow(
                id = 60735,
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                firstAirDate = "2014-10-07",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                name = "The Flash",
                voteAverage = 7.7
            ),
            ResultTvShow(
                id = 71712,
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                firstAirDate = "2017-09-25",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                name = "The Good Doctor",
                voteAverage = 8.6
            )
        )
    }

    fun getMovieDetailResponse(): MovieDetailResponse {
        return MovieDetailResponse(
            id = 567189,
            posterPath = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
            releaseDate = "2021-04-29",
            overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            title = "Tom Clancy's Without Remorse",
            voteAverage = 7.3
        )
    }

    fun getTvShowDetailResponse(): TvDetailResponse {
        return TvDetailResponse(
            id = 88396,
            posterPath = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            firstAirDate = "2021-04-23",
            overview = "Following the events of “Avengers: Endgame, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            name = "The Falcon and the Winter Soldier",
            voteAverage = 7.9
        )
    }
}