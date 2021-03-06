import org.jnbt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Entity {
    // the tag in structure format
    private CompoundTag entityTag;

    /**
     * Entity Class - deals with all the fun parts of NBT!
     *
     * @param ct - the root tag of the entity
     */
    Entity(CompoundTag ct) {
        // get a map of all the tags
        Map<String, Tag> entityMap = ct.getValue();

        // get pos list, we can reuse it
        List<Tag> posList = (List<Tag>) entityMap.get("Pos").getValue();

        // save compound tag, so we can deal with the rest of the stuff later

        // make a hashmap for the tags
        HashMap<String, Tag> entity = new HashMap<>();
        // chuck everything in it
        entity.put("pos", new ListTag("pos", DoubleTag.class, posList));

        CompoundTag entityNBTTag = new CompoundTag("nbt", entityMap);


        entity.put("nbt", entityNBTTag);// hope this works
        // make it a tag!
        entityTag = new CompoundTag("Entity", entity);

    }

    /**
     * getStructureFormat
     *
     * @return - a CompoundTag formatted correctly for Mojang's NBT Structure Specifications
     */
    CompoundTag getStructureFormat() {
        return entityTag;
    }
}
