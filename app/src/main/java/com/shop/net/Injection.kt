package com.shop.net

import com.shop.net.repository.SystemRepository

/**
 * 数据仓库的代理类
 */
object Injection {
    // 创建数据仓库
    var repository:SystemRepository = SystemRepository()
}