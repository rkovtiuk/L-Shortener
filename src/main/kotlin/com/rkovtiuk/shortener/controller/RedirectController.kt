package com.rkovtiuk.shortener.controller

import com.rkovtiuk.shortener.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

/**
 * This class is developed by @author rkovtiuk on 18.09.17
 * for shortener in version com.rkovtiuk.shorter.controller
 * under MIT license
 */

@Controller
@RequestMapping("{key}")
class RedirectController {

    @Autowired
    lateinit var keyMapperService: KeyMapperService

    @RequestMapping()
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse){
        val result = keyMapperService.getLink(key)
        when (result) {
            is KeyMapperService.Get.Link -> {
                response.setHeader(HEADER_NAME, result.link)
                response.status = 302
            }
            is KeyMapperService.Get.NotFound -> response.status = 404
        }
    }

    private companion object {
        private val HEADER_NAME = "Location"
    }

}