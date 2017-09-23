package com.rkovtiuk.shortener.service

import com.rkovtiuk.shortener.model.entity.Link
import com.rkovtiuk.shortener.model.repository.LinkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
    @Autowired lateinit var repo: LinkRepository

    @Transactional
    override fun add(link: String): String =
        converter.idToKey(repo.save(Link(link)).id)


    override fun getLink(key: String): KeyMapperService.Get {
        val result = repo.findOne(converter.keyToId(key))
        return if (result.isPresent)
            KeyMapperService.Get.Link(result.get().text) else
            KeyMapperService.Get.NotFound(key)
    }


}