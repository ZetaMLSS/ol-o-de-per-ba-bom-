package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.network.MinerpModVariables;

public class CelularTickDeQuandoItemNoInventarioProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if ((MinerpModVariables.MapVariables.get(world).canal1_alvo).equals("" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal1_remetente + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).canal1_texto);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).canal1_texto;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if ((MinerpModVariables.MapVariables.get(world).canal2_alvo).equals("" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal2_remetente + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).canal2_texto);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).canal2_texto;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).canal2_alvo = "livre";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if ((MinerpModVariables.MapVariables.get(world).canal3_alvo).equals("" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L5");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L4")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L4");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L3")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L3");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L2")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L2");
				final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L1")));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("Chat_" + MinerpModVariables.MapVariables.get(world).canal3_remetente + "_L1");
				final String _tagValue = ("Player: " + MinerpModVariables.MapVariables.get(world).canal3_texto);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "Ultima_Mensagem_Numero";
				final String _tagValue = MinerpModVariables.MapVariables.get(world).canal3_texto;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			MinerpModVariables.MapVariables.get(world).canal3_alvo = "livre";
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}