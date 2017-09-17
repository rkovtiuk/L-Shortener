package com.rkovtiuk.shortener.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.web.context.WebApplicationContext

/**
 * This class is developed by @author rkovtiuk on 18.09.17
 * for shortener in version com.rkovtiuk.shorter.controller
 * under MIT license
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class RedirectControllerTest{

    @Autowired lateinit var webAppContext: WebApplicationContext
    lateinit var mockMvc: MockMvc

    private val PATH = "/aAbBcCdD"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME = "Location"
    private val HEADER_VALUE = "http://www.eveonline.com"
    private val BAD_PATH = "/the_bad_path"
    private val NOT_FOUND = 404

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webAppContext)
                .build()
    }

    @Test fun controllerMustRedirectUsWhenRequestIsSuccessful(){
        mockMvc.perform(get(BAD_PATH))
                .andExpect(status().`is`(NOT_FOUND))
    }

}