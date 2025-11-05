package cn.android.flex.store

interface IStorageStrategy<T> {
    fun save(key: String, data: T): Boolean
    fun load(key: String): T?
    fun isAvailable(): Boolean
}