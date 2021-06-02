package com.punkzieeee.f1team.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.punkzieeee.f1team.R
import com.punkzieeee.f1team.databinding.FragmentHomeBinding
import com.punkzieeee.core.ui.F1Adapter
import com.punkzieeee.f1team.ui.detail.DetailActivity
import com.punkzieeee.core.data.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeAdapter = F1Adapter()
        homeAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_TEAM, selectedData)
            startActivity(intent)
        }

        if (activity != null) {
            homeViewModel.team.observe(viewLifecycleOwner, { teams ->
                when (teams) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        homeAdapter.setTeams(teams.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.errorMessage.text = teams.message ?: getString(R.string.something_wrong)
                    }
                }
            })

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = homeAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}