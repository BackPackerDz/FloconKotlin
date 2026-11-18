package io.github.openflocon.flocon.utils

actual fun currentTimeMillis(): Long = System.currentTimeMillis()

actual fun currentTimeNanos(): Long = System.nanoTime()

actual fun createThrowableFromClassName(className: String): Throwable? = try {
    val errorClass = Class.forName(className)
    errorClass.getDeclaredConstructor().newInstance() as? Throwable
} catch (t: Throwable) {
    null
}
