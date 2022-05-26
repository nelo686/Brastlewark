package es.mrmoustard.brastlewark.ui.gnome.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import es.mrmoustard.brastlewark.databinding.FragmentGnomeListBinding
import es.mrmoustard.brastlewark.ui.common.BaseFragment
import es.mrmoustard.brastlewark.ui.common.EventObserver
import es.mrmoustard.domain.model.Gnome
import org.koin.androidx.viewmodel.ext.android.viewModel

class GnomeListFragment : BaseFragment() {

    private val viewModel: GnomeListViewModel by viewModel()
    private var binding: FragmentGnomeListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGnomeListBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                vm = viewModel
            }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        viewModel.initialize()

        viewModel.data.message.observeMessage()
        viewModel.data.navigation.observe(viewLifecycleOwner, EventObserver { item ->
            navigateToDetail(item = item)
        })
    }

    private fun setUpRecycler() {
        binding?.let {
            it.rvGnomes.apply {
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                adapter = GnomeListAdapter { item -> viewModel.onItemClicked(item = item) }
            }
        }
    }

    private fun navigateToDetail(item: Gnome) {
        findNavController().navigate(GnomeListFragmentDirections.actionNavigationToDetail(item))
    }
}