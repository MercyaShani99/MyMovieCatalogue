package com.dicoding.mymoviecatalogue.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mymoviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.mymoviecatalogue.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInst()
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvp ->
                if (tvp != null) {
                    tvAdapter.setTvShow(tvp)
                    tvAdapter.notifyDataSetChanged()
                }
            })

            with(fragmentTvBinding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

}