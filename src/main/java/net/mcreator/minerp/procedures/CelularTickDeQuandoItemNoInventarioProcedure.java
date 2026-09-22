package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.network.MinerpModVariables;

public class CelularTickDeQuandoItemNoInventarioProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if ((MinerpModVariables.MapVariables.get(world).numeros_registrados).equals(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).numeros_registrados);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).numeros_registrados;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).numeros_registrados = "";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if ((MinerpModVariables.MapVariables.get(world).numeros_registrados).equals(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).numeros_registrados);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).numeros_registrados;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).numeros_registrados = "";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if ((MinerpModVariables.MapVariables.get(world).numeros_registrados).equals(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero"))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).numeros_registrados + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).numeros_registrados);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).numeros_registrados;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).numeros_registrados = "";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}