package ggc.app.products;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
import ggc.app.exception.UnknownPartnerKeyException;
import ggc.core.exception.UnknownKeyException;
import pt.tecnico.uilib.forms.Form;
import ggc.core.Batch;
import java.util.Collection;
//FIXME import classes

/**
 * Show batches supplied by partner.
 */
class DoShowBatchesByPartner extends Command<WarehouseManager> {

  DoShowBatchesByPartner(WarehouseManager receiver) {
    super(Label.SHOW_BATCHES_SUPPLIED_BY_PARTNER, receiver);
    //FIXME maybe add command fields
  }

  @Override
  public final void execute() throws CommandException {
    String partnerId = Form.requestString(Message.requestPartnerKey());
    try {
      Collection <Batch> batches = _receiver.getBatchesByPartner(partnerId);
      for (Batch batch : batches){
        _display.addLine(""+batch.getProduct().getID()
                        +"|"+batch.getPartner()
                        +"|"+Math.round(batch.getPrice())
                        +"|"+batch.getQuantity());
      }
      _display.display();
    }
    catch (UnknownKeyException e) {
      throw new UnknownPartnerKeyException(e.getId());
    }
  }

}
