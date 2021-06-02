package com.punkzieeee.f1team.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.punkzieeee.f1team.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_favorite, FavoriteFragment())
                .commit()
            supportActionBar?.title = getString(R.string.menu_favorite)
        }
    }
}