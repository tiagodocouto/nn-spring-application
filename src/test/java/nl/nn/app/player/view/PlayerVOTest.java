/*
 * MIT License
 *
 * Copyright (c) 2022 Tiago Couto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.nn.app.player.view;

import static nl.nn.helpers.PlayerBuilderHelper.DEFAULT_EMAIL;
import static nl.nn.helpers.PlayerBuilderHelper.DEFAULT_ID;
import static nl.nn.helpers.PlayerBuilderHelper.DEFAULT_NAME;
import static nl.nn.helpers.PlayerBuilderHelper.OTHER_EMAIL;
import static nl.nn.helpers.PlayerBuilderHelper.OTHER_ID;
import static nl.nn.helpers.PlayerBuilderHelper.OTHER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import nl.nn.helpers.ItemBuilderHelper;
import nl.nn.helpers.PlayerBuilderHelper;
import org.junit.jupiter.api.Test;

class PlayerVOTest {
    /**
     * Test instancing a {@link PlayerVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPlayerExpectGettersHashCodeEqualsToBeOk() {
        //given
        final var player = PlayerBuilderHelper.builder().build();

        //when
        //then
        assertThat(player).isNotNull();

        assertThat(player.equals(null)).isFalse();
        assertThat(player.equals(0)).isFalse();
        assertThat(player.equals(ItemBuilderHelper.builder().build())).isFalse();

        assertThat(player.hashCode()).isEqualTo(483082659);
        assertThat(player.getId()).isEqualTo(DEFAULT_ID);
        assertThat(player.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(player.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(player).hasToString("PlayerVO(super=ViewObject(" +
                                               "id=" + DEFAULT_ID + "), " +
                                               "name=" + DEFAULT_NAME + ", " +
                                               "email=" + DEFAULT_EMAIL + ")");
    }

    /**
     * Test instancing a {@link PlayerVO}
     * and checking the getters, hashCode, equals 
     */
    @Test
    void testGivenAPlayerExpectToBeEqualsOtherPlayerWithSameValues() {
        //given
        final var player1 = PlayerBuilderHelper.builder().build();
        final var player2 = PlayerBuilderHelper.builder().build();

        //when
        //then
        assertThat(player1)
                .isNotEqualTo(null)
                .isEqualTo(player2);
    }

    /**
     * Test instancing a {@link PlayerVO}
     * and changing the properties values 
     */
    @Test
    void testGivenPlayerWhenChangingItPropertiesExpectSettersToBeOk() {
        //given
        final var player1 = PlayerBuilderHelper.builder().build();
        final var player2 = PlayerBuilderHelper.builder().build();

        //when
        assertThat(player1).isNotNull();
        assertThat(player2).isNotNull();
        assertThat(player1).isEqualTo(player2);

        player1.setEmail(OTHER_EMAIL);
        assertThat(player1).isNotEqualTo(player2);

        player1.setName(OTHER_NAME);
        assertThat(player1).isNotEqualTo(player2);

        player1.setId(OTHER_ID);
        assertThat(player1).isNotEqualTo(player2);

        //then
        assertThat(player1.hashCode()).isEqualTo(-1173570140);
        assertThat(player1.getId()).isEqualTo(OTHER_ID);
        assertThat(player1.getName()).isEqualTo(OTHER_NAME);
        assertThat(player1.getEmail()).isEqualTo(OTHER_EMAIL);
        assertThat(player1).hasToString("PlayerVO(super=ViewObject(" +
                                                "id=" + OTHER_ID + "), " +
                                                "name=" + OTHER_NAME + ", " +
                                                "email=" + OTHER_EMAIL + ")");
    }
}
