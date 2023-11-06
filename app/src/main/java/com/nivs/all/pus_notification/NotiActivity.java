package com.nivs.all.pus_notification;

import android.app.NotificationChannel ;
        import android.app.NotificationManager ;
        import android.app.PendingIntent ;
        import android.content.Intent ;
        import android.os.Bundle ;
        import android.util.Log ;
        import android.view.View ;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.nivs.all.R;

public class NotiActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_pusnotification ) ;

    }
    public void createNotification (View view) {
        Intent notificationIntent = new Intent(getApplicationContext() , PusNotificationActivity.class ) ;
        notificationIntent.putExtra( "NotificationMessage" , "I am from Notification" ) ;
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP ) ;
        PendingIntent pendingIntent = PendingIntent.getActivity( this, 0 , notificationIntent , PendingIntent.FLAG_UPDATE_CURRENT ) ;
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotiActivity.this, default_notification_channel_id ) ;
        mBuilder.setContentTitle( "My Notification" ) ;
        mBuilder.setContentIntent(pendingIntent) ;
        mBuilder.setContentText( "Notification Listener Service Example" ) ;
        mBuilder.setTicker( "Notification Listener Service Example" ) ;
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground ) ;
        mBuilder.setAutoCancel( true ) ;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager.IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int )System.currentTimeMillis() , mBuilder.build()) ;
    }
}