package com.rkovtiuk.shortener.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.rkovtiuk.shortener.service.KeyMapperService
import com.rkovtiuk.shortener.whenever
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * This class is developed by @author rkovtiuk on 24.09.17
 * for shortener in version com.rkovtiuk.shorter.controller
 * under MIT license
 */

@TestPropertySource(locations = arrayOf("classpath:repositories-test.properties"))
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class AddControllerTest {

    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var webAppContext: WebApplicationContext

    @Mock
    lateinit var keyMapService: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: AddController

    private val KEY: String = "key"
    private val LINK: String = "link"

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webAppContext)
                .build()

        whenever(keyMapService.add(LINK)).thenReturn(KEY)
    }

    @Test
    fun whenUserAddLinkHeTakesAKey() {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper().writeValueAsString(AddController.AddRequest(LINK))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.key", Matchers.equalTo(KEY)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.link", Matchers.equalTo(LINK)))
    }


}