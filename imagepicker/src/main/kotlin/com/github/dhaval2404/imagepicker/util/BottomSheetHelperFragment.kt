package com.github.dhaval2404.imagepicker.util

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentManager
import com.github.dhaval2404.imagepicker.R
import com.github.dhaval2404.imagepicker.constant.ImageProvider

class BottomSheetHelperFragment : BaseBottomSheetDialogFragment() {
    override fun isTitleAvailable() = false

    private lateinit var binding: View
    override fun getBinding(): View {
        binding = LayoutInflater.from(context).inflate(R.layout.dialog_choose_app, null, false)
        return  binding
    }
    private lateinit var onSelected: (selected: ImageProvider) -> Unit

    override fun getTheme(): Int = R.style.SheetDialog

    companion object {
        fun showDialog(fragmentManager: FragmentManager, callback: (month: ImageProvider) -> Unit) {
            val bottomSheet = BottomSheetHelperFragment()
            bottomSheet.onSelected = callback
            bottomSheet.show(fragmentManager, BottomSheetHelperFragment::class.java.simpleName)
        }
    }
    override fun onReady() {

        binding.findViewById<View>(R.id.lytCameraPick).setOnClickListener {
            onSelected.invoke(ImageProvider.CAMERA)
            dismiss()
        }

        binding.findViewById<View>(R.id.lytGalleryPick).setOnClickListener {
            onSelected.invoke(ImageProvider.GALLERY)
            dismiss()
        }
    }
}