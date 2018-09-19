package io.navendra.kreddit.services

import io.navendra.kreddit.BuildConfig
import timber.log.Timber


class TimberLogging {

        init {
            if(BuildConfig.DEBUG){

                Timber.plant(object : Timber.DebugTree() {
                    //add line number too
                    override fun createStackElementTag(element: StackTraceElement): String? {
                        return String.format("C:%s:%s",
                                super.createStackElementTag(element),
                                element.lineNumber)
                    }
                })

            }else{
                Timber.plant(ReleaseTree())
            }
        }
    }

    // Helper Classes
    enum class PriorityLevel(val value:Int) { ERROR(0), WARNING(1) }

    class ReleaseTree : Timber.Tree(){
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == PriorityLevel.ERROR.value || priority == PriorityLevel.WARNING.value){
                //TODO Add CrashLibrary Logging
            }
        }
    }
