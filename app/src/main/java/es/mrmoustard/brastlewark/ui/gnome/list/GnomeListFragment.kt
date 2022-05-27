package es.mrmoustard.brastlewark.ui.gnome.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import es.mrmoustard.brastlewark.databinding.FragmentGnomeListBinding
import es.mrmoustard.brastlewark.ui.common.BaseFragment
import es.mrmoustard.brastlewark.ui.common.EventObserver
import es.mrmoustard.brastlewark.ui.common.invisible
import es.mrmoustard.brastlewark.ui.common.visible
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
        setUpTextWatcher()
        viewModel.initialize()

        viewModel.data.message.observeMessage()
        viewModel.data.navigation.observe(viewLifecycleOwner, EventObserver { item ->
            navigateToDetail(item = item)
        })

        binding?.ivClearSearch?.setOnClickListener { binding?.etSearch?.text?.clear() }
    }

    private fun setUpRecycler() {
        binding?.let {
            it.rvGnomes.apply {
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                adapter = GnomeListAdapter { item -> viewModel.onItemClicked(item = item) }
            }
        }
    }

    private fun setUpTextWatcher() {
        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text?.length != null && text.isNotEmpty()) {
                    binding?.ivClearSearch?.visible()
                    viewModel.filter(Editable.Factory().newEditable(text))
                } else {
                    binding?.ivClearSearch?.invisible()
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                viewModel.filter(editable)
            }
        })
    }

    private fun navigateToDetail(item: Gnome) {
        binding?.etSearch?.text?.clear()
        findNavController().navigate(GnomeListFragmentDirections.actionNavigationToDetail(item))
    }
}