package dev.VictorO.parcialdamormeo20100835.ui.gallery

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.VictorO.parcialdamormeo20100835.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    var arrSO = arrayOf("GloabGuard Insurance","SafeJourney Coverage","TravelShield Protection",
        "VoyageSecure", "WanderSure Travel Insurance")
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView7
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, arrSO)
        binding.listView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}