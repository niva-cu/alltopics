package com.nivs.all.startservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.nivs.all.R

class MediaplayService: Service() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_STICKY
    }

}