package de.artus.artusclient.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Size {

    private int width, height;

    public Size() {
        this(0, 0);
    }

}