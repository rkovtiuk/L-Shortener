package com.rkovtiuk.shortener.controller

import com.rkovtiuk.shortener.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


/**
 * This class is developed by @author rkovtiuk on 24.09.17
 * for shortener in version com.rkovtiuk.shorter.controller
 * under MIT license
 */

@Controller
@RequestMapping("/add")
class AddController {

    @Autowired lateinit var service: KeyMapperService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)


}