package com.rkovtiuk.shortener.service

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

/**
 * This class is developed by @author rkovtiuk on 19.09.17
 * for shortener in version com.rkovtiuk.shorter.service
 * under MIT license
 */
@Service
class DefaultKeyMapperService : KeyMapperService{

    private val map: MutableMap<String, String> = ConcurrentHashMap()

    override fun add(key: String, link: String): KeyMapperService.Add {
        if (map.containsKey(key))
            return KeyMapperService.Add.AlreadyExist(key)

        map.put(key, link)
        return KeyMapperService.Add.Success(key, link)
    }

    override fun getLink(key: String) =
            if (map.containsKey(key)) KeyMapperService.Get.Link(map.get(key)!!)
            else KeyMapperService.Get.NotFound(key)

}