package net.mcreator.minerp.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.Container;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.Minecraft;

import net.mcreator.minerp.init.MinerpModBlockEntities;
import net.mcreator.minerp.block.entity.TransferidorDeEnergiaBlockEntity;
import net.mcreator.minerp.MinerpMod;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(modid = MinerpMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class TransferidorDeEnergiaVisualBlockEntityRenderer implements BlockEntityRenderer<TransferidorDeEnergiaBlockEntity> {
	public TransferidorDeEnergiaVisualBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public int getViewDistance() {
		return 64;
	}

	@Override
	public AABB getRenderBoundingBox(TransferidorDeEnergiaBlockEntity blockEntity) {
		return new AABB(blockEntity.getBlockPos()).inflate(1.0);
	}

	@Override
	public void render(TransferidorDeEnergiaBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		renderDisplayItems(blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
	}

	private static void renderDisplayItems(BlockEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		Level level = blockEntity.getLevel();
		if (level == null)
			return;
		BlockState state = blockEntity.getBlockState();
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		{
			ItemStack stack;
			stack = ItemStack.EMPTY;
			if (blockEntity instanceof Container container && 0 < container.getContainerSize())
				stack = container.getItem(0);
			if (!stack.isEmpty()) {
				poseStack.pushPose();
				poseStack.translate(0.5, 0.5, 0.5);
				applyFacingRotation(poseStack, state);
				poseStack.translate(0, -0.10000000000000003, 0);
				poseStack.mulPose(Axis.YP.rotationDegrees(360f));
				float _scale0 = 0.9f;
				poseStack.scale(_scale0, _scale0, _scale0);
				itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, level, 0);
				poseStack.popPose();
			}
		}
	}

	private static void applyFacingRotation(PoseStack poseStack, BlockState state) {
		Direction facing = Direction.NORTH;
		if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING))
			facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
		else if (state.hasProperty(BlockStateProperties.FACING))
			facing = state.getValue(BlockStateProperties.FACING);
		switch (facing) {
			case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180f));
			case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(-90f));
			case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(90f));
			case UP -> poseStack.mulPose(Axis.XP.rotationDegrees(90f));
			case DOWN -> poseStack.mulPose(Axis.XP.rotationDegrees(-90f));
			default -> {
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(MinerpModBlockEntities.TRANSFERIDOR_DE_ENERGIA.get(), TransferidorDeEnergiaVisualBlockEntityRenderer::new);
	}
}