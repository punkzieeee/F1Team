package com.punkzieeee.f1team.utils

import android.content.Context
import com.punkzieeee.core.data.source.local.entity.F1Entity
import com.punkzieeee.core.data.source.remote.response.F1Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadTeams(): List<F1Response> {
        val list = ArrayList<F1Response>()

        try {
            val responseObject = JSONObject(parsingFileToString("FormulaOne.json").toString())
            val listArray = responseObject.getJSONArray("teams")
            for (i in 0 until listArray.length()) {
                val team = listArray.getJSONObject(i)
                val id = team.getString("idTeam")
                val year = team.getString("intFormedYear")
                val country = team.getString("strCountry")
                val description = team.getString("strDescriptionEN")
                val homebase = team.getString("strStadiumLocation")
                val name = team.getString("strTeam")
                val logo = team.getString("strTeamLogo")
                val fanart1 = team.getString("strTeamFanart1")
                val fanart2 = team.getString("strTeamFanart2")
                val fanart3 = team.getString("strTeamFanart3")
                val fanart4 = team.getString("strTeamFanart4")
                val banner = team.getString("strTeamBanner")
                val website = team.getString("strWebsite")
                val response = F1Response(id,year,country,description,homebase,name,logo,fanart1,fanart2,fanart3,fanart4,banner,website)
                list.add(response)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}