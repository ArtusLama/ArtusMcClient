package de.artus.artusclient.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {

    private int x, y;

    public Position() {
        this(0, 0);
    }

}
