package ggc.app.transactions;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.app.exception.UnknownTransactionKeyException;
import ggc.core.Transaction;
import ggc.core.WarehouseManager;
import ggc.core.exception.BadEntryException;
import ggc.core.exception.UnknownKeyException;
import pt.tecnico.uilib.forms.Form;
//FIXME import classes

/**
 * Show specific transaction.
 */
public class DoShowTransaction extends Command<WarehouseManager> {

  public DoShowTransaction(WarehouseManager receiver) {
    super(Label.SHOW_TRANSACTION, receiver);
    //FIXME maybe add command fields
  }

  @Override
  public final void execute() throws CommandException, UnknownTransactionKeyException{
    //FIXME implement command
    Integer transactionKey = Form.requestInteger(Message.requestTransactionKey());

    try {
      Transaction transaction = _receiver.getTransaction(transactionKey);
      _display.popup(transaction.toString());
    } catch (UnknownKeyException e) {
      throw new UnknownTransactionKeyException(transactionKey);
    }

  }

}
