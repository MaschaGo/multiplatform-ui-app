import android.os.Build

//class AndroidPlatform : Platform {
//    override val name: String = "Android ${Build.VERSION.SDK_INT}"
//}
//
//actual fun getPlatform(): Platform = AndroidPlatform()

actual class Platform actual constructor() {
    actual val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}