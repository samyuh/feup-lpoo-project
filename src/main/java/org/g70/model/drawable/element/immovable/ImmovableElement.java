package org.g70.model.drawable.element.immovable;

import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class ImmovableElement extends ElementModel {
    public ImmovableElement(String image, String colorForeground, Position position) {
        super(image, colorForeground, "#8dc5f0", position);
    }
}
