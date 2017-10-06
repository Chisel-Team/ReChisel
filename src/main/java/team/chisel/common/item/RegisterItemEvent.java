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
import team.chisel.common.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RegisterItemEvent {
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        ItemRegistryHelper items = new ItemRegistryHelper(event.getRegistry());

        items.registerBlock(Blocks.pumpkin_surprised);
        items.registerBlock(Blocks.pumpkin_happy);
        items.registerBlock(Blocks.pumpkin_joy);
        items.registerBlock(Blocks.pumpkin_mortified);
        items.registerBlock(Blocks.pumpkin_cringing);
        items.registerBlock(Blocks.pumpkin_agape);
        items.registerBlock(Blocks.pumpkin_gasp);
        items.registerBlock(Blocks.pumpkin_unamused);
        items.registerBlock(Blocks.pumpkin_sad);
        items.registerBlock(Blocks.pumpkin_upset);
        items.registerBlock(Blocks.pumpkin_elated);
        items.registerBlock(Blocks.pumpkin_depressed);
        items.registerBlock(Blocks.pumpkin_anticipating);
        items.registerBlock(Blocks.pumpkin_confused);
        items.registerBlock(Blocks.pumpkin_screaming);
        items.registerBlock(Blocks.pumpkin_derp);
        items.registerBlock(Blocks.pumpkin_sinister);
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

        private void register(ItemBlock item) {
            item.setRegistryName(item.getBlock().getRegistryName());
            item.setUnlocalizedName(item.getBlock().getUnlocalizedName());
            registry.register(item);
        }
    }
}
