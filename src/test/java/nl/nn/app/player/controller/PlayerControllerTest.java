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

package nl.nn.app.player.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import nl.nn.app.player.stream.PlayerStreamProducer;
import nl.nn.app.player.view.PlayerVO;
import nl.nn.utils.controller.ControllerTest;
import nl.nn.utils.helper.PlayerBuilderHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@WebMvcTest(controllers = {PlayerController.class})
class PlayerControllerTest extends ControllerTest<PlayerVO> {
    @MockBean
    private PlayerStreamProducer playerStreamProducer;

    private final static String BASE_URL = "/api/player";

    /**
     * Test creating a new {@link PlayerVO}
     * and posting it through {@link PlayerController}
     * expect to be accepted. 
     */
    @Test
    void testGivenAPlayerWhenPostingToControllerExpectToBeAccepted() throws Exception {
        final var player = PlayerBuilderHelper.builder().build();
        final var response = post(BASE_URL, player);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
        assertThat(response.getContentAsString()).isEqualTo(parse(player));
    }

    /**
     * Test creating an invalid {@link PlayerVO}
     * and posting it through {@link PlayerController}
     * expect to receive bad request. 
     */
    @Test
    void testGivenAnInvalidDataWhenPostingToControllerExpectToNotBeAccepted() throws Exception {
        final var player = PlayerBuilderHelper.builder().build();
        player.setName(null);
        final var response = post(BASE_URL, player);
        assertThat(response.getStatus()).isEqualTo(BAD_REQUEST.value());
    }
}
