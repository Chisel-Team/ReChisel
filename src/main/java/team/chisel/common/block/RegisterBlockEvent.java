package team.chisel.common.block;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import team.chisel.ReChisel;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RegisterBlockEvent {
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        BlockRegistryHelper blocks = new BlockRegistryHelper(event.getRegistry());

        for (BlockCarvablePumpkin.PumpkinVariants pumpkin:BlockCarvablePumpkin.PumpkinVariants.values()) {
            blocks.register("pumpkin_" + pumpkin.name().toLowerCase(), new BlockCarvablePumpkin());
        }
    }

    private static class BlockRegistryHelper {
        private final IForgeRegistry<Block> registry;

        BlockRegistryHelper(IForgeRegistry<Block> registry) {
            this.registry = registry;
        }

        private void register(String registryName, Block block) {
            block.setRegistryName(ReChisel.MOD_ID, registryName);
            block.setUnlocalizedName(registryName);
            registry.register(block);
            registry.getEntries();
        }
    }
}
