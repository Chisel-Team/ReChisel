package team.chisel.common;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Reference class for different mod information
 */
@ParametersAreNonnullByDefault
public interface Reference {

    public static final String MOD_ID = "rechisel";

    public static final String MOD_NAME = "ReChisel";
    public static final String VERSION = "@VERSION@";

    public static final String CLIENT_PROXY = "team.chisel.client.ClientProxy";
    public static final String COMMON_PROXY = "team.chisel.common.CommonProxy";
}
