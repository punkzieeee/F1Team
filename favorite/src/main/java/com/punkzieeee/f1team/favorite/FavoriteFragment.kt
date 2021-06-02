package com.punkzieeee.f1team.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.punkzieeee.core.ui.F1Adapter
import com.punkzieeee.f1team.di.FavoriteModuleDependencies
import com.punkzieeee.f1team.favorite.databinding.FragmentFavoriteBinding
import com.punkzieeee.f1team.ui.detail.DetailActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val favoriteAdapter = F1Adapter()
            favoriteAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_TEAM, selectedData)
                startActivity(intent)
            }
            binding.progressBar.visibility = View.VISIBLE
            favoriteViewModel.favTeam.observe(viewLifecycleOwner, { teams ->
                binding.progressBar.visibility = View.GONE
                favoriteAdapter.setTeams(teams)
                binding.textEmpty.visibility = if (teams.isEmpty()) View.VISIBLE else View.GONE
            })

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}