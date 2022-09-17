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

package nl.nn.helpers;

import java.util.UUID;

import nl.nn.app.player.view.PlayerVO;

public final class PlayerBuilderHelper {
    public static final UUID DEFAULT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public static final UUID OTHER_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static final String DEFAULT_NAME = "PlayerVO One";

    public static final String OTHER_NAME = "PlayerVO Two";

    public static final String DEFAULT_EMAIL = "player.one@nn.nl";

    public static final String OTHER_EMAIL = "player.two@nn.nl";

    private final PlayerVO player;

    /**
     * Initialize the {@link PlayerVO} with default values
     */
    private PlayerBuilderHelper() {
        player = PlayerVO.builder()
                .id(DEFAULT_ID)
                .name(DEFAULT_NAME)
                .email(DEFAULT_EMAIL)
                .build();
    }

    /**
     * Builder initialize
     * @return the {@link PlayerBuilderHelper} instance
     */
    public static PlayerBuilderHelper builder() {
        return new PlayerBuilderHelper();
    }

    /**
     * @return the instance of {@link PlayerVO}
     */
    public PlayerVO build() {
        return player;
    }
}
