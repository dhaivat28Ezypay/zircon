package org.codetome.zircon.graphics.box

import org.assertj.core.api.Assertions.assertThat
import org.codetome.zircon.Size
import org.codetome.zircon.api.BoxBuilder
import org.codetome.zircon.api.StyleSetBuilder
import org.junit.Test

class DefaultBoxTest {

    @Test
    fun test() {
        assertThat(BoxBuilder.newBuilder()
                .boxType(BoxType.DOUBLE)
                .filler('x')
                .size(Size(5, 5))
                .style(StyleSetBuilder.newBuilder().build())
                .build().toString())
                .isEqualTo(EXPECTED_BOX)
    }

    companion object {
        val EXPECTED_BOX = "╔═══╗\n" +
                "║xxx║\n" +
                "║xxx║\n" +
                "║xxx║\n" +
                "╚═══╝\n"
    }
}