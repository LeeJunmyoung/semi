package page_menu;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;

public class MenuViewPreparer implements ViewPreparer {

	@Override
	public void execute(TilesRequestContext tilesContext, AttributeContext attrContext) {

		List<MenuItem> userMenus = new ArrayList<MenuItem>();
		userMenus.add(new MenuItem("MESSAGE", "/HoneyComb/Chatting/Chat_main.chat"));
		
		userMenus.add(new MenuItem("CLOUD", "/HoneyComb/cloud/cloudForm.cloud"));
		userMenus.add(new MenuItem("OPTION", "/HoneyComb/page_layout/Option/Option_home.jsp"));
		
		attrContext.putAttribute("userMenus", new Attribute(userMenus), true);

	}

}
