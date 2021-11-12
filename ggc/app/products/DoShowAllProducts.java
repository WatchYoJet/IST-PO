package ggc.app.products;

import java.util.Collection;

import ggc.core.Batch;
import ggc.core.SimpleProduct;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Show all products.
 */
class DoShowAllProducts extends Command<WarehouseManager> {

  DoShowAllProducts(WarehouseManager receiver) {
    super(Label.SHOW_ALL_PRODUCTS, receiver);
  }

  @Override
  public final void execute() throws CommandException {
    Collection <SimpleProduct> products = _receiver.getProduct();
    for (SimpleProduct product : products){
      _display.addLine(product.toString());
    }
    _display.display();
  }

}
