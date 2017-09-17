package com.rkovtiuk.shortener.controller

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

    @RequestMapping()
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse){
        if (key.equals("aAbBcCdD")){
            response.setHeader(HEADER_NAME, "http://www.eveonline.com");
            response.status = 302
        } else {
            response.status = 404
        }
    }

    private companion object {
        private val HEADER_NAME = "Location"
    }

}