package cn.android.flex.store.disk.db

/**
 * 字段配置注解
 * */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FIELD)
annotation class ColumnInfo(
    val name: String = "",
    val type: ColumnType = ColumnType.AUTO,
    val index: Boolean = false
)