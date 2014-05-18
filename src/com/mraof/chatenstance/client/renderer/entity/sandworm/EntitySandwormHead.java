package com.mraof.chatenstance.client.renderer.entity.sandworm;

import java.util.ArrayList;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.World;

public class EntitySandwormHead extends EntitySandwormPart
{
	public ArrayList<EntitySandwormPart> parts = new ArrayList<EntitySandwormPart>();
	public EntitySandwormHead(World world)
	{
		super(world);
		this.head = this;
		parts.add(this);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData)
	{
		for(int i = 0; i < 8; i++)
		{
			EntitySandwormBody body = new EntitySandwormBody(this.worldObj, this, parts.size());
			body.setPosition(this.posX + i, this.posY, this.posZ);
			this.worldObj.spawnEntityInWorld(body);
			parts.add(body);
		}
		return entityLivingData;

	}
	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		if(parts.size() > place + 1)
			parts.get(place + 1).updatePartPosition();
	}
}	