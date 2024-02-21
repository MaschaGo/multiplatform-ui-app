//class JVMPlatform: Platform {
//    override val name: String = "Java ${System.getProperty("java.version")}"
//}
//
//actual fun getPlatform(): Platform = JVMPlatform()
//

actual class Platform actual constructor() {
    actual val name: String =
        "Java ${System.getProperty("java.version")}"
}