package cn.android.flex.store

abstract class BaseFlexStore<T> {

    fun put(key: String, value: T?, storageStrategyChain: Iterable<IStorageStrategy<T>>) {

    }

    fun get(key: String, storageStrategyChain: Iterable<IStorageStrategy<T>>): T? {
        return null
    }
}