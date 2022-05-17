package br.com.bep.persona.dto;

import br.com.bep.persona.model.Tribe;

public class CharacterDTO {

    private String id;
    private String name;

    private TribeDTO tribe;

    private boolean active;

    private String uniqueServerHash;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TribeDTO getTribe() {
        return tribe;
    }

    public void setTribe(TribeDTO tribe) {
        this.tribe = tribe;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUniqueServerHash() {
        return uniqueServerHash;
    }

    public void setUniqueServerHash(String uniqueServerHash) {
        this.uniqueServerHash = uniqueServerHash;
    }
}
