package com.moass.ws.model;

import lombok.Data;

@Data
public class Coordinates {
    private Long x0;
    private Long y0;
    private Long x1;
    private Long y1;
    private String color;
    private String username;
    private Long lineWidth;
    private String instrument;
}
