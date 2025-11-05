package cn.android.flex.store.disk.db

/**
 * 自动建表注解
 * */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class AutoTable(
    val tableName: String = "", // 自定义表名
    val autoPK: Boolean = true // 是否自动生成主键
){
    companion object {
        const val ANNOTATION_NAME = "AutoTable"
        const val ANNOTATION_PACKAGE_NAME = "cn.android.flex.store.disk.db"
        const val ANNOTATION_PARAMETER_TABLE_NAME = "tableName"
    }
}