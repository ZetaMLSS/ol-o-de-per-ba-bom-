package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.network.MinerpModVariables;

public class CelularTickDeQuandoItemNoInventarioProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if ((MinerpModVariables.MapVariables.get(world).canal1_alvo).equals("" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("numero")))) {
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_1")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_1" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_1" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_1" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_1" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_1" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_1" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_1" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_1" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_1" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_1") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_2")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_2" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_2" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_2" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_2" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_2" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_2" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_2" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_2" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_2" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_2") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_3")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_3" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_3" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_3" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_3" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_3" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_3" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_3" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_3" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_3" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_3") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_4")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_4" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_4" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_4" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_4" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_4" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_4" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_4" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_4" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_4" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_4") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_5")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_5" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_5" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_5" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_5" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_5" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_5" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_5" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_5" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_5" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_5") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_6")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_6" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_6" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_6" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_6" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_6" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_6" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_6" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_6" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_6" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_6") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_7")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_7" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_7" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_7" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_7" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_7" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_7" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_7" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_7" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_7" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_6") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_8")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_8" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_8" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_8" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_8" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_8" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_8" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_8" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_8" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_8" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_8") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_9")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_9" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_9" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_9" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_9" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_9" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_9" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_9" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_9" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_9" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_9") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_10")).equals(MinerpModVariables.MapVariables.get(world).canal1_remetente)) {
				{
					final String _tagName = ("Chat_" + "contato_numero_10" + "_L5");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_10" + "_L4")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_10" + "_L4");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_10" + "_L3")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_10" + "_L3");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_10" + "_L2")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_10" + "_L2");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("Chat_" + "contato_numero_10" + "_L1")));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = ("Chat_" + "contato_numero_10" + "_L1");
					final String _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_10") + ": " + MinerpModVariables.MapVariables.get(world).canal1_texto);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else {
				{
					final String _tagName = "notificacao_texto";
					final String _tagValue = MinerpModVariables.MapVariables.get(world).canal1_texto;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "notificacao_numero";
					final String _tagValue = MinerpModVariables.MapVariables.get(world).canal1_remetente;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				MinerpModVariables.MapVariables.get(world).canal1_alvo = "livre";
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}