package com.rkovtiuk.shortener.model.repository

import com.rkovtiuk.shortener.model.entity.Link
import org.springframework.data.repository.Repository
import java.util.*

/**
 * This class is developed by @author rkovtiuk on 21.09.17
 * for shortener in version com.rkovtiuk.shorter.model.repository
 * under MIT license
 */

@org.springframework.stereotype.Repository
interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}