package ggc.app.transactions;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.app.exception.UnknownTransactionKeyException;
import ggc.core.WarehouseManager;
import ggc.core.exception.UnknownKeyException;
import pt.tecnico.uilib.forms.Form;
//FIXME import classes

/**
 * Receive payment for sale transaction.
 */
public class DoReceivePayment extends Command<WarehouseManager> {

  public DoReceivePayment(WarehouseManager receiver) {
    super(Label.RECEIVE_PAYMENT, receiver);
    //FIXME add command fields
  }

  @Override
  public final void execute() throws CommandException, UnknownTransactionKeyException {
    //FIXME implement command
    int id = Form.requestInteger(Message.requestTransactionKey());
    try{
      _receiver.receivePayment(id);
    }catch(UnknownKeyException e){
      throw new UnknownTransactionKeyException(id);
    }
  }
}
