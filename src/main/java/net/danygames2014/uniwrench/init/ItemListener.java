package net.danygames2014.uniwrench.init;

import net.danygames2014.uniwrench.api.WrenchableBlockRegistry;
import net.danygames2014.uniwrench.api.event.UniversalWrenchModeEvent;
import net.danygames2014.uniwrench.item.UniversalWrench;
import net.danygames2014.uniwrench.item.WrenchBase;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

@SuppressWarnings("unused")
public class ItemListener {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item universalWrench;

    @EventListener
    public void registerWrench(ItemRegistryEvent event) {
        universalWrench = new UniversalWrench(NAMESPACE.id("universal_wrench")).setTranslationKey(NAMESPACE, "universal_wrench");
        StationAPI.EVENT_BUS.post(new UniversalWrenchModeEvent((UniversalWrench) universalWrench));
    }
}
