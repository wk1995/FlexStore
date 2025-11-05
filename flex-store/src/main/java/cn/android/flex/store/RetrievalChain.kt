package cn.android.flex.store

/**
 * 检索 链
 * */
class RetrievalChain(
    private val strategies: List<IStorageStrategy<*>>,
    private val index: Int = 0
) {


}