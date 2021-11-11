package ggc.app.products;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.util.Collection;

import ggc.app.exception.UnknownProductKeyException;
import ggc.core.Batch;
import ggc.core.WarehouseManager;
import ggc.core.exception.UnknownKeyException;
import pt.tecnico.uilib.forms.Form;
//FIXME import classes

/**
 * Show all products.
 */
class DoShowBatchesByProduct extends Command<WarehouseManager> {

  DoShowBatchesByProduct(WarehouseManager receiver) {
    super(Label.SHOW_BATCHES_BY_PRODUCT, receiver);
    //FIXME maybe add command fields
  }

  @Override
  public final void execute() throws CommandException {
    String productId = Form.requestString(Message.requestProductKey());
    try {
      Collection <Batch> batches = _receiver.getBatchesByProduct(productId);
      for (Batch batch : batches){
        _display.addLine(""+batch.getProduct().getID()
                        +"|"+batch.getPartner()
                        +"|"+Math.round(batch.getPrice())
                        +"|"+batch.getQuantity());
      }
      _display.display();
    }
    catch (UnknownKeyException e) {
      throw new UnknownProductKeyException(e.getId());
    }

  }

}
