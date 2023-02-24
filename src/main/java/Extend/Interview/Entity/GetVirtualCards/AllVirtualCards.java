package Extend.Interview.Entity.GetVirtualCards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllVirtualCards {

    @JsonProperty("virtualCards")
    List<VirtualCard> virtualCards;

    public AllVirtualCards(List<VirtualCard> virtualCards) {
        this.virtualCards = virtualCards;
    }

    public AllVirtualCards() {
    }

    public List<VirtualCard> getVirtualCards() {
        return virtualCards;
    }

    public void setVirtualCards(List<VirtualCard> virtualCards) {
        this.virtualCards = virtualCards;
    }
}
