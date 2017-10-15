package com.rkovtiuk.shortener.controller

import com.rkovtiuk.shortener.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


/**
 * This class is developed by @author rkovtiuk on 24.09.17
 * for shortener in version com.rkovtiuk.shorter.controller
 * under MIT license
 */

@Controller
class AddController {

    @Value("\${shortener.prefix}")
    private lateinit var prefix: String

    @Autowired lateinit var service: KeyMapperService

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)

    @RequestMapping(path = arrayOf("add"), method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun addRest(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    @RequestMapping(path = arrayOf("addhtml"), method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun addHtml(model: Model, @RequestParam(value = "link") link: String): String {
        val result = add(link)
        model.addAttribute("link", result.link)
        model.addAttribute("keyed", prefix + result.key)

        return "result"
    }

    private fun add(link: String) = AddResponse(link, service.add(link))

}