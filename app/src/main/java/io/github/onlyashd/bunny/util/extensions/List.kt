package io.github.onlyashd.bunny.util.extensions

fun <T> MutableList<T>.addNotNull(item: T?) = if (item != null) this.add(item) else { /* skip */
}