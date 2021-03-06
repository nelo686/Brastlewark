package es.mrmoustard.brastlewark.ui.gnome.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import es.mrmoustard.brastlewark.databinding.FragmentGnomeDetailBinding
import es.mrmoustard.brastlewark.ui.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class GnomeDetailFragment : BaseFragment() {

    private val viewModel: GnomeDetailViewModel by viewModel()
    private var binding: FragmentGnomeDetailBinding? = null
    private val args: GnomeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGnomeDetailBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                vm = viewModel
            }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize(item = args.item)
        viewModel.data.message.observeMessage()
    }
}