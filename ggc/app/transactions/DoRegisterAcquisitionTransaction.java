package ggc.app.transactions;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Register order.
 */
public class DoRegisterAcquisitionTransaction extends Command<WarehouseManager> {

  public DoRegisterAcquisitionTransaction(WarehouseManager receiver) {
    super(Label.REGISTER_ACQUISITION_TRANSACTION, receiver);
    //FIXME maybe add command fields
  }

  @Override
  public final void execute() throws CommandException {
    String partnerKey = Form.requestString(Message.requestPartnerKey());
    String productKey = Form.requestString(Message.requestProductKey());
    String price = Form.requestString(Message.requestPrice());
    String quantity = Form.requestString(Message.requestAmount());
    _receiver.acquisition(productKey, quantity, partnerKey, price);
  }

}
