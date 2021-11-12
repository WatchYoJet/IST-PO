package ggc.app.transactions;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
import pt.tecnico.uilib.forms.Form;
//FIXME import classes

/**
 * 
 */
public class DoRegisterSaleTransaction extends Command<WarehouseManager> {

  public DoRegisterSaleTransaction(WarehouseManager receiver) {
    super(Label.REGISTER_SALE_TRANSACTION, receiver);
    //FIXME maybe add command fields 
  }

  @Override
  public final void execute() throws CommandException {
    String partnerKey = Form.requestString(Message.requestPartnerKey());
    Integer date = Form.requestInteger(Message.requestPaymentDeadline());
    String productKey = Form.requestString(Message.requestProductKey());
    String quantity = Form.requestString(Message.requestAmount());
    _receiver.sale(productKey, quantity, partnerKey, date);
    //FIXME implement command
  }

}
