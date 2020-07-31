package com.torrentcome.lalala.base

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class RxSchedulerRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement {

        return object : Statement() {

            @Throws(Throwable::class)
            override fun evaluate() {
                RxAndroidPlugins.reset()
                RxAndroidPlugins.setInitMainThreadSchedulerHandler {
                    Schedulers.trampoline()
                }

                RxJavaPlugins.reset()
                RxJavaPlugins.setIoSchedulerHandler {
                    Schedulers.trampoline()
                }
                RxJavaPlugins.setNewThreadSchedulerHandler {
                    Schedulers.trampoline()
                }
                RxJavaPlugins.setComputationSchedulerHandler {
                    Schedulers.trampoline()
                }

                base.evaluate()
            }
        }
    }
}