package team.chisel.common.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import team.chisel.ReChisel;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RegisterItemEvent {
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {

    }

    private static class ItemRegistryHelper {
        private final IForgeRegistry<Item> registry;

        ItemRegistryHelper(IForgeRegistry<Item> registry) {
            this.registry = registry;
        }

        private void register(String registryName, Item item) {
            item.setRegistryName(ReChisel.MOD_ID, registryName);
            registry.register(item);
        }

        private void registerBlock(Block block) {
            ItemBlock metaItemBlock = new ItemBlock(block);
            register(metaItemBlock);
        }

        private void registerSubItemBlock(Block block) {
            ItemBlock metaItemBlock = new ItemBlock(block);
            register(metaItemBlock);
        }

        private void register(ItemBlock item) {
            item.setRegistryName(item.getBlock().getRegistryName());
            item.setUnlocalizedName(item.getBlock().getUnlocalizedName());
            registry.register(item);
        }
    }
}
