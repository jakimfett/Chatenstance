package com.mraof.chatenstance.entity.sandworm;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySandwormBody extends EntityLiving implements IMob
{
	public EntitySandwormHead head;
	
	public EntitySandwormBody(World world)
	{
		super(world);
		this.setSize(2F, 2F);
	}

	public EntitySandwormBody(EntitySandwormHead entitySandwormHead, int place)
	{
		super(entitySandwormHead.worldObj);
		this.setSize(2F, 2F);
		this.head = entitySandwormHead;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		if(this.head != null)
			super.writeEntityToNBT(tagCompound);
		else
			this.setDead();
	}

	@Override
	public void onUpdate() 
	{
		super.onUpdate();
		if(this.head == null || (this.head).isDead)
		{
			this.setDead();
		}
	}
	
	@Override
	protected boolean canDespawn()
	{
		return false;
	}
	public void setWidth(float width)
	{
		setSize(width, width);
	}
}
