package es.mrmoustard.brastlewark.ui.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

open class BaseFragment : Fragment() {

    open fun LiveData<Event<SnackbarStyle>>.observeMessage() {
        this.observe(viewLifecycleOwner, EventObserver {
            if (it.message.isNotEmpty()) {
                activity?.showMessage(view = requireView(), style = it)
            }
        })
    }
}