package com.rkovtiuk.shortener.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * This class is developed by @author rkovtiuk on 19.09.17
 * for shortener in version com.rkovtiuk.shorter.service
 * under MIT license
 */

@Service
class DefaultKeyMapperService : KeyMapperService{

    @Autowired lateinit var converter: KeyConverterService

    private val sequence = AtomicLong(10000000L)
    private val map: MutableMap<Long, String> = ConcurrentHashMap()

    override fun add(key: String): String{
        val id = sequence.getAndIncrement()
        val key = converter.idToKey(id)
        map.put(id, key)
        return key
    }

    override fun getLink(key: String): KeyMapperService.Get {
        val id = converter.keyToId(key)
        val result = map[id]

        if (result == null)
            return KeyMapperService.Get.NotFound(key)
        else
            return KeyMapperService.Get.Link(result)
    }


}