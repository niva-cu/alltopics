package com.nivs.all.app_navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.br_connectivity_register.BroadcastReceiverRegisterActivity
import com.nivs.all.br_notification.BroadcastNotificationActivity
import com.nivs.all.br_wifi.BroadcastReceiverActivity
import com.nivs.all.camerax.MainCameraXActivity
import com.nivs.all.contentProvi_shardPref.MainContentProviderActivity
import com.nivs.all.contentProvi_shardPref.MainShredPrefActivity
import com.nivs.all.coroutine.coroutine1.MainCoroutineActivity
import com.nivs.all.data_binding.DataBindingActivity
import com.nivs.all.data_binding_twoway.DataBindingTwowayActivity
import com.nivs.all.databinding.ActivityAlltopicsBinding
import com.nivs.all.db_room.MainDBActivity
import com.nivs.all.di_hilt_room.DIActivity
import com.nivs.all.di_hilt_offline.DiOfflineActivity
import com.nivs.all.di_hilt_room_fromApi_ToActivity.RoomActivity
import com.nivs.all.dialog_alert_fragment.AlertDialogActivityEg
import com.nivs.all.dialog_alert_fragment.DiffDialogActivity
import com.nivs.all.latlong.BackgroundLatLongActivity
import com.nivs.all.latlong.LatLongActivity
import com.nivs.all.livedata.MainLiveDataActivity
import com.nivs.all.navigation_LeftRightBottom.LeftNavDrawerActivity
import com.nivs.all.navigation_LeftRightBottom.RightNavDrawerActivity
import com.nivs.all.viewpager_eg.MainViewPagerActivity
import com.nivs.all.navDrawer_viewPager.anoter_viewpaer.MainFragmentPagerActivity
import com.nivs.all.navigation_LeftRightBottom.BottomNavigationActivity
import com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel.ActFragVMActivity
import com.nivs.all.navigation_data_share.fragment_fragment.FragFragActivity
import com.nivs.all.navigation_data_share.fragment_fragment_bundle.FragFragBundleActivity
import com.nivs.all.navigation_data_share.fragment_fragment_navgraph.FragFragDataNavGraphActivity
import com.nivs.all.pus_notification.PusNotificationActivity
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.RetrofitGlideRecyclerActivity
import com.nivs.all.room_offline_crud_notes.RoomCRUDActivity
import com.nivs.all.runtime_permission.PermissionAskActivity
import com.nivs.all.sms_call_email_battery.SmsCallEmailBluetoothActivity
import com.nivs.all.startservice.StartServiceEg
import com.nivs.all.viewmodel_factory.MainVMFactoryActivity
import com.nivs.all.viewmodeleg.MainViewModelActivity

class AllTopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlltopicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlltopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPermission.setOnClickListener(){
            val intent = Intent(this, PermissionAskActivity::class.java)
            startActivity(intent)
        }

        binding.tvLaunchActivity.setOnClickListener(){
            val intent = Intent(this, MainLiveDataActivity::class.java)
            //startActivity(intent)
        }

        binding.tvCoroutine1.setOnClickListener(){
            val intent = Intent(this, MainCoroutineActivity::class.java)
            startActivity(intent)
        }

        binding.tvCoroutine2.setOnClickListener(){
            val intent = Intent(this, MainLiveDataActivity::class.java)
            //startActivity(intent)
        }

        binding.tvDataBindin1.setOnClickListener(){
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }

        binding.tvDataBindin2.setOnClickListener(){
            val intent = Intent(this, DataBindingTwowayActivity::class.java)
            startActivity(intent)
        }

        binding.tvDI1.setOnClickListener(){
            val intent = Intent(this, DiOfflineActivity::class.java)
            startActivity(intent)
        }

        binding.tvDI2.setOnClickListener(){
            val intent = Intent(this, DIActivity::class.java)
            startActivity(intent)
        }

        binding.tvLiveData1.setOnClickListener(){
            val intent = Intent(this, MainLiveDataActivity::class.java)
            startActivity(intent)
        }

        binding.tvViewModel1.setOnClickListener(){
            val intent = Intent(this, MainViewModelActivity::class.java)
            startActivity(intent)
        }
        binding.tvViewModel2.setOnClickListener(){
            val intent = Intent(this, MainVMFactoryActivity::class.java)
            startActivity(intent)
        }


        binding.tvRetrofit1.setOnClickListener(){
            val intent = Intent(this, RetrofitGlideRecyclerActivity::class.java)
            startActivity(intent)
        }

        binding.tvRetrofit2.setOnClickListener(){
            //val intent = Intent(this, RoomCRUDActivity::class.java)
            //startActivity(intent)
        }



        binding.tvRoom1.setOnClickListener(){
            val intent = Intent(this, MainDBActivity::class.java)
            startActivity(intent)
        }

        binding.tvRoom2.setOnClickListener(){
            val intent = Intent(this, RoomCRUDActivity::class.java)
            startActivity(intent)
        }
        binding.tvRoom3.setOnClickListener(){
            val intent = Intent(this, DiOfflineActivity::class.java)
            //startActivity(intent)
        }
        binding.tvRoom4.setOnClickListener(){
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

        binding.tvLatLon1.setOnClickListener(){
            val intent = Intent(this, LatLongActivity::class.java)
            startActivity(intent)
        }

        binding.tvLatLon2.setOnClickListener(){
            val intent = Intent(this, BackgroundLatLongActivity::class.java)
            startActivity(intent)
        }

        binding.tvLatLon3.setOnClickListener(){
            val intent = Intent(this, LatLongActivity::class.java)
            // startActivity(intent)
        }

        binding.tvStartService.setOnClickListener(){
            val intent = Intent(this, StartServiceEg::class.java)
            startActivity(intent)
        }

        binding.tvStartService1.setOnClickListener(){
            //val intent = Intent(this, StartServiceEg::class.java)
           // startActivity(intent)
        }

        binding.tvStartService2.setOnClickListener(){
           // val intent = Intent(this, StartServiceEg::class.java)
           // startActivity(intent)
        }

        binding.tvBR1.setOnClickListener(){
            val intent = Intent(this, BroadcastReceiverActivity::class.java)
            startActivity(intent)
        }

        binding.tvBR2.setOnClickListener(){
            val intent = Intent(this, BroadcastReceiverRegisterActivity::class.java)
            startActivity(intent)
        }

        binding.tvBR3.setOnClickListener(){
            val intent = Intent(this, BroadcastNotificationActivity::class.java)
            startActivity(intent)
        }
        binding.tvBR4.setOnClickListener(){
            val intent = Intent(this, PusNotificationActivity::class.java)
            startActivity(intent)
        }
        binding.tvSCEB.setOnClickListener(){
            val intent = Intent(this, SmsCallEmailBluetoothActivity::class.java)
            startActivity(intent)
        }
        binding.tvCamX1.setOnClickListener(){
            val intent = Intent(this, MainCameraXActivity::class.java)
            startActivity(intent)
        }
        binding.tvContent1.setOnClickListener(){
            val intent = Intent(this, MainContentProviderActivity::class.java)
            startActivity(intent)
        }
        binding.tvShared1.setOnClickListener(){
            val intent = Intent(this, MainShredPrefActivity::class.java)
            startActivity(intent)
        }
        binding.tvAlert1.setOnClickListener(){
            val intent = Intent(this, AlertDialogActivityEg::class.java)
            startActivity(intent)
        }
        binding.tvDialogs1.setOnClickListener(){
            val intent = Intent(this, DiffDialogActivity::class.java)
            startActivity(intent)
        }

        binding.tvNavDrawer1.setOnClickListener(){
            val intent = Intent(this, LeftNavDrawerActivity::class.java)
            startActivity(intent)
        }
        binding.tvNavDrawer2.setOnClickListener(){
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        binding.tvNavDrawer3.setOnClickListener(){
            val intent = Intent(this, RightNavDrawerActivity::class.java)
            startActivity(intent)
        }
        binding.tvViewPager1.setOnClickListener(){
            val intent = Intent(this, MainViewPagerActivity::class.java)
            startActivity(intent)
        }
        binding.tvViewPager2.setOnClickListener(){
            val intent = Intent(this, MainFragmentPagerActivity::class.java)
            startActivity(intent)
        }





        binding.tvNavFragment.setOnClickListener(){
            val intent = Intent(this, FragFragActivity::class.java)
            startActivity(intent)
        }
        binding.tvNavFragmentBundle.setOnClickListener(){
            val intent = Intent(this, FragFragBundleActivity::class.java)
            startActivity(intent)
        }
        binding.tvNavActivityFragment.setOnClickListener(){
            val intent = Intent(this, ActFragVMActivity::class.java)
            startActivity(intent)
        }
        binding.tvNavFragmentActivity.setOnClickListener(){
            val intent = Intent(this, FragFragDataNavGraphActivity::class.java)
            startActivity(intent)
        }
        binding.tvViewPager2.setOnClickListener(){
            val intent = Intent(this, MainFragmentPagerActivity::class.java)
            startActivity(intent)
        }


        binding.tvAbstract.setOnClickListener(){
            val intent = Intent(this, ActFragVMActivity::class.java)
           // startActivity(intent)
        }
        binding.tvInterface.setOnClickListener(){
            val intent = Intent(this, FragFragDataNavGraphActivity::class.java)
            //startActivity(intent)
        }
        binding.tvConstructor.setOnClickListener(){
            val intent = Intent(this, MainFragmentPagerActivity::class.java)
            //startActivity(intent)
        }
    }
}