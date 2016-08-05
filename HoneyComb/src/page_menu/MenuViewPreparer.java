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
		userMenus.add(new MenuItem("menu1", "link1"));
		userMenus.add(new MenuItem("menu2", "link2"));
		userMenus.add(new MenuItem("menu3", "link3"));
		
		attrContext.putAttribute("userMenus", new Attribute(userMenus), true);

	}

}
