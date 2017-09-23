package com.rkovtiuk.shortener.model.entity

import com.sun.xml.internal.bind.v2.model.core.ID
import javax.persistence.*

/**
 * This class is developed by @author rkovtiuk on 17.09.17
 * for shortener in version com.rkovtiuk.shorter.model.entity
 * under MIT license
 */

@Entity
@Table(name = "links")
data class Link(
        var text: String = "",

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "links_sequence")
        @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
        var id: Long = 0)