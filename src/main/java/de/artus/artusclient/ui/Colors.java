package de.artus.artusclient.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum Colors {


    // also works like this => new Color(r, g, b, a).getRGB() (using awt color class)

    PRIMARY_COLOR(0xFF2fcff7),


    UI_BACKGROUND_COLOR(0x80202020),
    UI_SCROLLBAR_BACKGROUND(UI_BACKGROUND_COLOR.getColor()),
    UI_SCROLLBAR_THUMB_COLOR(PRIMARY_COLOR.getColor()),
    UI_CLIENT_MENU_BACKGROUND(UI_BACKGROUND_COLOR.getColor()),

    UI_BORDER_COLOR(0xFFe6e6e6),
    UI_DARKER_BORDER_COLOR(0xFFa8a8a8),

    UI_MOD_BORDER_DISABLED(0xFFa8a8a8),
    UI_MOD_BORDER_ACTIVE(0xFF8fed8a),


    SCREEN_DIM_BACKGROUND_START(0x20000000),
    SCREEN_DIM_BACKGROUND_END(0x33000000),

    TEXT_NORMAL_COLOR(0xFFe6e6e6),



    ;

    @Getter
    private final int color;


}
