package com.mraof.chatenstance.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

import com.mraof.chatenstance.entity.sandworm.EntitySandwormHead;

public class EntityAIWormWander extends EntityAIBase 
{
	private EntityCreature entity;
	private double xPosition;
	private double yPosition;
	private double zPosition;
	private double speed;

	public EntityAIWormWander(EntityCreature par1EntityCreature, double par2)
	{
		this.entity = par1EntityCreature;
		this.speed = par2;
		this.setMutexBits(1);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		if (this.entity.getAge() >= 100)
		{
			return false;
		}
		else if (this.entity.getRNG().nextInt(120) != 0)
		{
			return false;
		}
		else
		{
			EntitySandwormHead head = (EntitySandwormHead) entity;
			Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(this.entity, 10, 7, head.getPointFacing());

			if (vec3 == null)
			{
				return false;
			}
			else
			{
				this.xPosition = vec3.xCoord;
				this.yPosition = vec3.yCoord;
				this.zPosition = vec3.zCoord;
				return true;
			}
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return !this.entity.getNavigator().noPath();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
	}
}
