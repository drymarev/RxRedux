package com.freeletics.rxredux

import android.view.ViewGroup
import com.freeletics.di.TestApplicationModule
import com.freeletics.rxredux.di.ApplicationModule
import com.freeletics.rxredux.di.DaggerApplicationComponent
import io.reactivex.android.schedulers.AndroidSchedulers

class SampleTestApplication : SampleApplication() {

    override fun componentBuilder(builder: DaggerApplicationComponent.Builder) =
        builder.applicationModule(
            TestApplicationModule(
                baseUrl = "https://localhost:$MOCK_WEB_SERVER_PORT",
                androidScheduler = AndroidSchedulers.mainThread(),
                viewBindingInstantiatorMap = mapOf<Class<*>, ViewBindingInstantiator>(
                    MainActivity::class.java to { rootView: ViewGroup ->
                        RecordingMainViewBinding(
                            rootView
                        )
                    }
                )
            )
        )

}