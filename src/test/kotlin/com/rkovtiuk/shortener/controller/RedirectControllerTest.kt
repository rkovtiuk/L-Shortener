package com.rkovtiuk.shortener.controller

import com.rkovtiuk.shortener.service.KeyMapperService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
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

    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var webAppContext: WebApplicationContext

    @Mock
    lateinit var keyMapService: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: RedirectController


    private val PATH = "aAbBcCdD"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME = "Location"
    private val HEADER_VALUE = "http://www.eveonline.com"
    private val BAD_PATH = "/the_bad_path"
    private val NOT_FOUND = 404

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webAppContext)
                .build()

        Mockito.`when`(keyMapService.getLink(PATH)).thenReturn(KeyMapperService.Get.Link(HEADER_VALUE))
        Mockito.`when`(keyMapService.getLink(BAD_PATH)).thenReturn(KeyMapperService.Get.NotFound(BAD_PATH))
    }

    @Test fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        mockMvc.perform(get("/$PATH"))
                .andExpect(status().`is`(REDIRECT_STATUS))
                .andExpect(status().`is`(NOT_FOUND))
    }

    @Test fun controllerMustReturn404IfBadKey() {
        mockMvc.perform(get("/$BAD_PATH"    ))
                .andExpect(status().`is`(NOT_FOUND))
    }

}