import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectpoli.R

class FotosAdapter(
    private val context: Context,
    private val imagenes: List<Int>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<FotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_imagen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagenResource = imagenes[position]
        holder.imageView.setImageResource(imagenResource)
        holder.itemView.setOnClickListener { listener(imagenResource) }
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
