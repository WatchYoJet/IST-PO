package ggc.app.lookups;

import java.util.Collection;

import ggc.core.Batch;
import ggc.core.WarehouseManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Lookup products cheaper than a given price.
 */
public class DoLookupProductBatchesUnderGivenPrice extends Command<WarehouseManager> {

  public DoLookupProductBatchesUnderGivenPrice(WarehouseManager receiver) {
    super(Label.PRODUCTS_UNDER_PRICE, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    double price = Form.requestReal(Message.requestPriceLimit());
    Collection<Batch> batches = _receiver.lookupProductBatchesUnderGivenPrice(price);
    for (Batch batch : batches) {
      _display.addLine(""+batch.getProduct().getID()+"|"+batch.getPartner()+"|"+Math.round(batch.getPrice())+"|"+batch.getQuantity());
    }
    _display.display();
  }

}
