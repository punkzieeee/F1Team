package com.punkzieeee.core.util

import com.punkzieeee.core.data.source.local.entity.F1Entity
import com.punkzieeee.core.data.source.remote.response.F1Response
import com.punkzieeee.core.domain.model.F1Team

object DataMapper {
    fun mapResponsesToEntities(input: List<F1Response>): List<F1Entity> {
        val list = ArrayList<F1Entity>()
        input.map {
            val team = F1Entity(
                idTeam = it.idTeam,
                intFormedYear = it.intFormedYear,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strStadiumLocation = it.strStadiumLocation,
                strTeam = it.strTeam,
                strTeamLogo = it.strTeamLogo,
                strTeamFanart1 = it.strTeamFanart1,
                strTeamFanart2 = it.strTeamFanart2,
                strTeamFanart3 = it.strTeamFanart3,
                strTeamFanart4 = it.strTeamFanart4,
                strTeamBanner = it.strTeamBanner,
                strWebsite = it.strWebsite,
                favorite = false
            )
            list.add(team)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<F1Entity>): List<F1Team> =
        input.map {
            F1Team(
                idTeam = it.idTeam,
                intFormedYear = it.intFormedYear,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strStadiumLocation = it.strStadiumLocation,
                strTeam = it.strTeam,
                strTeamLogo = it.strTeamLogo,
                strTeamFanart1 = it.strTeamFanart1,
                strTeamFanart2 = it.strTeamFanart2,
                strTeamFanart3 = it.strTeamFanart3,
                strTeamFanart4 = it.strTeamFanart4,
                strTeamBanner = it.strTeamBanner,
                strWebsite = it.strWebsite,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input: F1Team) = F1Entity(
        idTeam = input.idTeam,
        intFormedYear = input.intFormedYear,
        strCountry = input.strCountry,
        strDescriptionEN = input.strDescriptionEN,
        strStadiumLocation = input.strStadiumLocation,
        strTeam = input.strTeam,
        strTeamLogo = input.strTeamLogo,
        strTeamFanart1 = input.strTeamFanart1,
        strTeamFanart2 = input.strTeamFanart2,
        strTeamFanart3 = input.strTeamFanart3,
        strTeamFanart4 = input.strTeamFanart4,
        strTeamBanner = input.strTeamBanner,
        strWebsite = input.strWebsite,
        favorite = input.favorite
    )
}