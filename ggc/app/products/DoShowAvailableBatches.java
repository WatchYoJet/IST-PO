package ggc.app.products;

import java.util.Collection;

import ggc.core.Batch;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Show available batches.
 */
class DoShowAvailableBatches extends Command<WarehouseManager> {

  DoShowAvailableBatches(WarehouseManager receiver) {
    super(Label.SHOW_AVAILABLE_BATCHES, receiver);
  }

  @Override
  public final void execute() throws CommandException {
    Collection <Batch> batches = _receiver.getBatch();
    for (Batch batch : batches){
      _display.addLine(""+batch.getProduct().getID()
                      +"|"+batch.getPartner()
                      +"|"+Math.round(batch.getPrice())
                      +"|"+batch.getQuantity());
    }
    _display.display();
  }
}
