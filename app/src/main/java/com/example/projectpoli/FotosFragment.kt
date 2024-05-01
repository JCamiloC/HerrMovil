import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectpoli.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class FotosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_fotos, container, false)

        // Obtener la referencia del RecyclerView del diseño
        recyclerView = view.findViewById(R.id.recyclerViewFotos)

        // Configurar un LayoutManager para el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crear un adaptador y establecerlo en el RecyclerView
        adapter = FotosAdapter(requireContext(), obtenerListaDeImagenes()) { imagenResource ->
            mostrarModalDescripcion(imagenResource)
        }
        recyclerView.adapter = adapter

        return view
    }

    // Método para obtener una lista de imágenes (IDs de recursos)
    private fun obtenerListaDeImagenes(): List<Int> {
        return listOf(
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5
        )
    }

    private fun mostrarModalDescripcion(imagenResource: Int) {
        val modalView = layoutInflater.inflate(R.layout.modal_descripcion, null)

        // Configurar el contenido del modal
        val textViewDescripcion = modalView.findViewById<TextView>(R.id.textViewDescripcion)
        textViewDescripcion.text = obtenerDescripcionDeImagen(imagenResource)

        // Crear y mostrar el modal
        val modalDialog = BottomSheetDialog(requireContext())
        modalDialog.setContentView(modalView)
        modalDialog.show()

        // Configurar el botón para cerrar el modal
        val botonCerrarModal = modalView.findViewById<Button>(R.id.botonCerrarModal)
        botonCerrarModal.setOnClickListener {
            modalDialog.dismiss()
        }
    }

    private fun obtenerDescripcionDeImagen(imagenResource: Int): String {
        return when (imagenResource) {
            R.drawable.p1 -> "Planta de interior resistente, ideal para decorar cualquier espacio."
            R.drawable.p2 -> "Árbol frutal de fácil cultivo, produce deliciosas frutas durante todo el año."
            R.drawable.p3 -> "Flor exótica con colores vibrantes, perfecta para añadir un toque de color al jardín."
            R.drawable.p4 -> "Planta medicinal con propiedades calmantes y aromáticas, útil para infusiones y aromaterapia."
            R.drawable.p5 -> "Cactus resistente y de bajo mantenimiento, ideal para quienes buscan plantas fáciles de cuidar."
            else -> "Descripción no disponible"
        }
    }

}
