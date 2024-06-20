package tech.thatgravyboat.creeperoverhaul.client.neoforge;

import net.minecraft.client.renderer.ShaderInstance;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import tech.thatgravyboat.creeperoverhaul.client.CreepersClient;
import tech.thatgravyboat.creeperoverhaul.client.RenderTypes;

public class CreepersForgeClient {

    public static void onClient(FMLClientSetupEvent event) {
        CreepersClient.init();
        CreepersClient.registerRenderers();
    }

    public static void onShaderRegister(RegisterShadersEvent event) {
        RenderTypes.registerShaders((id, format, callback) -> {
            try {
                event.registerShader(new ShaderInstance(event.getResourceProvider(), id, format), callback);
            } catch (Exception e) {
                throw new RuntimeException("[Creeper Overhaul] Shaders could not be reloaded", e);
            }
        });
    }

}