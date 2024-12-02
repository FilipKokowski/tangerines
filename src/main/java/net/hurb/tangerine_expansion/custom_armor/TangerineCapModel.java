// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.hurb.tangerine_expansion.custom_armor;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TangerineCapModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tangerine_expansion", "tangerine_cap_3d"), "main");
	private final ModelPart HEAD;

	public TangerineCapModel(ModelPart root) {
		this.HEAD = root.getChild("HEAD");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition HEAD = partdefinition.addOrReplaceChild("HEAD", CubeListBuilder.create().texOffs(50, 0).addBox(5.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 74).addBox(5.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(12, 75).addBox(6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(72, 74).addBox(5.0F, -2.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(30, 15).addBox(6.0F, -1.0F, 2.0F, 1.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(26, 74).addBox(6.0F, -1.0F, 15.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(60, 42).addBox(6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(52, 72).addBox(-9.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 38).addBox(-7.0F, -2.0F, 0.0F, 0.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(66, 74).addBox(-8.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 75).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 75).addBox(-9.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(58, 16).addBox(-9.0F, -2.0F, 2.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(60, 56).addBox(-8.0F, -3.0F, 2.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(4, 75).addBox(-8.0F, -2.0F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 75).addBox(-8.0F, -1.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 77).addBox(-9.0F, -1.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(58, 35).addBox(-8.0F, -2.0F, 15.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(16, 77).addBox(-8.0F, -2.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 38).addBox(-8.0F, 0.0F, 2.0F, 0.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(-9.0F, 0.0F, 2.0F, 1.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(60, 31).addBox(-8.0F, 0.0F, 14.0F, 14.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 72).addBox(-7.0F, -2.0F, 0.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(60, 71).addBox(-8.0F, -1.0F, -1.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 74).addBox(-8.0F, 1.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 56).addBox(-8.0F, 9.0F, 0.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(58, 0).addBox(5.0F, 9.0F, 0.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(26, 72).addBox(-7.0F, 9.0F, 14.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 74).addBox(5.0F, 1.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 64).addBox(-7.0F, -3.0F, 1.0F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-7.0F, -3.0F, 2.0F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(50, 11).addBox(-2.0F, -5.0F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 75).addBox(5.0F, -2.0F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 68).addBox(-7.0F, -3.0F, 14.0F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(58, 31).addBox(-7.0F, -3.0F, 14.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 61).addBox(-7.0F, -2.0F, 15.0F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 14.0F, -8.0F));

		PartDefinition cube_r1 = HEAD.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 74).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 9.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = HEAD.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 74).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.0F, 9.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		HEAD.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}
}