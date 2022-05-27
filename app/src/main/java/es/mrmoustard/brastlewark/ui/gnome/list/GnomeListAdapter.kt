package es.mrmoustard.brastlewark.ui.gnome.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.mrmoustard.brastlewark.databinding.ViewGnomeItemBinding
import es.mrmoustard.brastlewark.ui.common.load
import es.mrmoustard.domain.model.Gnome

class GnomeListAdapter (
    private val listener: (Gnome) -> Unit
): RecyclerView.Adapter<GnomeListAdapter.ViewHolder>() {

    var gnomes = listOf<Gnome>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            binding = ViewGnomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = gnomes[position], listener = listener)
    }

    override fun getItemCount(): Int = gnomes.size

    class ViewHolder(
        val binding: ViewGnomeItemBinding
        ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Gnome, listener: (Gnome) -> Unit) {
            binding.ivAvatar.load(item.thumbnail)
            binding.tvName.text = item.name
            itemView.setOnClickListener { listener(item) }
        }
    }
}
