package org.codetome.zircon.internal.graphics

import org.assertj.core.api.Assertions.assertThat
import org.codetome.zircon.api.color.ANSITextColor
import org.codetome.zircon.api.Modifier.*
import org.codetome.zircon.api.Modifiers
import org.codetome.zircon.api.factory.TextColorFactory
import org.junit.Before
import org.junit.Test

class DefaultStyleSetTest {

    lateinit var target: DefaultStyleSet

    @Before
    fun setUp() {
        target = DefaultStyleSet()
    }

    @Test
    fun shouldHaveNoModifiersByDefault() {
        assertThat(target.getActiveModifiers()).isEmpty()
    }

    @Test
    fun shouldHaveProperFGByDefault() {
        assertThat(target.getForegroundColor())
                .isEqualTo(TextColorFactory.DEFAULT_FOREGROUND_COLOR)
    }

    @Test
    fun shouldHaveProperBGByDefault() {
        assertThat(target.getBackgroundColor())
                .isEqualTo(TextColorFactory.DEFAULT_BACKGROUND_COLOR)
    }

    @Test
    fun shouldProperlyEnableModifier() {
        val modifier = Modifiers.BOLD

        target.enableModifier(modifier)

        assertThat(target.getActiveModifiers()).containsExactly(modifier)
    }

    @Test
    fun shouldProperlyDisableModifier() {
        val modifier = Modifiers.BOLD

        target.enableModifier(modifier)
        target.disableModifier(modifier)

        assertThat(target.getActiveModifiers()).isEmpty()
    }

    @Test
    fun shouldProperlyEnableModifiers() {
        val modifiers = setOf(Modifiers.BOLD, Modifiers.CROSSED_OUT).toTypedArray()

        target.enableModifiers(*modifiers)

        assertThat(target.getActiveModifiers()).containsExactlyInAnyOrder(*modifiers)
    }

    @Test
    fun shouldProperlySetModifiers() {
        val modifiers = setOf(Modifiers.BOLD, Modifiers.CROSSED_OUT)

        target.setModifiers(modifiers)

        assertThat(target.getActiveModifiers()).containsExactlyInAnyOrder(*modifiers.toTypedArray())
    }

    @Test
    fun shouldProperlyClearModifiers() {
        target.enableModifier(Modifiers.BOLD)

        target.clearModifiers()

        assertThat(target.getActiveModifiers())
                .isEmpty()
    }

    companion object {
        val EXPECTED_BG_COLOR = ANSITextColor.YELLOW
        val EXPECTED_FG_COLOR = ANSITextColor.CYAN
        val EXPECTED_MODIFIERS = setOf(Modifiers.CROSSED_OUT, Modifiers.BLINK)

        val OTHER_STYLE = DefaultStyleSet(
                foregroundColor = EXPECTED_FG_COLOR,
                backgroundColor = EXPECTED_BG_COLOR,
                modifiers = EXPECTED_MODIFIERS)
    }
}