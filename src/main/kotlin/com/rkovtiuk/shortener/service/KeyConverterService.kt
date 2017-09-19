package com.rkovtiuk.shortener.service

/**
 * This class is developed by @author rkovtiuk on 20.09.17
 * for shortener in version com.rkovtiuk.shorter.service
 * under MIT license
 */

interface KeyConverterService {
    fun idToKey(id: Long): String
    fun keyToId(key: String): Long
}