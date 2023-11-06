package com.nivs.all.lifecycle

import android.util.Log
import androidx.lifecycle.*

class ObserverLife:DefaultLifecycleObserver{

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MAIN_OBS", "onCreate: CObserver ")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("MAIN_OBS","onStart: SObserver")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("MAIN_OBS", "onPause: PObserver")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("MAIN_OBS", "onResume: RObserver")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("MAIN_OBS", "onStop: STObserver")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("MAIN_OBS", "onDestroy: DObserver")
    }
}