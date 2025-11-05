package cn.android.flex.store.disk.db

import cn.android.flex.store.disk.db.AutoTable.Companion.ANNOTATION_PACKAGE_NAME
import cn.android.flex.store.disk.db.AutoTable.Companion.ANNOTATION_PARAMETER_TABLE_NAME
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.validate

class AutoTableProcessor(
    private val codeGenerator: CodeGenerator, private val logger: KSPLogger
) : SymbolProcessor {

    companion object {
        private val ksClassDeclarations = ArrayList<KSClassDeclaration>()
    }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        // 获取所有被标记的类
        val symbols = resolver.getSymbolsWithAnnotation(ANNOTATION_PACKAGE_NAME)
            .filter { it !in ksClassDeclarations && it is KSClassDeclaration }
        var count = 0
        symbols.forEach { clazz ->
            if (clazz is KSClassDeclaration) {
                ksClassDeclarations.add(clazz)
                count++
                // 解析类信息
                val autoTableAnnotation = clazz.annotations.firstOrNull {
                    it.annotationType.resolve().declaration.qualifiedName?.asString() == ANNOTATION_PACKAGE_NAME
                }
                var tableName: String? = ""
                autoTableAnnotation?.arguments?.forEach {
                    if (it.name?.asString() == ANNOTATION_PARAMETER_TABLE_NAME) {
                        tableName = it.value as? String
                    }
                }

                if (tableName.isNullOrEmpty()) {
                    tableName = clazz.simpleName.asString()
                }
                // 生成Entity类
//                generateEntityClass(clazz, tableName)

                // 生成DAO接口
//                generateDaoInterface(clazz, tableName)

                // 生成Database类
//                generateDatabaseClass(clazz)
            }
        }
        if (count == 0) {
            logger.info("no symbols")
            return emptyList()
        }
        return symbols.filterNot { it.validate() }.toList()
    }
}