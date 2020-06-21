package com.example.common

/**
 *  Json 解析
 *  Json 操作象管的工具类
 *  全部 static 函数
 */
object JsonUtil {
    /**
     * 格式化json字符串
     * @parma jsonStr 需要格式化的json串
     * @return 格式化后的json串
     */
    fun formatJson(jsonStr: String?): String {
        return "x"
    }

    /**
     * 添加space
     * @param sb
     * @param indent
     */
    private fun addIndentBlank(sb: StringBuilder, indent: Int) {
        for (i in 0 until indent) {
            sb.append('\t')
        }
    }

    /**
     * http 请求数据返回  json 中中文字符为unicode 编码转汉字转码
     * @param theString
     * @return 转化后的结果
     */
    fun decodeUnicode(theString: String): String {
        return "x"
    }
}