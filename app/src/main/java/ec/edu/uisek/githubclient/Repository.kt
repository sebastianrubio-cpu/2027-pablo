package ec.edu.uisek.githubclient

data class Repository(
    val id: Int,
    val name: String,
    val description: String,
    val language: String,
    val stars: Int
)

val sampleRepositories = listOf(
    Repository(
        id = 1,
        name = "compose-samples",
        description = "Official Jetpack Compose samples and tutorials provided by Android.",
        language = "Kotlin",
        stars = 14200
    ),
    Repository(
        id = 2,
        name = "architecture-components-samples",
        description = "Samples demonstrating Android Architecture Components (Room, ViewModel, Navigation).",
        language = "Kotlin",
        stars = 11300
    ),
    Repository(
        id = 3,
        name = "retrofit",
        description = "A type-safe HTTP client for Android and the JVM.",
        language = "Java",
        stars = 42100
    ),
    Repository(
        id = 4,
        name = "kotlinx.coroutines",
        description = "Library support for Kotlin coroutines with multiplatform support.",
        language = "Kotlin",
        stars = 12500
    ),
    Repository(
        id = 5,
        name = "coil",
        description = "Image loading for Android backed by Kotlin Coroutines.",
        language = "Kotlin",
        stars = 9800
    )
)