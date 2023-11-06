package com.nivs.all.app_navigation

sealed class Routes(val route: String) {
    object DashBoard : Routes("dashboard")
    /*object MainLiveDataActivity : Routes("livedata")
    object SignUpScreen : Routes("livedata_two_way")
    object DataBindingActivity : Routes("data_binding")
    //object MainBottomNavigationScreen : Routes("lifecycle")
    object MainViewModelActivity : Routes("viewmodel")
    object MainVMFactoryActivity : Routes("viewmodel_factory")
    //object DataEditStoreScreen : Routes("coroutine")*/
}