package com.nivs.all.camerax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.nivs.all.R
import java.util.concurrent.Executors

class MainCameraXActivity: AppCompatActivity() {
    private lateinit var viewFinder: PreviewView
    private var cameraExecutor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maincamerax)
        viewFinder = findViewById(R.id.viewFinder)

        startCamera()
    }

    private fun startCamera()
    {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener(Runnable {
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            // Preview UseCase
            val previewUseCase = Preview.Builder()
                .build()
                .also {
                    //it.setSurfaceProvider(viewFinder.createSurfaceProvider())
                }

            // ImageAnalysis UseCase
            val analysisUseCase = ImageAnalysis.Builder()
                .build()
                .also {
                    //it.setAnalyzer(cameraExecutor, FaceAnalyzer(lifecycle,overlay))
                }

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(this, cameraSelector, previewUseCase,analysisUseCase)

            } catch(exc: Exception) {

            }

        }, ContextCompat.getMainExecutor(this))
    }
}