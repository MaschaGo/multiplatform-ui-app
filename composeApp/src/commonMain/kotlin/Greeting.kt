//class Greeting {
//    private val platform = getPlatform()
//
//    fun greet(): String {
//        return "Hello, ${platform.name}!"
//    }
//}

class Greeting(private val platform: Platform) {
    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}