import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Helper class for building dependency extension
 * */
class DepsBuilder {
    internal val list = ArrayList<String>()

    /**
     * overrides unary operator to add string dependencies into array directly
     * */
    operator fun String.unaryPlus() = list.add(this)
}

/**
 * Extension function for implementation type of dependencies
 *
 * @param func is a lambda receiver of [DepsBuilder] class which provides a block to add dependencies
 * */
fun DependencyHandlerScope.`implementation`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("implementation", dep)
        }
    }

/**
 * Extension function for kapt type of dependencies
 *
 * @param func is a lambda receiver of [DepsBuilder] class which provides a block to add dependencies
 * */
fun DependencyHandlerScope.`kapt`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("kapt", dep)
        }
    }

/**
 * Extension function for api type of dependencies
 *
 * @param func is a lambda receiver of [DepsBuilder] class which provides a block to add dependencies
 * */
fun DependencyHandlerScope.`api`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("api", dep)
        }
    }

/**
 * Extension function for testImplementation type of dependencies
 *
 * @param func is a lambda receiver of [DepsBuilder] class which provides a block to add dependencies
 * */
fun DependencyHandlerScope.`testImplementation`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("testImplementation", dep)
        }
    }

/**
 * Extension function for androidTestImplementation type of dependencies
 *
 * */
fun DependencyHandlerScope.`androidTestImplementation`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("androidTestImplementation", dep)
        }
    }

/**
 * Extension function for androidTestImplementation type of dependencies
 *
 * */
fun DependencyHandlerScope.`classpaths`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("classpath", dep)
        }
    }