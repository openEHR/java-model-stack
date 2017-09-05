package org.openehr.aom.archetype;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing source template, i.e. a kind of archetype that may include
 * template overlays, and may be restricted by tools to only defining mandations,
 * prohibitions, and restrictions on elements already defined in the flat parent.
 *
 * Created by cnanjo on 5/19/16.
 */
public class Template extends AuthoredArchetype {

    /**
     * Overlay archetypes, i.e. partial archetypes that include full definition and terminology,
     * but logically derive all their meta-data from from the owning template.
     */
    private List<TemplateOverlay> overlays;

    public Template() {
        this.overlays = new ArrayList<>();
    }

    /**
     * Returns the overlay archetypes, i.e. partial archetypes that include full definition and terminology,
     * but logically derive all their meta-data from from the owning template.
     *
     * @return
     */
    public List<TemplateOverlay> getOverlays() {
        return overlays;
    }

    /**
     * Sets the overlay archetypes, i.e. partial archetypes that include full definition and terminology,
     * but logically derive all their meta-data from from the owning template.
     *
     * @param overlays
     */
    public void setOverlays(List<TemplateOverlay> overlays) {
        this.overlays = overlays;
    }

    /**
     * Adds an overlay to this template
     *
     * @param overlay
     */
    public void addOverlay(TemplateOverlay overlay) {
        this.overlays.add(overlay);
    }
}
