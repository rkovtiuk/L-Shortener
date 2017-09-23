package com.rkovtiuk.shortener

import org.mockito.Mockito


/**
 * This class is developed by @author rkovtiuk on 24.09.17
 * for shortener in version com.rkovtiuk.shorter
 * under MIT license
 */

fun <T> whenever(call: T) = Mockito.`when`(call)