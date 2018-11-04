package pl.hipcio.hiptonmod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class Hipton extends EntityLiving{

    public Hipton(World world) {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes(); 

        // standard attributes registered to EntityLivingBase
       getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
       getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
       getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
       getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);

        // need to register any additional attributes
       getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
       getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

}