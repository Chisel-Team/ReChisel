package team.chisel;

import net.minecraftforge.fml.common.Mod;
import team.chisel.common.Reference;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME, acceptedMinecraftVersions = "[1.12,1.12.2)", dependencies = "required-after:chisel@[MC1.12-0.0.14.18,)")
public class ReChisel implements Reference {
    @Mod.Instance
    public static ReChisel instance;
}