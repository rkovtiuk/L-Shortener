package com.rkovtiuk.shortener.model

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.rkovtiuk.shortener.ShortenerApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

/**
 * This class is developed by @author rkovtiuk on 21.09.17
 * for shortener in version com.rkovtiuk.shorter.model
 * under MIT license
 */

@TestExecutionListeners(DbUnitTestExecutionListener::class)
@SpringBootTest(classes = arrayOf(ShortenerApplication::class))
@DirtiesContext
abstract class AbstractRepositoryTest : AbstractTransactionalJUnit4SpringContextTests() {

}