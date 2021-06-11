package com.demoshop.demoshop.viewModel;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PropertyViewModel {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        COOL, AWESOME, BORING, STUPID, SAUCY
    }
}
