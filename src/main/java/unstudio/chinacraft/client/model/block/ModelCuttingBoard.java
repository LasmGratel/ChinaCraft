package unstudio.chinacraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCuttingBoard extends ModelBase {
    // fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public ModelCuttingBoard() {
        textureWidth = 40;
        textureHeight = 20;

        Shape1 = new ModelRenderer(this, 0, 4);
        Shape1.addBox(0F, 0F, 0F, 10, 1, 9);
        Shape1.setRotationPoint(-5F, 23F, -4F);
        Shape1.setTextureSize(40, 20);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 10, 0);
        Shape2.addBox(0F, 0F, 0F, 8, 1, 1);
        Shape2.setRotationPoint(-4F, 23F, -6F);
        Shape2.setTextureSize(40, 20);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 21, 2);
        Shape3.addBox(0F, 0F, 0F, 3, 1, 1);
        Shape3.setRotationPoint(-5F, 23F, -5F);
        Shape3.setTextureSize(40, 20);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 9, 2);
        Shape4.addBox(0F, 0F, 0F, 3, 1, 1);
        Shape4.setRotationPoint(2F, 23F, -5F);
        Shape4.setTextureSize(40, 20);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 10, 14);
        Shape5.addBox(0F, 0F, 0F, 8, 1, 1);
        Shape5.setRotationPoint(-4F, 23F, 5F);
        Shape5.setTextureSize(40, 20);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity p_78087_7_) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, p_78087_7_);
    }

}
