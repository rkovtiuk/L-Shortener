package com.rkovtiuk.shortener.service

/**
 * This class is developed by @author rkovtiuk on 19.09.17
 * for shortener in version com.rkovtiuk.shorter.service
 * under MIT license
 */

interface KeyMapperService {

    interface Get {
        data class Link(val link: String): Get
        data class NotFound(val key: String): Get
    }

    fun getLink(key: String): Get

    fun add(key: String): String

}