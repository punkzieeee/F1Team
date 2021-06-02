package com.punkzieeee.f1team.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.punkzieeee.f1team.R
import com.punkzieeee.f1team.databinding.ActivityDetailBinding
import com.punkzieeee.f1team.databinding.ContentDetailBinding
import com.punkzieeee.core.domain.model.F1Team
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var contentBinding: ContentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    companion object {
        const val EXTRA_TEAM = "extra_team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        contentBinding = binding.detailContent

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val team = intent.getParcelableExtra<F1Team>(EXTRA_TEAM)
        contentBinding.progressBar.visibility = View.VISIBLE
        team?.let {
            contentBinding.progressBar.visibility = View.GONE
            contentBinding.textTeam.text = team.strTeam
            contentBinding.textWebsite.text = team.strWebsite
            if (team.strWebsite == "") contentBinding.textWebsite.visibility =
                View.GONE
            contentBinding.textBase.text =
                if (team.strStadiumLocation == "") team.strCountry else team.strStadiumLocation
            contentBinding.teamDescription.text = team.strDescriptionEN
            contentBinding.textYear.text = team.intFormedYear
            Glide.with(this)
                .load(team.strTeamLogo)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(contentBinding.imageBanner)

            var state = team.favorite
            setFavorite(state)

            contentBinding.favorite.setOnClickListener {
                state = !state
                detailViewModel.setFavorite(team, state)
                setFavorite(state)
            }
        }

        contentBinding.share.setOnClickListener {
            Toast.makeText(this, "I'm a fan of ${contentBinding.textTeam.text}", Toast.LENGTH_LONG).show()
        }
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            contentBinding.favorite.setImageResource(R.drawable.ic_favorite)
        } else {
            contentBinding.favorite.setImageResource(R.drawable.ic_unfavorite)
        }
    }
}